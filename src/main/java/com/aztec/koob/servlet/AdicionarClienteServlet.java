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

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "AdicionarClienteServlet", urlPatterns = {"/AdicionarClienteServlet"})
public class AdicionarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = null;
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("idCliente"));
        } catch (Exception e) {

        }
        String clienteDados = "";
        try {
            cliente = ClienteDAO.obterCliente(id);
            clienteDados = "Nome: " + cliente.getNome() + " CPF: " + cliente.getCpf();

        } catch (Exception e) {

        }

        request.setAttribute("clienteDados", clienteDados);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
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
