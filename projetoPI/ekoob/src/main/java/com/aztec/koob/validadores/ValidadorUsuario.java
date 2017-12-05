/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.validadores;

import com.aztec.koob.model.Cliente;
import com.aztec.koob.model.Usuario;
import com.sun.tools.javac.resources.compiler;

/**
 *
 * @author Gabriel
 */
public class ValidadorUsuario {
    /*
    public static String validarUsuario(Usuario cliente) {
/*
        String erro = "";

        if (cliente.getNome() == null || "".equals(cliente.getNome()) || cliente.getNome().startsWith(" ")) {
            erro += "Nome obrigatório.";
        }
        if (cliente.getNome().length() > 14) {
            erro += "Nome muito grande.";
        }
        if (cliente.getSobrenome() == null || "".equals(cliente.getSobrenome()) || cliente.getSobrenome().startsWith(" ")) {
            erro += "Sobrenome obrigatório.";
        }

        if (cliente.getSobrenome().length() > 30) {
            erro += "Sobrenome muito grande.";
        }

        if (cliente.getCpf() == null) {
            erro += "CPF obrigatório.";
        }

        if (cliente.getCpf().length() < 11) {
            erro += "Número de CPF muito pequeno.";
        }


        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            erro += "Telefone obrigatório.";
        }

        if (cliente.getTelefone().length() < 8) {
            erro += "Número de telefone muito pequeno \n";
        }

        if (cliente.getEstado() == null || "".equals(cliente.getEstado())) {
            erro += "Estado obrigatório \n";;
        }

        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            erro += "Cidade obrigatória \n";
        }

        if (cliente.getCidade().length() > 30) {
            erro += "Nome da cidade muito grande !  \n";
        }

        if (cliente.getEndereco().length() > 30) {
            erro += "Endereço muito grande ! Digite apenas o nome da rua \n";
        }

        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            erro += "Cep obrigatório \n";
        }

        Usuario usuario = null;

        try {
            usuario = com.aztec.koob.dao.UsuarioDAO.procurarUsername(cliente.getUsername());
        } catch (Exception E) {

        }

        if (usuario != null) {
            erro += "Nome de usuário/login já cadastrado ! ";
        }
        return erro;
    }

}*/
}
