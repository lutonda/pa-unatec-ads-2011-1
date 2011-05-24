/**
* Inicializa as fun��es assim que os elementos (DOM) s�o carregados
*/
jQuery(function() {
	BaseProject._init();
});

var BaseProject = {
	/**
	* Fun��o de chamada das outras fun��es que inicializam o site
	*/
	_init: function() {
            /*
		try {
			BaseProject._helloWorldConsole();
		} catch (e) {
			console.log('Error: ' + e.description);
		}*/
	},
		
	/**
	* Tenta exibir a mensagem "Hello World" atrav�s do console do firebug, caso falhe exibe a mensagem via alert
	*/
	_helloWorldConsole: function() {
		try {
			console.log('Hello World!');
		} catch(e) {
			alert('Hello World!');
		}
	}
};