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
            erro += "Nome obrigatório. \n";
        }
        if (cliente.getNome().length() > 14) {
            erro += "Nome muito grande !.  \n";
        }
        if (cliente.getSobrenome() == null || "".equals(cliente.getSobrenome()) || cliente.getSobrenome().startsWith(" ")) {
            erro += "Sobrenome obrigatório. \n";
        }

        if (cliente.getSobrenome().length() > 30) {
            erro += "Sobrenome muito grande. !  \n";
        }

     
        if (cliente.getCpf() == null) {
            erro += "CPF obrigatório. \n";
        }

        
         if (cliente.getCpf().length() < 11) {
            erro += "Número de CPF muito pequeno. \n";
        }
        

        /*if (ValidadorEmail.validar(cliente.getEmail())) {
            erro += "E-mail obrigatório \n";
        }*/

        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            erro += "Telefone obrigatório. \n";
        }
        
         if (cliente.getTelefone().length() < 8) {
            erro += "Número de telefone muito pequeno. \n";
        }
        
        if (cliente.getEstado() == null || "".equals(cliente.getEstado())) {
            erro += "Estado obrigatório. \n";;
        }

        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            erro += "Cidade obrigatória. \n";
        }

        if (cliente.getCidade().length() > 30) {
            erro += "Nome da cidade muito grande. !  \n";
        }
      
        if (cliente.getEndereco().length() > 30) {
            erro += "Endereço muito grande ! Digite apenas o nome da rua. \n";
        }

        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            erro += "Cep obrigatório. \n";
        }
        if (cliente.getNumCasa() == null || "".equals(cliente.getNumCasa())) {
            erro += "Número da casa obrigatório. \n";
        }
        if (cliente.getNumCasa().length() > 10) {
            erro += "Número muito grande !.  \n";
        }

       

        return erro;
    }

}
