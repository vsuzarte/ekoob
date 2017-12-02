package com.aztec.koob.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aztec.koob.model.Cliente;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import com.aztec.koob.dao.ClienteDAO;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.aztec.koob.validadores.ValidadorCliente;

@WebServlet(name = "CadastroCliente", urlPatterns = {"/cadastro-cliente"})
public class CadastroCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino = "";

        HttpSession sessao = request.getSession();

        if (sessao != null && sessao.getAttribute("usuario") != null) {

            request.setAttribute("mensagem", "Cliente cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroCliente.jsp");
            dispatcher.forward(request, response);

            destino = "CadastroCliente.jsp";
        }
        

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
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
        
        HttpSession sessao = request.getSession();
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String endereco = request.getParameter("endereco");
        String numCasa = request.getParameter("numero");
        String cep = request.getParameter("cep");


        Cliente cliente = new Cliente(nome, sobrenome,  cpf, email, telefone, estado, cidade, endereco, cep, numCasa);
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

       // String erro = ValidadorCliente.validarCliente(cliente);
       String erro = "";

        if (!erro.equals("")) {
            request.setAttribute("mensagem", erro);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastrarCliente.jsp");
            dispatcher.forward(request, response);

        } else {

            try {

                ClienteDAO.inserirCliente(cliente);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //cria ou recupera uma sessão ja existente
             sessao = request.getSession();

            response.sendRedirect(request.getContextPath() + "/cadastrarCliente.jsp");
        }

    }

}
