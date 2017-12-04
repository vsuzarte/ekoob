/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ProdutoDAO;
import com.aztec.koob.model.ItemVenda;
import com.aztec.koob.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "AdicionarProduto", urlPatterns = {"/AdicionarProduto"})
public class AdicionarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));

        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        try {

            Integer id = Integer.parseInt(request.getParameter("idProduto"));

            Produto produto = ProdutoDAO.obterProduto(id);

            ArrayList listaDeItemVenda = new ArrayList<ItemVenda>();
            listaDeItemVenda = (ArrayList) sessao.getAttribute("listaDeItemVenda");

            ArrayList listaDeProdutos = new ArrayList<Produto>();
            listaDeProdutos = (ArrayList) sessao.getAttribute("listaDeProdutos");

            //se a lista estiver vazia, adiciona o produto
            if (listaDeItemVenda == null) {
                ItemVenda item = new ItemVenda();
                item.setIdProduto(id);
                listaDeItemVenda.add(item);

                //for para achar o produto na lista e remover do estoque
                for (int i = 0; i < listaDeProdutos.size(); i++) {
                    Produto produtoTemp = (Produto) listaDeProdutos.get(i);
                    if (id == produtoTemp.getId()) {

                        produtoTemp.setQuantidade(-1);

                        listaDeProdutos.remove(i);
                        listaDeProdutos.add(produtoTemp);

                    }

                }

            } //se não, percorre pra ver se o produto já está na lista
            else {

                for (int i = 0; i < listaDeItemVenda.size(); i++) {

                    //transformando o item que está em object em ItemVenda
                    ItemVenda item = (ItemVenda) listaDeItemVenda.get(i);

                    if (produto.getId() == item.getIdProduto()) {

                        //aumenta a quantidade do item
                        item.aumentarQtde();

                        //for para achar o produto na lista e remover do estoque
                        for (int j = 0; j < listaDeProdutos.size(); j++) {
                            Produto produtoTemp = (Produto) listaDeProdutos.get(j);
                            if (id == produtoTemp.getId()) {

                                produtoTemp.setQuantidade(-1);

                                listaDeProdutos.remove(j);
                                listaDeProdutos.add(produtoTemp);

                            }

                            //remove o item da lista 
                            listaDeItemVenda.remove(i);

                            //acrescenta o item com a quantidade atualizada na lista
                            listaDeItemVenda.add(item);

                            break;

                        }
                    }
                    //se não achar o produto na lista, adiciona 
                    if (listaDeItemVenda.size() == i + 1) {
                        item = new ItemVenda();
                        item.setIdProduto(id);
                        listaDeItemVenda.add(item);

                        //for para achar o produto na lista e remover do estoque
                        for (int k = 0; k < listaDeProdutos.size(); k++) {
                            Produto produtoTemp = (Produto) listaDeProdutos.get(k);
                            if (id == produtoTemp.getId()) {

                                produtoTemp.setQuantidade(-1);

                                listaDeProdutos.remove(k);
                                listaDeProdutos.add(produtoTemp);

                            }
                        }
                    }
                }

            }

            sessao.setAttribute("produto", produto);
            response.sendRedirect(request.getContextPath() + "/venda.jsp");

            //RequestDispatcher dispatcher = request.getRequestDispatcher("clienteConsultado.jsp");
            //dispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
