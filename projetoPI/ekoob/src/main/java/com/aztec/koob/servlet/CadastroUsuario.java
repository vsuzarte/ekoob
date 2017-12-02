package com.aztec.koob.servlet;

import com.aztec.koob.dao.UsuarioDAO;
import com.aztec.koob.model.Usuario;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aztec.koob.validadores.ValidadorData;

@WebServlet(name = "CadastroUsuario", urlPatterns = {"/cadastro-usuario"})
public class CadastroUsuario extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino;

        HttpSession sessao = request.getSession();

     
        if (sessao.getAttribute("usuario") != null) {

            request.setAttribute("mensagem", "Usúario cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroUsuario.jsp");
            dispatcher.forward(request, response);

            destino = "CadastroUsuario.jsp";

        } else {

            destino = "CadastroUsuario.jsp";
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
        String data = request.getParameter("dataNasc");

        Date dataSql = ValidadorData.formatarData(data);

        Usuario usuario = new Usuario(0, nome, sobrenome, dataSql, cpf, email, telefone, estado, cidade, endereco, cep, funcao, senha, username);

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
        usuario.setDataNasc(dataSql);

        try {
            UsuarioDAO.inserirUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/cadastro-usuario");

    }

}
