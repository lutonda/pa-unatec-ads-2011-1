var _pagina = 1;
var _totalItens = 0;
var _totalPg = 0;
var _oferta = false;
var _tipo = 0;

Usuario = function(){
    this._data = null;
    this._dataUrl = null;
    this._type = null;
    this._dataSource = null;
    this._handlerSuccess = null;
}

Usuario.Load = function(){
    var _dados = new Usuario();
    _dados.initialize();
    return _dados;
}

Usuario.prototype = {

    initialize: function() {
        this.dataBindMvc('listaUsuarioJogo.do', {
            id : $('#idJogo').text(),
            qtd : 10,
            pagina: _pagina,
            ofertados: _oferta,
            tipo: _tipo
        }, this._listaUsuarioOnSuccess);

        $('#btnUserOferta').bind('click', 'O', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnUserPro').bind('click', 'P', $.createDelegate(this, this._btnFiltroOnClick));
        $('#btnUserInt').bind('click', 'I', $.createDelegate(this, this._btnFiltroOnClick));
    },

    _btnFiltroOnClick: function(value){
        _pagina = 1;

        switch (value.data) {
            case 'O':
                _oferta = true;
                break;
            case 'P':
                _oferta = false;
                _tipo = 1;
                break;
            case 'I':
                _oferta = false;
                _tipo = 2;
                break;
            default:
                break;
        }

        this.dataBindMvc('listaUsuarioJogo.do', {
            id : $('#idJogo').text(),
            qtd : 10,
            pagina: _pagina,
            ofertados: _oferta,
            tipo: _tipo
        }, this._listaUsuarioOnSuccess);
    },

    _listaUsuarioOnSuccess: function(value){
        $('#listaUsuarios li').remove();

         var dados = value.split("|");
        _totalItens = dados[1];
        $('#listaUsuarios').append(dados[0]);

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

        this.dataBindMvc('listaUsuarioJogo.do', {
            id : $('#idJogo').text(),
            qtd : 10,
            pagina: _pagina,
            ofertados: _oferta,
            tipo: _tipo
        }, this._listaUsuarioOnSuccess);
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
    Usuario.Load();
});