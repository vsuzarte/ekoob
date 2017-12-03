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
@WebServlet(name = "AlterarClienteServlet", urlPatterns = {"/AlterarClienteServlet"})
public class AlterarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Cliente cliente = null;
        
        int id = Integer.parseInt(request.getParameter("idCliente"));

        try {

            cliente = ClienteDAO.obterCliente(id);
            
            
        request.setAttribute("id", cliente.getId());
        request.setAttribute("nome", cliente.getNome());
        request.setAttribute("sobrenome", cliente.getSobrenome());
        request.setAttribute("cpf", cliente.getCpf());
        request.setAttribute("email", cliente.getEmail());
        request.setAttribute("telefone", cliente.getTelefone());
        request.setAttribute("estado", cliente.getEstado());
        request.setAttribute("cidade", cliente.getCidade());
        request.setAttribute("endereco", cliente.getEndereco());
        request.setAttribute("numCasa", cliente.getNumCasa());
        request.setAttribute("cep", cliente.getCep());

        this.getServletContext().getRequestDispatcher("/alterarCliente.jsp").forward(request, response);
        
        //response.sendRedirect(request.getContextPath() + "/alterarCliente.jsp");
            

        } catch (Exception e) {

        }

       /* String destino = "";

        HttpSession sessao = request.getSession();

        if (sessao != null && sessao.getAttribute("usuario") != null) {

            request.setAttribute("mensagem", "Cliente editado! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/alterarCliente.jsp");
            dispatcher.forward(request, response);

            destino = "alterarCliente.jsp";
        }
        

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response); */

    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        Cliente cliente = null;
        
        int id = Integer.parseInt(request.getParameter("idProduto"));

        try {

            cliente = ClienteDAO.obterCliente(id);
            
            
        request.setAttribute("id", cliente.getId());
        request.setAttribute("nome", cliente.getNome());
        request.setAttribute("sobrenome", cliente.getSobrenome());
        request.setAttribute("dataNasc", cliente.getDataNasc());
        request.setAttribute("genero", cliente.getGenero());
        request.setAttribute("cpf", cliente.getCpf());
        request.setAttribute("email", cliente.getEmail());
        request.setAttribute("telefone", cliente.getTelefone());
        request.setAttribute("estado", cliente.getEstado());
        request.setAttribute("cidade", cliente.getCidade());
        request.setAttribute("endereco", cliente.getEndereco());
        request.setAttribute("numCasa", cliente.getNumCasa());
        request.setAttribute("cep", cliente.getCep());

        response.sendRedirect(request.getContextPath() + "/alterarCliente.jsp");
            

        } catch (Exception e) {

        }

        */
      
    }

}
