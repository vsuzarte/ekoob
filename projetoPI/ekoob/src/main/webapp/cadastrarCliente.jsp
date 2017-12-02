<%-- 
    Document   : cadastrarCliente
    Created on : 02/12/2017, 07:42:41
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ekoob</title>
        <link rel="stylesheet" href="css/homecss.css"/>
        <link rel="stylesheet" href="css/crudcss.css"/>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
    </head>
    <nav>
        <div class="full-width navbar">
            <h2 class="brand">e-koob</h2>
            <ul>
                <li><a class="active" href="home.jsp">Home</a></li>
                <li><a href="cadastrarCliente.jsp">Cliente</a></li>
                <li><a href="cadastrarProduto.jsp">Produto</a></li>
                <li><a href="cadastrarUsuario.jsp">Usuário</a></li>
                <li><a href="venda.jsp">Venda</a></li>
                <li><a href="relatorio.jsp">Relatório</a></li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
        <section>
            <div id="box" class="container-fluid">
                <div class="container">
                    <div class="formBox">

                        <form id="registerform" name="registerform">
                            <div class="row">
                                <div class="col-sm-12">
                                    <h1>Cadastrar Cliente</h1>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Nome</div>
                                            <input type="text" maxlength="50" size="50" name="nome" class="input required" id="fnome">

                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">CPF</div>
                                            <input id="cpf" type="number" maxlength="11" size="11" name="" class="input required">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Email</div>
                                            <input type="text" name="email" class="input required email">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Telefone</div>
                                            <input type="number" maxlength="12" size="12" name="numero" class="input required ">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">CEP</div>
                                        <input id="cep" type="number" maxlength="8" size="8" name="numero" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Rua</div>
                                        <input id="rua" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Cidade</div>
                                        <input id="cidade" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">UF</div>
                                        <input id="uf" type="text" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Número</div>
                                        <input  type="number" name="" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-12">
                                    <input type="submit" name="" value="Salvar" class="button">
                                </div>
                            </div>
                    </div>
                    </form>

                </div>
            </div>

        </div>
    </section>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(".input").focus(function () {
        $(this).parent().addClass("focus");
    }).blur(function () {
        if ($(this).val() === '') {
            $(this).parent().removeClass("focus");
        }
    });
</script>
<script>
    $(document).ready(function () {
        $("#registerform").validate({

        });
    });
</script>

<script>
    $(document).ready(function () {

        function limpa_formulário_cep() {
            // Limpa valores do formulário de cep.
            $("#rua").val("");
            $("#bairro").val("");
            $("#cidade").val("");
            $("#uf").val("");

        }

        //Quando o campo cep perde o foco.
        $("#cep").blur(function () {

            //Nova variável "cep" somente com dígitos.
            var cep = $(this).val().replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep !== "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if (validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    $("#rua").val("...");
                    $("#bairro").val("...");
                    $("#cidade").val("...");
                    $("#uf").val("...");


                    //Consulta o webservice viacep.com.br/
                    $.getJSON("//viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                        if (!("erro" in dados)) {
                            //Atualiza os campos com os valores da consulta.
                            $("#rua").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#cidade").val(dados.localidade);
                            $("#uf").val(dados.uf);

                        } //end if.
                        else {
                            //CEP pesquisado não foi encontrado.
                            limpa_formulário_cep();
                            alert("CEP não encontrado.");
                        }
                    });
                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        });
    });

</script>

</html>
