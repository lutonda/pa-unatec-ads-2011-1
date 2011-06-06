var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _busca = false;

function inputText(id, texto){

    $('#' + id).val(texto);

    $('#' + id).keypress(function() {
        $(this).attr("style", "color: #333333");
    });

    $('#' + id).focus(function() {
        if($(this).val() == texto)
            $(this).val("");
    });

    $('#' + id).blur(function() {
        if($(this).val() == '')
            $(this).val(texto);

        $(this).attr("style", "color: #cccccc");

        if($(this).val() != texto)
            $(this).attr("style", "color: #333333");
    });
}

Jogo = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

Jogo.Load = function(){
    var _dados = new Jogo();
    _dados.initialize();
    return _dados;
}

Jogo.prototype = {

    initialize: function() {
        this.dataBindMvc('listaJogos.do', {
            id : $('#idUser').text(),
            qtd : 10,
            pagina: _pagina,
            busca: ""
        }, this._listaJogoOnSuccess);

        this.dataBindMvc('listaTituloJogo.do', '', this._listaTituloJogoOnSuccess);

        //clicks btn
        $('#btnBuscar').bind('click', '', $.createDelegate(this, this._btnBuscarOnClick));
        $('#btnMeusJogos').bind('click', 'meusJogos', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnMeusDesejos').bind('click', 'meusDesejos', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnPs3').bind('click', 'ps3', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnWii').bind('click', 'wii', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnXbox').bind('click', 'xbox', $.createDelegate(this, this._btnFiltroOnClick));

        inputText('txtBuscarJogo','Digite o nome do Jogo');
        
    },

    _btnBuscarOnClick: function(value){
        _pagina = 1;
        _busca = true;
        this.dataBindMvc('listaJogos.do', {
            id : 0,
            qtd : 10,
            pagina: _pagina,
            busca: $('#txtBuscarJogo').val()
        }, this._listaJogoOnSuccess);
    },

    _btnFiltroOnClick: function(value){
        _pagina = 1;
        this.dataBindMvc('listaJogos.do', {
            id : 0,
            qtd : 10,
            pagina: _pagina,
            busca: ""
        }, this._listaJogoOnSuccess);
    },

    _listaTituloJogoOnSuccess: function(value){
        var dados = value.split(",");
        $("input#txtBuscarJogo").autocomplete({
            source: dados
        });
    },

    _listaJogoOnSuccess: function(value){
        $('#listaJogos li:not(:first)').remove();

        var dados = value.split("|");
        _totalItens = dados[1];
        $('#listaJogos').append(dados[0]);
        
        var menos = _pagina - 1;
        var mais = _pagina + 1;

        _totalPg = Math.ceil(_totalItens / 10);
        
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
            busca: (_busca)? $('#txtBuscarJogo').val():""
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
    Jogo.Load();
});