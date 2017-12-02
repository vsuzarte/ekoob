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

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>
    </head>
     <nav>
        <div class="full-width navbar">
            <h2 class="brand">e-koob</h2>
            <ul>
                <li><a class="active" href="home.jsp">Home</a></li>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                ||sessionScope.usuario.getFuncao().equals('estoquista') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li><a id ="produto" href = "cadastrarProduto.jsp">Produto</a></li>
                      </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                || sessionScope.usuario.getFuncao().equals('gerente')}">

                      <li><a id ="cliente" href="cadastrarCliente.jsp">Cliente</a></li>

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







            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
        <section>
            <div id="box" class="container-fluid">
                <div class="container">
                    <div class="formBox">

                        <form action="${pageContext.request.contextPath}/cadastro-produto" method="post">
                            <div class="row">
                                <div class="col-sm-12">
                                    <h1>Cadastrar Produto</h1>
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
                                            <div class="inputText">Autor</div>
                                            <input type="text" maxlength="30" size="30" name="autor" class="input required">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Editora</div>
                                            <input type="text" maxlength="30" size="30" name="editora" class="input required email">
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="inputBox">
                                            <div class="inputText">Ano</div>
                                            <input type="number" maxlength="4" size="4" name="ano" class="input required ">
                                        </div>

                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Estoque</div>
                                        <input type="number" maxlength="10" size="10" name="estoque" class="input required ">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Preço</div>
                                        <input type="number" maxlength="10" size="10" name="preco" class="input required ">
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



</html>