/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.FornecedorDAO;
import com.aztec.koob.model.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author guilherme.gcosta6
 */
@WebServlet(name = "ConsultarFornecedor", urlPatterns = {"/consultarFornecedor"})
public class ConsultarFornecedor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Fornecedor> listaFornecedor;
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        

        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        try {

            String razaoSocial = request.getParameter("razaoSocial");

            listaFornecedor = FornecedorDAO.procurarFornecedor(razaoSocial);
            request.setAttribute("listaFornecedor", listaFornecedor);

            if (razaoSocial == null || razaoSocial.equals("")) {
                listaFornecedor = FornecedorDAO.listarFornecedor();
                request.setAttribute("listaFornecedor", listaFornecedor);
            }

            sessao.setAttribute("listaFornecedor", listaFornecedor);
            response.sendRedirect(request.getContextPath() + "/ConsultarFornecedor.jsp");

        } catch (Exception e) {
        }

    }

}
