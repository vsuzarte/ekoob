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
import com.aztec.koob.validadores.ValidadorCliente;
import com.aztec.koob.validadores.ValidadorData;
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
 * @author Vitor
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/editar-usuario"})
public class EditarUsuario extends HttpServlet {

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

        }

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String confirmarSenha = request.getParameter("confirmarSenha");
        String funcao = request.getParameter("funcao");

        Usuario cliente = new Usuario();
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setCpf(cpf);
        cliente.setCep(cep);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEstado(estado);
        cliente.setCidade(cidade);
        cliente.setEndereco(endereco);
        cliente.setSenha(senha);
        cliente.setUsername(username);
        cliente.setFuncao(funcao);
        cliente.setId((Integer) id);

        //String erro = ValidadorUsuario.validarUsuario(cliente);
        String erro = "";
        if (!senha.equals(confirmarSenha)) {
            erro += "As senhas não são iguais ! \n";
        }
        if (!erro.equals("")) {
            request.setAttribute("mensagem", erro);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/editarUsuario.jsp");
            dispatcher.forward(request, response);

        } else {

            try {

                UsuarioDAO.atualizarUsuario(cliente);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //cria ou recupera uma sessão ja existente
            sessao = request.getSession();

            request.setAttribute("mensagem", "Usuario editado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultarUsuario.jsp");
            dispatcher.forward(request, response);

        }

    }

}
