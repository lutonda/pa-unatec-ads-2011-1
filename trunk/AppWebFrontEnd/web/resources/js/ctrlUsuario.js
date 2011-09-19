var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _novaNot = false;


CtrlUsuario = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

CtrlUsuario.Load = function(){
    var _dados = new CtrlUsuario();
    _dados.initialize();
    return _dados;
}

CtrlUsuario.prototype = {

    initialize: function() {
        //clicks btn
        $('#btnUserAceite').bind('click', '', $.createDelegate(this, this._btnUserAceiteOnClick));
        $('#btnUserNaoAgora').bind('click', '', $.createDelegate(this, this._btnUserNaoAgoraOnClick));

    },

    _btnUserAceiteOnClick: function(value){

       this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : $('#idUsuarioAmigo').text(),
            aceite: 1
        }, this._postUserAceiteOnSuccess);
    },

    _btnUserNaoAgoraOnClick: function(value){

       this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : $('#idUsuarioAmigo').text(),
            aceite: 0
        }, this._postUserRecusaOnSuccess);
    },

    _postUserAceiteOnSuccess: function(value){
        var nmusuario = $('#nmUsuarioAmigo').text();
        $('ul#usuariosList li:last-child div.cb').attr('style', 'border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px');
        $('#UsuarioPendente li#idUsuarioAmigo' + $('#idUsuarioAmigo').text()).appendTo('#usuariosList');
        $('#UsuarioPendente').text( nmusuario + ' e seu novo amigo, visite seu perfil e boas trocas');

    },
    _postUserRecusaOnSuccess: function(value){

         $('#UsuarioPendente li#idUsuarioAmigo' + $('#idUsuarioAmigo').text()).remove();
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
    CtrlUsuario.Load();
});


