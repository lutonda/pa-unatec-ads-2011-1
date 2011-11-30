var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _novaNot = false;


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
        
        if(parseURL(window.location.pathname).file == "index.html")
            inputText('txtNotificacao','Chame Alguem para Trocar Jogos');
        else
            inputText('txtNotificacao','Faça um Comentário');
    },

    _btnEnviarNotOnClick: function(value){
        this.dataBindMvc('enviarNotificacao.do', {
            idUsuario : ($('#idUserVisitante').text() == "")? $('#idUser').text():$('#idUserVisitante').text(),
            dsNotificacao: $('#txtNotificacao').val(),
            broadcast: ($('#idUserVisitante').text() == "")? 1:0
        }, this._enviarNotificacaoOnSuccess);
    
        if(parseURL(window.location.pathname).file == "index.html")
            inputText('txtNotificacao','Chame Alguem para Trocar Jogos');
        else
            inputText('txtNotificacao','Faça um Comentário');
    },

    _enviarNotificacaoOnSuccess: function(value){
        _novaNot = true;
        this.dataBindMvc('listaNotificacao.do', {
            idUsuario : $('#idUser').text(),
            qtd : 10,
            pagina: _pagina
        }, this._listaNotificacaoOnSuccess);
    },

    _listaNotificacaoOnSuccess: function(value){

        if (_novaNot){
            $('#notificacao li:not(:first)').remove();
        }
        
        var dados = value.split("|");
        _totalItens = dados[1];
        $('#notificacao').append(dados[0]);
        
        var menos = _pagina - 1;
        var mais = _pagina + 1;

        _totalPg = Math.ceil(_totalItens / 10);

        if (mais <= _totalPg){
            $('#btnMais').bind('click', mais, $.createDelegate(this,  this._paginacaoNotOnClick));
            $('#btnMais').show();
        }
        else
        {
            $('#btnMais').unbind('click');
            $('#btnMais').hide();
        }
        if (_pagina != 1)
            $(window).scrollTop($(document).height());
    },

    _paginacaoNotOnClick: function(value){
        _pagina = value.data;
        _novaNot = false;
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

