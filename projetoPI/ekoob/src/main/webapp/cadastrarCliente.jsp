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
                <li><a class="active" href="#">Home</a></li>
                <li><a href="#">Cliente</a></li>
                <li><a href="#">Produto</a></li>
                <li><a href="#">Fornecedor</a></li>
                <li><a href="#">Usuário</a></li>
                <li><a href="#">Venda</a></li>
                <li><a href="#">Relatório</a></li>
            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
        <section>
            <div class="container-fluid">
                <div class="container">
                    <div class="formBox">
                        
                            <form>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h1>Cadastrar Protudo</h1>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="inputBox">
                                                <div class="inputText">Nome</div>
                                                <input type="text" name="pNome" class="input">
                                                <div id="nameerro" class="valerro"></div>
                                            </div>

                                        </div>
                                        <div class="col-sm-6">
                                            <div class="inputBox">
                                                <div class="inputText">Autor</div>
                                                <input type="text" name="" class="input">
                                            </div>

                                        </div>
                                        <div class="col-sm-6">
                                            <div class="inputBox">
                                                <div class="inputText">Editora</div>
                                                <input type="text" name="" class="input">
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
            <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
            <script type="text/javascript">
                $(".input").focus(function(){
                    $(this).parent().addClass("focus");
                }).blur(function(){
                    if($(this).val() === ''){
                     $(this).parent().removeClass("focus");
                    }
                });
            </script>
    </body>
</html>
