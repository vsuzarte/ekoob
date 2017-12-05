/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.servlet;

import com.aztec.koob.dao.ClienteDAO;
import com.aztec.koob.model.Cliente;
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
@WebServlet(name = "EditarCliente", urlPatterns = {"/editar-cliente"})
public class EditarCliente extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String endereco = request.getParameter("rua");
        String numCasa = request.getParameter("numero");
        String cep = request.getParameter("cep");

        Cliente cliente = new Cliente(id, nome, sobrenome, cpf, email, telefone, estado, cidade, endereco, cep, numCasa);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEstado(estado);
        cliente.setCidade(cidade);
        cliente.setEndereco(endereco);
        cliente.setNumCasa(numCasa);
        cliente.setCep(cep);

        //String erro = ValidadorCliente.validarCliente(cliente);
       String erro = "";
        if (!erro.equals("")) {
            request.setAttribute("mensagem", erro);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastrarCliente.jsp");
            dispatcher.forward(request, response);

        } else {

            try {

                ClienteDAO.atualizarCliente(cliente);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //cria ou recupera uma sessão ja existente
            sessao = request.getSession();

            request.setAttribute("mensagem", "Cliente cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultarCliente.jsp");
            dispatcher.forward(request, response);

        }

    }

}
