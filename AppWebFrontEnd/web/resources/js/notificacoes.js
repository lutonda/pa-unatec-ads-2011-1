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


        //clicks btn
        $('#btnEnviarNotificacao').bind('click', '', $.createDelegate(this, this._btnEnviarNotOnClick));


        inputText('txtNotificacao','Chame Alguem pra Trocar Jogos');
    },

    _btnEnviarNotOnClick: function(value){
        this.dataBindMvc('enviarNotificacao.do', {
            idUsuario : $('#idUser').text(),
            dsNotificacao: $('#txtNotificacao').val()
        }, this._enviarNotificacaoOnSuccess);
        inputText('txtNotificacao','Chame Alguem pra Trocar Jogos');
    },

    _enviarNotificacaoOnSuccess: function(value){

        this.dataBindMvc('listaNotificacao.do', {
            idUsuario : $('#idUser').text(),
            qtd : 10,
            pagina: _pagina
        }, this._listaNotificacaoOnSuccess);
    },

    _listaNotificacaoOnSuccess: function(value){

        
        //$('#notificacao li:not(:first)').remove();

        var dados = value.split("|");
        _totalItens = dados[1];
        $('#notificacao').append(dados[0]);
        
        var menos = _pagina - 1;
        var mais = _pagina + 1;

        _totalPg = Math.ceil(_totalItens / 10);

        if (mais <= _totalPg){
        }
        else
            $('#proximo').unbind('click');
            
        if(menos > 0)
            $('#anterior').bind('click', menos, $.createDelegate(this,  this._paginacaoNotOnClick));
        
        else
           $('#anterior').unbind('click');
            
    },

    _paginacaoNotOnClick: function(value){
        _pagina = value.data;
        this.dataBindMvc('listaNotificacao.do', {
            idUsuario : $('#idUser').text(),
            qtd : 10,
            pagina: _pagina
        }, this._listaNotificacaoOnSuccess);
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

