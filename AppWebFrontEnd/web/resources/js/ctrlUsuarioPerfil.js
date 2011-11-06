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

        _idUserAtual = $('#idUserAmigo')

        if ($('#btnRspSolitacao').length == 1)
            $('#btnRspSolitacao').bind('click', _idUserAtual, $.createDelegate(this, this._btnRspSolitacaoOnClick));
        if ($('#btnRemoverSolitacao').length == 1)
            $('#btnRemoverSolitacao').bind('click', _idUserAtual, $.createDelegate(this, this._btnUserRemoverOnClick));
//        if ($('#btnIgn').length == 1)
//            $('#btnIgn').bind('click', _idUserAtual, $.createDelegate(this, this._btnUserIgnOnClick));
//        if ($('#btnIgnDes').length == 1)
//            $('#btnIgnDes').bind('click', _idUserAtual, $.createDelegate(this, this._btnUserIgnDesOnClick));
        if ($('#btnRspCancelar').length == 1)
            $('#btnRspCancelar').bind('click', _idUserAtual, $.createDelegate(this, this._btnRspCancelarOnClick));
        if ($('#btnAdicionar').length == 1)
        {
            _idUserAtual = $('#idUser')
            $('#btnAdicionar').bind('click', _idUserAtual, $.createDelegate(this, this._btnAdicionarOnClick));
        }
        
    },
    
    _btnAdicionarOnClick: function(value){
        _idUserAtual = value.data.text();
        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : _idUserAtual,
            controleTipo: 2
        }, this._postAdicionarOnSuccess);
    },

    _btnRspSolitacaoOnClick: function(value){
        _idUserAtual = value.data.text();
        var msg = confirm('Adicionar?');
        if(msg){
            this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
                idAmigoUsuario : _idUserAtual,
                controleTipo: 1
            }, this._postRspSolitacaoOnSuccess);
        }
    },
    
    _btnRspCancelarOnClick: function(value){
        _idUserAtual = value.data.text();
        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
            idAmigoUsuario : _idUserAtual,
            controleTipo: 0
        }, this._postRspCancelarOnSuccess);
    },
    
//    _btnUserIgnDesOnClick: function(value){
//        _idUserAtual = value.data.text();
//        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
//            idAmigoUsuario : _idUserAtual,
//            controleTipo: 4
//        }, this._postIgnorarDesOnSuccess);
//    },

    _btnUserRemoverOnClick: function(value){
        _idUserAtual = value.data.text();
        var msg = confirm('Deseja remover?');
        if(msg){
            this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
                idAmigoUsuario : _idUserAtual,
                controleTipo: 0
            }, this._postUserRemoverOnSuccess);
        }
    },
    
//    _btnUserIgnOnClick: function(value){
//        _idUserAtual = value.data.text();
//        this.dataBindMvc('../../site/inicio/ctrlUsuario.do', {
//            idAmigoUsuario : _idUserAtual,
//            controleTipo: 3
//        }, this._postIgnorarOnSuccess);
//    },
    
//    _postIgnorarOnSuccess: function(value){
//        $('#acaoRsp').text('');
//        $('#acaoRsp').append('Notificações Ignoradas!')
//    },
//    _postIgnorarDesOnSuccess: function(value){
//        $('#acaoRsp').text('');
//        $('#acaoRsp').append('Notificações Ignoradas Desfeita!')
//    },
    
    _postAdicionarOnSuccess: function(value){
        $('#acaoRsp a').remove()
        $('#acaoRsp').append('Solicitação Enviada!')
    },

    _postRspSolitacaoOnSuccess: function(value){
        $('#acaoRsp a').remove()
        $('#acaoRsp').append('Solicitação Aceita!')
    },

    _postRspCancelarOnSuccess: function(value){
        $('#acaoRsp a').remove()
        $('#acaoRsp').append('Solicitação Cancelada.')
    },

    _postUserRemoverOnSuccess: function(value){
        $('#acaoRsp').text('');
        $('#acaoRsp').append('Amigo Removido.')
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


