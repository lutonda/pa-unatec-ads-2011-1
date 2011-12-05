var _idUserAtual = 0;
var _nmUser;

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

        $('ul#UsuarioPendente li').each(function() {
            var id = $('#idUsuarioAmigo',this);
            var launch = $('div a', this);
            if (launch.size() > 0) {
                $('div a:first-child', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserAceiteOnClick));
                $('div a:last-child', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserNaoAgoraOnClick));
            }
        });

        $('ul#usuariosList li').each(function() {
            var id = $('#idUsuarioAmigo',this).text();
            var launch = $('div a', this);
            if (launch.size() > 0) {
                $('div a', this).bind('click', id, $.createDelegate(ini, CtrlUsuario.prototype._btnUserRemoverOnClick));
            }         
        });
    },

    _btnUserAceiteOnClick: function(value){
        _idUserAtual = value.data.text();
        _nmUser = $('ul#UsuarioPendente li#idUsuarioAmigo' + _idUserAtual +' span#nmUsuarioAmigo').text();
        var _idUser = $('ul#UsuarioPendente li#idUsuarioAmigo' + _idUserAtual +' span#idUser').text();
        this.dataBindMvc('../inicio/ctrlUsuario.do', {
            idAmigoUsuario : _idUserAtual,
            controleTipo: 1,
            nmUser: _nmUser,
            idUser: _idUser
        }, this._postUserAceiteOnSuccess);
    },
    
    _btnUserNaoAgoraOnClick: function(value){
        _idUserAtual = value.data.text();
        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : _idUserAtual,
            controleTipo: 0
        }, this._postUserRecusaOnSuccess);
    },

    _btnUserRemoverOnClick: function(value){
        _idUserAtual = value.data;
        var msg = confirm('Deseja remover?');
        if(msg){
            this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
                idAmigoUsuario : _idUserAtual,
                controleTipo: 0
            }, this._postUserRemoverOnSuccess);
        }
    },

    _postUserAceiteOnSuccess: function(value){
        var nmusuario = $('#idUsuarioAmigo'+_idUserAtual+' #nmUsuarioAmigo').text()

        $('ul#usuariosList').append('<li id="idUsuarioAmigo'+_idUserAtual+'"></li>')
        $('ul#UsuarioPendente #idUsuarioAmigo'+_idUserAtual+' .conteudo').appendTo('#usuariosList li#idUsuarioAmigo'+_idUserAtual);
        $('ul#usuariosList li#idUsuarioAmigo'+_idUserAtual+' .conteudo div#ctrlA').remove();
        $('ul#usuariosList li#idUsuarioAmigo'+_idUserAtual+' .conteudo div#ctrlB').attr('style', 'float: right;');
        $('ul#usuariosList li#idUsuarioAmigo'+_idUserAtual +' .conteudo div a').unbind('click');

        $('ul#usuariosList li#idUsuarioAmigo'+_idUserAtual +' .conteudo div a').bind('click', _idUserAtual, $.createDelegate(this, CtrlUsuario.prototype._btnUserRemoverOnClick));
        $('ul#UsuarioPendente li#idUsuarioAmigo'+_idUserAtual).append('<span class="conteudo"><a href="/AppWebFrontEnd/site/inicio/perfil.html?id=5">'+nmusuario+'</a> foi adicionado.<br/><br/><div class="cb"></div></span>');
        
        $('ul#UsuarioPendente li.nivelA').each(function() {
            $('div.cb' , this).attr('style', '');
            $('div.cb' , this).attr('style', 'border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px');
        });
        
        $('ul#usuariosList li').each(function() {
            $('div.cb' , this).attr('style', '');
            $('div.cb' , this).attr('style', 'border-bottom-color: #ececed; border-bottom-style: solid; border-bottom-width: 1px; margin-bottom: 10px');
        });
        
        $('ul#UsuarioPendente li.nivelA:last-child .conteudo div.cb').attr('style', '');
        $('ul#usuariosList li:last-child .conteudo div.cb').attr('style', '');
    },

    _postUserRecusaOnSuccess: function(value){

        $('ul#UsuarioPendente li#idUsuarioAmigo'+_idUserAtual).remove();
        $('ul#UsuarioPendente li.nivelA:last-child .conteudo div.cb').attr('style', '');
    },

    _postUserRemoverOnSuccess: function(value){

        $('ul#usuariosList li#idUsuarioAmigo'+_idUserAtual).remove();
        $('ul#usuariosList li:last-child .conteudo div.cb').attr('style', '');
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


