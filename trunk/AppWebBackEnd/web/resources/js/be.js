/**
* Inicializa as funções assim que os elementos (DOM) são carregados

jQuery(function() {
	BaseProject._init();
});
*/

/**
* Função Menu Simples Drop-Down
*/
var timeout = 500;
var closetimer = 0;
var ddmenuitem = 0;

function jsddm_open() {
    jsddm_canceltimer();
    jsddm_close();
    ddmenuitem = $(this).find('ul').css('visibility', 'visible');
}

function jsddm_close()
{ if (ddmenuitem) ddmenuitem.css('visibility', 'hidden'); }

function jsddm_timer()
{ closetimer = window.setTimeout(jsddm_close, timeout); }

function jsddm_canceltimer() {
    if (closetimer) {
        window.clearTimeout(closetimer);
        closetimer = null;
    }
}

$(document).ready(function() {
    $('#nav > li').bind('mouseover', jsddm_open)
    $('#nav > li').bind('mouseout', jsddm_timer)
});

document.onclick = jsddm_close;

/*
var BaseProject = {
	/**
	* Função de chamada das outras funções que inicializam o site

	_init: function() {
		try {
			BaseProject._helloWorldConsole();
		} catch (e) {
			console.log('Error: ' + e.description);
		}
	},
	*/
	/**
	* Tenta exibir a mensagem "Hello World" através do console do firebug, caso falhe exibe a mensagem via alert

	_helloWorldConsole: function() {
		try {
			console.log('Hello World!');
		} catch(e) {
			alert('Hello World!');
		}
	}

};
*/
