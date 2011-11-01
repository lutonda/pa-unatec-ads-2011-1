var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;

var _tipoFiltro = "";
var _idGenero = -1;


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

        //clicks btn
        $('#btnGeneros').bind('click', 'G', $.createDelegate(this, this._btnBuscarOnClick));
        $('#btnLancamentos').bind('click', 'L', $.createDelegate(this, this._btnBuscarOnClick));
        $('#btnNovidades').bind('click', 'N', $.createDelegate(this, this._btnBuscarOnClick));

    },

    _btnBuscarOnClick: function(value){
        //console.log(value);
        _pagina = 1;
        _tipoFiltro = value.data;
        this.dataBindMvc('listaFiltroJogos.do', {
            idGenero : _idGenero,
            tipoFiltro : _tipoFiltro,
            qtd : 10,
            pagina: _pagina
        }, this._listaJogoOnSuccess);
    },

    _listaJogoOnSuccess: function(value){
        $('#listaJogos li:not(:first)').remove();

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

        this.dataBindMvc('listaJogos.do', {
            id : (_busca)? 0:$('#idUser').text(), // ($('#txtBuscarJogo').val() != "")? 0:$('#idUser').text(),
            qtd : 10,
            pagina: _pagina,
            busca: (_busca)? $('#txtBuscarJogo').val():"",
            desejo: _desejo,
            console: _console,
            nivelOfetas: _nivelOfetas
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