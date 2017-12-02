/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.UsuarioDAO;
import com.aztec.koob.model.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "AlterarUsuarioServlet", urlPatterns = {"/alterar-usuario"})
public class AlterarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String cpf = request.getParameter("cpf");
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");
            String confirmaSenha = request.getParameter("confirmaSenha");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String cep = request.getParameter("cep");
            String estado = request.getParameter("estado");
            String cidade = request.getParameter("cidade");
            String funcao = request.getParameter("funcao");
       

          

            Usuario usuario = new Usuario(0, nome, sobrenome,  cpf, email, telefone, estado, cidade, endereco, cep, funcao, senha, username);

            usuario.setNome(nome);
            usuario.setSobrenome(sobrenome);
            usuario.setFuncao(funcao);
            usuario.setCpf(cpf);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            usuario.setTelefone(telefone);
            usuario.setEndereco(endereco);
            usuario.setCep(cep);
            usuario.setUsername(username);
            usuario.setEstado(estado);
            usuario.setCidade(cidade);


            try {
                UsuarioDAO.atualizarUsuario(usuario);
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect(request.getContextPath() + "/consultarUsuario.jsp");

        }

    }
}
