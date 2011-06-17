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

//recupera dados URL
function parseURL(url) {
    var a =  document.createElement('a');
    a.href = url;
    return {
        source: url,
        protocol: a.protocol.replace(':',''),
        host: a.hostname,
        port: a.port,
        query: a.search,
        params: (function(){
            var ret = {},
                seg = a.search.replace(/^\?/,'').split('&'),
                len = seg.length, i = 0, s;
            for (;i<len;i++) {
                if (!seg[i]) { continue; }
                s = seg[i].split('=');
                ret[s[0]] = s[1];
            }
            return ret;
        })(),
        file: (a.pathname.match(/\/([^\/?#]+)$/i) || [,''])[1],
        hash: a.hash.replace('#',''),
        path: a.pathname.replace(/^([^\/])/,'/$1'),
        relative: (a.href.match(/tp:\/\/[^\/]+(.+)/) || [,''])[1],
        segments: a.pathname.replace(/^\//,'').split('/')
    };
}