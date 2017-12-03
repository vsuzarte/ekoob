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
@WebServlet(name = "TelaEditarCliente", urlPatterns = {"/tela-editar-cliente"})
public class TelaEditarCliente extends HttpServlet {

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
        request.setAttribute("numero", cliente.getNumCasa());
        request.setAttribute("cep", cliente.getCep());

        this.getServletContext().getRequestDispatcher("/editarCliente.jsp").forward(request, response);
        
    
            

        } catch (Exception e) {

        }

      
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
      
    }

}
