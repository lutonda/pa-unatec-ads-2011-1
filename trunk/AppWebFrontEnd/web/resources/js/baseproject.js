/**
* Inicializa as fun��es assim que os elementos (DOM) s�o carregados
* @author Leonardo Souza <leonardo.souza@agenciaclick.com.br>
*/
jQuery(function() {
	BaseProject._init();
});

var BaseProject = {
	/**
	* Fun��o de chamada das outras fun��es que inicializam o site
	* @author Leonardo Souza <leonardo.souza@agenciaclick.com.br>
	*/
	_init: function() {
		try {
			BaseProject._helloWorldConsole();
		} catch (e) {
			console.log('Error: ' + e.description);
		}
	},
		
	/**
	* Tenta exibir a mensagem "Hello World" atrav�s do console do firebug, caso falhe exibe a mensagem via alert
	* @author Leonardo Souza <leonardo.souza@agenciaclick.com.br>
	* @modified Leonardo Souza <leonardo.souza@agenciaclick.com.br>
	*/
	_helloWorldConsole: function() {
		try {
			console.log('Hello World!');
		} catch(e) {
			alert('Hello World!');
		}
	}
};