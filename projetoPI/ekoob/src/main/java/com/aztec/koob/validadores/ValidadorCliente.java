/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.validadores;


import com.aztec.koob.model.Cliente;
import com.aztec.koob.validadores.ValidadorEmail;

/**
 *
 * @author gildete
 */
public class ValidadorCliente {

    public static String validarCliente(Cliente cliente) {

        String erro = "";

        if (cliente.getNome() == null || "".equals(cliente.getNome()) || cliente.getNome().startsWith(" ")) {
            erro += "Nome obrigatório \n";
        }
        if (cliente.getNome().length() > 14) {
            erro += "Erro! Digite novamente \n";
        }
        if (cliente.getSobrenome() == null || "".equals(cliente.getSobrenome()) || cliente.getSobrenome().startsWith(" ")) {
            erro += "Sobrenome obrigatório \n";
        }

        if (cliente.getSobrenome().length() > 30) {
            erro += "Digite novamente \n";
        }

        if (cliente.getDataNasc() == null) {
            erro += "Data de obrigatório \n";
        }
        if (cliente.getCpf() == null) {
            erro += "CPF obrigatório \n";
        }

        if (ValidadorCPF.validar(cliente.getCpf())) {
            erro += "Erro! Digite novamente";
        }

        if (ValidadorEmail.validar(cliente.getEmail())) {
            erro += "E-mail obrigatório \n";
        }

        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            erro += "Telefone obrigatório \n";
        }
        if (cliente.getEstado() == null || "".equals(cliente.getEstado())) {
            erro += "Estado obrigatório \n";;
        }

        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            erro += "Cidade obrigatória \n";
        }

        if (cliente.getCidade().length() > 30) {
            erro += "Erro! Digite novamente \n";
        }
        if (cliente.getEndereco() == null || "".equals(cliente.getEndereco())) {
            erro += "Endereço obrigatório \n";
        }
        if (cliente.getEndereco().length() > 30) {
            erro += "Erro! Digite novamente \n";
        }

        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            erro += "Cep obrigatório \n";
        }
        if (cliente.getNumCasa() == null || "".equals(cliente.getNumCasa())) {
            erro += "Número da casa obrigatório \n";
        }
        if (cliente.getNumCasa().length() > 10) {
            erro += "Erro! Digite novamente \n";
        }

        if (cliente.getGenero() == null || (!cliente.getGenero().equals("M") && !cliente.getGenero().equals("F"))) {
            erro += "Sexo obrigatório \n";
        }

        return erro;
    }

}
