var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;

var _tipoFiltro = "";
var _tipoMais = "";
var _idTipo = 4;
var _tipoCategoria = "";


FiltroJogos = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

FiltroJogos.Load = function(){
    var _dados = new FiltroJogos();
    _dados.initialize();
    return _dados;
}

FiltroJogos.prototype = {

    initialize: function() {
        
        var ini = this;

        $('ul#lsGeneros li').each(function() {
            var launch = $('a', this);
            var id = launch.attr('rel');
            if (launch.size() > 0) {
                $(launch).bind('click', launch, $.createDelegate(ini, FiltroJogos.prototype._btnFiltroOnClick));
            }
        });
        
        $('ul#lsEditoras li').each(function() {
            var launch = $('a', this);
            var id = launch.attr('rel');
            if (launch.size() > 0) {
                $(launch).bind('click', launch, $.createDelegate(ini, FiltroJogos.prototype._btnFiltroOnClick));
            }
        });
        
        $('ul#lsDesenv li').each(function() {
            var launch = $('a', this);
            var id = launch.attr('rel');
            if (launch.size() > 0) {
                $(launch).bind('click', launch, $.createDelegate(ini, FiltroJogos.prototype._btnFiltroOnClick));
            }
        });

        //clicks btn
        $('#btnLancamentos').bind('click', 'L', $.createDelegate(this, this._btnFiltroSplOnClick));
        $('#btnNovidades').bind('click', 'N', $.createDelegate(this, this._btnFiltroSplOnClick));
        
        $('#btnMaisDesejados').bind('click', 'D', $.createDelegate(this, this._btnMaisrOnClick));
        $('#btnMaisTrocados').bind('click', 'T', $.createDelegate(this, this._btnMaisrOnClick));
        $('#btnMaisQualificados').bind('click', 'Q', $.createDelegate(this, this._btnMaisrOnClick));
        
        $("ul.dropdown li").hover(function(){
    
            $(this).addClass("hover");
            $('ul:first',this).css('visibility', 'visible');
    
        }, function(){
    
            $(this).removeClass("hover");
            $('ul:first',this).css('visibility', 'hidden');
    
        });
    
        $("ul.dropdown li ul li:has(ul)").find("a:first").append(" &raquo; ");
    },

    _btnFiltroOnClick: function(value){
        _pagina = 1;
        _idTipo = value.data.attr('rel');
        _tipoFiltro = value.data.attr('rev');
        this.dataBindMvc('listaFiltroJogos.do', {
            idTipo : _idTipo,
            tipoFiltro : _tipoFiltro,
            tipoCategoria : _tipoCategoria,
            qtd : 10,
            pagina: _pagina
        }, this._listaJogoOnSuccess);
    },
    
    _btnFiltroSplOnClick: function(value){
        _pagina = 1;
        _idTipo = -1;
        _tipoFiltro = value.data;
        this.dataBindMvc('listaFiltroJogos.do', {
            idTipo : _idTipo,
            tipoFiltro : _tipoFiltro,
            tipoCategoria : _tipoCategoria,
            qtd : 10,
            pagina: _pagina
        }, this._listaJogoOnSuccess);
    },
    
    _btnMaisrOnClick: function(value){
        _pagina = 1;
        _tipoMais = value.data;
        this.dataBindMvc('listaMaisJogos.do', {
            tipoMais : _tipoMais,
            qtd : 10,
            pagina: _pagina
        }, this._listaJogoSemPaginacaoOnSuccess);
    },
    
    _listaJogoSemPaginacaoOnSuccess: function(value){
        //$('#listaJogos li:not(:first)').remove();
        $('#listaJogos li').remove();

        var dados = value.split("|");
        $('#listaJogos').append(dados[0]);
        $('#paginacao').hide();
    },

    _listaJogoOnSuccess: function(value){
        //$('#listaJogos li:not(:first)').remove();
        $('#listaJogos li').remove();

        var dados = value.split("|");
        _totalItens = dados[1];
        $('#listaJogos').append(dados[0]);
        
        var menos = _pagina - 1;
        var mais = _pagina + 1;

        _totalPg = Math.ceil(_totalItens / 10);
        if(_totalPg != 0 && _totalItens >= 11)
            $('#paginacao').show();
        else
            $('#paginacao').hide();
        
        if (mais <= _totalPg)
            $('#prox').bind('click', mais, $.createDelegate(this,  this._paginacaoOnClick));
        else
            $('#prox').unbind('click');

        if(menos > 0)
            $('#ant').bind('click', menos, $.createDelegate(this,  this._paginacaoOnClick));
        else
            $('#ant').unbind('click');
    },

    _paginacaoOnClick: function(value){
        _pagina = value.data;

        this.dataBindMvc('listaFiltroJogos.do', {
            idTipo : _idTipo,
            tipoFiltro : _tipoFiltro,
            tipoCategoria : _tipoCategoria,
            qtd : 10,
            pagina: _pagina
        }, this._listaJogoOnSuccess);
    },

    dataBindMvc: function(dataUrl, data, handlerSuccess){
        $.ajax( {
            url : dataUrl,
            data : data,
            success: $.createDelegate(this, handlerSuccess),
            error: $.createDelegate(this, this._dataBind_OnFailure)
        });
    },

    executeBind: function(dataUrl, data, type, handlerSuccess) {
        this._type = type;
        this._dataUrl = dataUrl;
        this._data = data;
        this._handlerSuccess = handlerSuccess;
        this.dataBind();
    },

    dataBind: function() {
        $.ajax({
            type: this._type,
            cache: false,
            data: this._data,
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            url: this._dataUrl,
            success: $.createDelegate(this, this._handlerSuccess),
            error: $.createDelegate(this, this._dataBind_OnFailure)
        });
    },

    _dataBind_OnFailure: function(e) {

    }
}

$(document).ready(function() {
    FiltroJogos.Load();
});