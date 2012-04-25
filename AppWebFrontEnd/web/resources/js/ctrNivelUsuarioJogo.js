var _idUserAtual = 0;
var _nmUser;

CtrlNivel = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

CtrlNivel.Load = function(){
    var _dados = new CtrlNivel();
    _dados.initialize();
    return _dados;
}

CtrlNivel.prototype = {

    initialize: function() {
        $('#btnTenho').bind('click', 'I', $.createDelegate(this, this._btnSetTenhoOnClick));
        $('#btnTenhoAlterar').bind('click', 'A', $.createDelegate(this, this._btnSetTenhoOnClick));
        $('#btnTenhoExcluir').bind('click', 'E', $.createDelegate(this, this._btnSetTenhoOnClick));
        $('#btnTenhoVisualizar').bind('click', 'V', $.createDelegate(this, this._btnSetTenhoOnClick));

        $('#btnDesejo').bind('click', 'I', $.createDelegate(this, this._btnSetDesejoOnClick));
        $('#btnDesejoExcluir').bind('click', 'E', $.createDelegate(this, this._btnSetDesejoOnClick));
    },

    _btnSetTenhoOnClick: function(value){

        //        this.dataBindMvc('setTenho.do', {
        //            idUsuario : $('#idUser').text(),
        //            idJogo: $('#idJogo').text(),
        //            tipoPar: value.data
        //        }, this._postTenhoOnSuccess);


        //$('input[name="star1"]')

        $("#stars-wrapper1").stars({
            showTitles: true,
            cancelShow: false,
            captionEl: $("#stars1-cap")
        });
        $("#stars-wrapper2").stars({
            showTitles: true,
            cancelTitle: 'Sem Manual',
            captionEl: $("#stars2-cap")
        });
        $("#stars-wrapper3").stars({
            showTitles: true,
            cancelTitle: 'Sem Capa',
            captionEl: $("#stars3-cap")
        });

        var myClose=function(hash) {
            hash.o.remove();
            hash.w.hide();
        //$('#cxTrocas ul li').remove();
        };

        $('#cxEstadoJogo').jqm({
            onHide:myClose,
            overlay:80,
            modal: true,
            overlayClass:'bgModal',
            closeClass:'btnFecharModal'
        }).jqmShow();


    },

    _btnSetDesejoOnClick: function(value){
        this.dataBindMvc('setDesejo.do', {
            idUsuario : $('#idUser').text(),
            idJogo: $('#idJogo').text(),
            tipoPar: value.data
        }, this._postDesejoOnSuccess);
    },

    _postDesejoOnSuccess: function(value){
        var setText;
        if (value == 'I')
            setText = '<span>Este Jogo esta em sua lista de Desejos (<a id="btnDesejoExcluir" href="javascript:void(0);">Excluir da Lista</a>)</span>';
        else if (value == 'E')
            setText = '<span><a id="btnTenho" href="javascript:void(0);">Tenho</a> / <a id="btnDesejo" href="javascript:void(0);">Desejo</a></span>';

        $('#dvNivel span').remove();
        $('#dvNivel').append(setText);

        this.initialize();
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
    CtrlNivel.Load();
});


