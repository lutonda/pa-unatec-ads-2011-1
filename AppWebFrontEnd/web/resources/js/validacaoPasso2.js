
$('#formCadastro2').validate({
        rules: {
            dt_nascimento: {
                required: true,
                date: true
            },
            sexo: {
                required: true
            },
            telefone: {
                required: true,
                minlength: 10,
                number: true
            },
            descricao: {
                required: true,
                minlength: 30
            },
            cep: {
                required: true,
                minlength: 8,
                number: true
            },
            logradouro:{
                required: true
            },
            numero: {
                number: true
            },
            bairro:{
                required: true
            },
            cidade:{
                required: true
            },
            estado:{
                required: true
            }

        },

        messages: {
            dt_nascimento: {
                required: "Informe uma data de nascimento",
                date: "informe uma data valida."
            },
            sexo: {
                required: "Selecione uma opcao"
            },
            telefone: {
                required: "Informe um telefone",
                minlength: "Informe um telefone completo (DDD) + numero",
                number: "Digite somente numeros"
            },
            descricao: {
                required: "Informe uma descricao",
                minlength: "A descricao deve conter, no minimo, 30 caracteres"
            },
            cep: {
                required: "Informe um CEP",
                minlength: "O CEP deve conter, no minimo, 8 caracteres",
                number: "Digite somente numeros"
            },
            logradouro:{
                required: "Informe um logradouro"
            },
            numero: {
                number: "Digite somente numeros"
            },
            bairro:{
                required: "Informe um bairro"
            },
            cidade:{
                required: "Informe uma cidade"
            },
            estado:{
                required: "Informe um Estado"
            }
        }
    });