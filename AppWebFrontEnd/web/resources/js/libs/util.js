jQuery.createDelegate = function(instance, method) {
    return function() {
        return method.apply(instance, arguments);
    }
};

function getParameter(name)
{
    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
    var regexS = "[\\?&]"+name+"=([^&#]*)";
    var regex = new RegExp( regexS );
    var results = regex.exec( window.location.href );
    if( results == null )
        return "";
    else
        return results[1];
}
function inputText(id, texto){

    $('#' + id).val(texto);
    $('#' + id).attr("style", "color: #cccccc");

    $('#' + id).keypress(function() {
        $(this).attr("style", "color: #333333");
    });

    $('#' + id).focus(function() {
        if($(this).val() == texto)
            $(this).val("");
    });

    $('#' + id).blur(function() {
        if($(this).val() == '')
            $(this).val(texto);

        $(this).attr("style", "color: #cccccc");

        if($(this).val() != texto)
            $(this).attr("style", "color: #333333");
    });
}
function formatar_mascara(src, mascara) {
    var campo = src.value.length;
    var saida = mascara.substring(0,1);
    var texto = mascara.substring(campo);
    if(texto.substring(0,1) != saida) {
        src.value += texto.substring(0,1);
        }
}