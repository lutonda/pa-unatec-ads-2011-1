var _idUserAtual = 0;
var _nmUser;
var inin;


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
        var ini = this;
        inin = ini;

        $('ul#UsuarioPendente li').each(function() {
            var id = $('#idUsuarioAmigo',this);
            var launch = $('div a', this);
            if (launch.size() > 0) {
                $('div a:first-child', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserAceiteOnClick));
                $('div a:last-child', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserNaoAgoraOnClick));
            }
        });

        $('ul#usuariosList li').each(function() {
            var id = $('#idUsuarioAmigo',this);
            var launch = $('div a', this);
            if (launch.size() > 0) {
                $('div a', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserRemoverOnClick));
                }         
        });
    },

    _btnUserAceiteOnClick: function(value){
        _idUserAtual = value.data.text();
        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : _idUserAtual,
            aceite: 1
        }, this._postUserAceiteOnSuccess);
    },

    _btnUserNaoAgoraOnClick: function(value){
        _idUserAtual = value.data.text();
        var msg = confirm('Confirma Exclusao ?');
        if(msg){
            this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
                idAmigoUsuario : _idUserAtual,
                aceite: 0
            }, this._postUserRecusaOnSuccess);
        }
    },

    _btnUserRemoverOnClick: function(value){
        _idUserAtual = value.data.text();
        var msg = confirm('Confirma Exclusao deste amigo?');
        if(msg){
            this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
                idAmigoUsuario : _idUserAtual,
                aceite: 0
            }, this._postUserRemoverOnSuccess);
        }
    },

    _postUserAceiteOnSuccess: function(value){
        var nmusuario = $('#idUsuarioAmigo'+_idUserAtual+' #nmUsuarioAmigo').text()

        $('ul#usuariosList li:last-child div.cb').attr('style', 'border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px');
        $('#idUsuarioAmigo'+_idUserAtual).appendTo('ul#usuariosList');
        $('#idUsuarioAmigo'+_idUserAtual+ ' div#ctrlA').remove();
        //$('#idUsuarioAmigo'+_idUserAtual+ ' div#ctrlB').attr('style', 'float: right;');
        $('#idUsuarioAmigo'+_idUserAtual+ ' div#ctrlB').replaceWith('<div id="r" style="float: right;"><a href="javascript:void(0)" id="btnUserRemover">Remover</a></div>');
        $('#UsuarioPendente').append('<li><a href="/AppWebFrontEnd/site/inicio/perfil.html?id=5">'+nmusuario+'</a> foi adicionado.</li>');

    },

    _postUserRecusaOnSuccess: function(value){

        $('#idUsuarioAmigo'+_idUserAtual).remove();
    },

    _postUserRemoverOnSuccess: function(value){

        $('#idUsuarioAmigo'+_idUserAtual).remove();
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


