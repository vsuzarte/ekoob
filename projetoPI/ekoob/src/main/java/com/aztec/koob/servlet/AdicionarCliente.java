/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdicionarCliente", urlPatterns = {"/AdicionarCliente"})
public class AdicionarCliente extends HttpServlet {

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

            
            Integer id = Integer.parseInt(request.getParameter("idCliente"));

            Cliente cliente = ClienteDAO.obterCliente(id);
           
            sessao.setAttribute("cliente", cliente);
            sessao.setAttribute("idCliente", cliente.getId());
            response.sendRedirect(request.getContextPath() + "/venda.jsp");

            //RequestDispatcher dispatcher = request.getRequestDispatcher("clienteConsultado.jsp");
            //dispatcher.forward(request, response);
        } catch (Exception e) {
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        

    }
}
