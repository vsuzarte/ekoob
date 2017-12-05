<%-- 
    Document   : cadastrarCliente
    Created on : 02/12/2017, 07:42:41
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ekoob</title>
        <link rel="stylesheet" href="css/homecss.css"/>
        <link rel="stylesheet" href="css/crudcss.css"/>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <nav>
        <div class="full-width navbar">
            <a class="navbar-brand" href="home.jsp"><img class="logo" src="logo.png" /></a>
            <ul>
                <li><a class="active" href="home.jsp">Home</a></li>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                ||sessionScope.usuario.getFuncao().equals('estoquista') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li><a id ="produto" href = "cadastrarProduto.jsp">Produto</a></li>
                      </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                || sessionScope.usuario.getFuncao().equals('gerente')}">

                      <li class="active"><a id ="cliente" href="cadastrarCliente.jsp">Cliente</a></li>

                </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('ti') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">

                      <li><a id ="usuario"href="cadastrarUsuario.jsp">Usuário</a></li>

                </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')

                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li><a id ="venda"href="venda.jsp">Venda</a></li>
                      </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('gerente')}">
                    <li><a id = "relatorio" href="relatorio.jsp">Relatório</a></li>
                    </c:if>
                <li class="active"><a href="Logout">Logout</a></li>







            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
    <div id="respostaErro">
        <c:if test="${not empty mensagem}">
            <alert><c:out value="${mensagem}" /></alert>
            </c:if> 
    </div>
    <div id="pagina" class="container">
        <div class="row">
            <div class="col-xs-12">
                <ul class="nav nav-pills nav-justified">
                    <li class="active"><a class="abranc" href="cadastrarCliente.jsp">Cadastro Cliente</a></li>
                    <li><a class="abranc" href="consultarCliente.jsp">Consultar Cliente</a></li>

                </ul>

            </div>

        </div>

    </div>
    <section>
        <div id="box" class="container-fluid">
            <div class="container">
                <div class="formBox">

                    <form id="registerform" name="registerform" action="${pageContext.request.contextPath}/cadastro-cliente" method="post">
                        <div class="row">
                            <div class="col-sm-12">
                                <h1>Cadastrar Cliente</h1>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Nome</div>
                                        <input type="text" maxlength="30" size="30" name="nome" class="input required" id="fnome">

                                    </div>

                                </div> <br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Sobrenome</div>
                                        <input type="text" maxlength="30" size="30" name="sobrenome" class="input required" id="fnome">

                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">CPF</div>
                                        <input id="cpf" type="number" maxlength="11" size="11" name="cpf" class="input required">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Email</div>
                                        <input type="text" maxlength="30" size="30" name="email" class="input required email">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Telefone</div>
                                        <input type="number" maxlength="12" size="12" name="telefone" class="input required ">
                                    </div>

                                </div><br>

                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">CEP</div>
                                        <input id="cep" type="number" maxlength="8" size="8" name="cep" class="input required ">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Rua</div>
                                        <input id="rua" maxlength="30" size="30" type="text" name="endereco" class="input required ">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Cidade</div>
                                        <input id="cidade" maxlength="30" size="30" type="text" name="cidade" class="input required ">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">UF</div>
                                        <input id="uf" type="text" maxlength="2" size="2" name="estado" class="input required ">
                                    </div>

                                </div><br>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Número</div>
                                        <input  type="number" maxlength="5" size="5" name="numero" class="input required ">
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
