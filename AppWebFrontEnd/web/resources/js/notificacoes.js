var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _busca = false;


Notificacoes = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

Notificacoes.Load = function(){
    var _dados = new Notificacoes();
    _dados.initialize();
    return _dados;
}

Notificacoes.prototype = {

    initialize: function() {

    this.dataBindMvc('listaNotificacao.do', {
            idUsuario : $('#idUser').text(),
            qtd : 10,
            pagina: _pagina
        }, this._listaNotificacaoOnSuccess);

    },

    _listaNotificacaoOnSuccess: function(value){

        
        //$('#notificacao_usuario li:not(:first)').remove();

        var dados = value.split("|");
        _totalItens = dados[1];


       $('#notificacao').append(dados[0]);

        console.log(dados);

        /*
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
            */
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
    Notificacoes.Load();
});

