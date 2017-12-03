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
        <link rel="stylesheet" href="css/venda.css"/>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <section>
                        <div id="box" id="pagina" class="container-fluid">
                            <div class="container">
                                <div class="formBox">
                                    <form id="registerform" name="registerform" action="${pageContext.request.contextPath}/consultarClienteVenda" method="post">
                                        <div class="row">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div class="inputBox">
                                                        <div class="inputText">Pesquisar Cliente</div>
                                                        <input type="text" maxlength="50" size="50" name="nome" class="input required" id="fnome">
                                                    </div>
                                                </div>

                                                <div class="col-sm-12">
                                                    <input type="submit" name="pesquisar" value="Pesquisar" class="button">
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>

                        </div>
                    </section>
                    <br><br><br>    
                    <table class="table">

                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Adicionar</th>
                        </tr>

                        <c:forEach items="${listaClientes}" var="clientes">
                            <tr>
                                <td><c:out value="${clientes.id}"/></td>
                                <td><c:out value="${clientes.nome}"/></td>
                                <td><c:out value="${clientes.cpf}"/></td>
                                <td><a href="AdicionarCliente?idCliente=${clientes.id}">Adicionar</a></td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <div id="bodyvenda" class="col-md-6">
                    <div id="cont" class="container">
                        <div class="centro">
                            <h3>Venda</h3>
                            <form action="${pageContext.request.contextPath}/Adicionarvenda" method="post">
                                <div class="inputBox">
                                    <h4>Informações do Cliente</h4>
                                    <span><i class="fa fa-user" aria-hidden="true"></i></span>
                                    <input type="text" value="${cliente.nome}" disabled="true" placeholder="Cliente selecionado"/> 
                                    <span><i class="fa fa-id-card-o" aria-hidden="true"></i></i></span>
                                    <input type="text" value="${cliente.cpf}" disabled="true" placeholder="CPF"/> 

                                </div>
                                <div class="inputBox">
                                    <h4>Informações do Livro</h4>
                                    <span><i class="fa fa-book" aria-hidden="true"></i></span>
                                    <input type="text" value="${produto.nome}" disabled="true" placeholder="Livro escolhido"/> 
                                    &nbsp 
                                    <i class="fa fa-archive" aria-hidden="true"></i>
                                    <input type="text" value="${produto.quantidade}" disabled="true" placeholder="Estoque"/> 
                                    &nbsp
                                    <i class="fa fa-money" aria-hidden="true"></i>
                                    <input type="number" value="${produto.preco}" disabled="true" placeholder="Valor Unitário"/> 

                                </div>
                                <div class="inputBox"> 
                                    <h4>Informações da Venda</h4> 
                                    <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                                    <input type="number" placeholder="Quantidade desejada"/>
                                    
                                    &nbsp&nbsp&nbsp&nbsp&nbsp
                                    <input type="submit" name="" value="Adicionar">


                                </div>


                            </form>


                        </div>

                    </div>
                    <table class="table">

                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Livro</th>
                            <th scope="col">Preço</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Valor</th>

                        </tr>

                        <c:forEach items="${listaProduto}" var="produto">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>

                    </table>


                </div>
                <div class="col-md-3">
                    <section>
                        <div id="box" id="pagina" class="container-fluid">
                            <div class="container">
                                <div class="formBox">
                                    <form id="registerform" name="registerform" action="${pageContext.request.contextPath}/consultar-produto-venda" method="post">
                                        <div class="row">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div class="inputBox">
                                                        <div class="inputText">Pesquisar Produto</div>
                                                        <input type="text" maxlength="50" size="50" name="nome" class="input required" id="fnome">
                                                    </div>
                                                </div>

                                                <div class="col-sm-12">
                                                    <input type="submit" name="" value="Pesquisar" class="button">
                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>

                        </div>
                    </section>
                    <br><br><br>    
                    <table class="table">

                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Preço</th>
                            <th scope="col">Estoque</th>
                            <th scope="col">Adicionar</th>
                        </tr>

                        <c:forEach items="${listaProduto}" var="produto">
                            <tr>
                                <td><c:out value="${produto.id}"/></td>
                                <td><c:out value="${produto.nome}"/></td>
                                <td><c:out value="${produto.preco}"/></td>
                                <td><c:out value="${produto.quantidade}"/></td>
                                <td><a href="AdicionarProduto?idProduto=${produto.id}">Adicionar</a></td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>
            </div>
        </div>
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
        rules: {
        verificar: {
        required: true;
        equalTo: "#senha"
        }
        }
        });
        });
    </script>

    <script>
        $(document).ready(function() {
        $('#datePicker').val(new Date().toDateInputValue());
        }); ​
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
