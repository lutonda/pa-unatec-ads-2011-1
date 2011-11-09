$(function(){
    $('#formCadastro1').validate({
        rules: {
            nm_usuario: {
                required: true,
                minlength: 2
            },
            usuario: {
                required: true,
                minlength: 2
            },
            senha: {
                required: true,
                minlength: 6
            },
            conf_senha: {
                required: true,
                minlength: 6,
                equalTo: "#senha"
            },
            aceiteTermos: {
                required: true
            }
        },

        messages: {
            nm_usuario: {
                required: "Informe um nome.",
                minlength: "O nome deve possuir no minimo 2 caracteres."
            },
            usuario: {
                required: "Informe um usuário.",
                minlength: "O nome deve possuir no minimo 2 caracteres."
            },
            senha: {
                required: "Digite uma senha.",
                minlength: "A senha deve possuir no minimo 6 caracteres."
            },
            conf_senha: {
                required: "Digite novamente a senha.",
                minlength: "A senha deve possuir no minimo 6 caracteres.",
                equalTo: "A confirmacao da senha nao confere com a senha digitada."
            },
            aceiteTermos: "Aceite os termos para prosseguir com o cadastro."
        }



    });
});