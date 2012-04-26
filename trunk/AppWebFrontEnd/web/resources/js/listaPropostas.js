var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _oferta = false;
var _tipo = 0;


Proposta = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

Proposta.Load = function(){
    var _dados = new Proposta();
    _dados.initialize();
    return _dados;
}

Proposta.prototype = {

    initialize: function() {
        var ini = this;
        $('#btnPropFinalizadas').bind('click', 'F', $.createDelegate(this, this._listaPropostasOnClick));
        $('#btnPropAndamento').bind('click', 'A', $.createDelegate(this, this._listaPropostasOnClick));
        $('#btnPropAberto').bind('click', 'P', $.createDelegate(this, this._listaPropostasOnClick));
        
        $("a.btnFimTroca").live("click", function () {
            //console.log(this);
            
            ini.dataBindMvc('../inicio/trocaJogo.do', {
                idTroca : this.id
            }, this._finalizarOnSuccess);
        });
    },
    _finalizarOnSuccess: function(value){
        //$('#btn_' + value.id).hide();
        //console.log(value);
    },
       
    _listaPropostasOnClick: function(value){
        this.dataBindMvc('../inicio/listaTrocasJogos.do', {
            id : $('#idUser').text(),
            tipo: value.data,
            qtd : 10,
            pagina: _pagina
        }, this._listaPropostasOnSuccess);
        
        var myClose=function(hash) {
            hash.o.remove();
            hash.w.hide();
            $('#cxTrocas ul li').remove();
        }; 
        
        $('#cxTrocas').jqm({
            onHide:myClose,
            overlay:80,
            overlayClass:'bgModal',
            closeClass:'btnFecharModal'
        }).jqmShow();
    },

    _listaPropostasOnSuccess: function(value){
        var dados = value.split("|");
        _totalItens = dados[1];
        $('#cxTrocas ul').append(dados[0]);

        var menos = _pagina - 1;
        var mais = _pagina + 1;

        _totalPg = Math.ceil(_totalItens / 10);

        if(_totalPg != 0 && _totalItens >= 10)
            $('#paginacao').show();
        else
            $('#paginacao').hide();

        if (mais <= _totalPg)
            $('#proximo').bind('click', mais, $.createDelegate(this,  this._paginacaoOnClick));
        else
            $('#proximo').unbind('click');

        if(menos > 0)
            $('#anterior').bind('click', menos, $.createDelegate(this,  this._paginacaoOnClick));
        else
            $('#anterior').unbind('click');
    },

    _paginacaoOnClick: function(value){
        _pagina = value.data;

    //        this.dataBindMvc('listaUsuarioJogo.do', {
    //            id : $('#idJogo').text(),
    //            qtd : 10,
    //            pagina: _pagina,
    //            ofertados: _oferta,
    //            tipo: _tipo
    //        }, this._listaUsuarioOnSuccess);
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
    Proposta.Load();
});