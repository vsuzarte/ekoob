/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.dao.UsuarioDAO;
import com.aztec.koob.model.Cliente;
import com.aztec.koob.model.Usuario;
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
@WebServlet(name = "TelaEditarUsuario", urlPatterns = {"/tela-editar-usuario"})
public class TelaEditarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Usuario cliente = null;
        
        int id = Integer.parseInt(request.getParameter("idUsuario"));

        try {

            cliente = UsuarioDAO.obterUsuario(id);
            
            
        request.setAttribute("id", cliente.getId());
        request.setAttribute("nome", cliente.getNome());
        request.setAttribute("sobrenome", cliente.getSobrenome());
        request.setAttribute("cpf", cliente.getCpf());
        request.setAttribute("email", cliente.getEmail());
        request.setAttribute("telefone", cliente.getTelefone());
        request.setAttribute("estado", cliente.getEstado());
        request.setAttribute("cidade", cliente.getCidade());
        request.setAttribute("endereco", cliente.getEndereco());
        request.setAttribute("username", cliente.getUsername());
        request.setAttribute("senha", cliente.getSenha());
        request.setAttribute("funcao", cliente.getFuncao());
        request.setAttribute("cep", cliente.getCep());

        this.getServletContext().getRequestDispatcher("/editarUsuario.jsp").forward(request, response);
        
    
            

        } catch (Exception e) {

        }

      
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     
      
    }

}
