/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.validadores;

import com.aztec.koob.model.Produto;

/**
 *
 * @author Gabriel
 */
public class ValidadorProduto {

    public static String validarProduto(Produto cliente) {

        String erro = "";

        if (cliente.getNome() == null || "".equals(cliente.getNome()) || cliente.getNome().startsWith(" ")) {
            erro += "Nome obrigatório. \n";
        }
        if (cliente.getNome().length() > 14) {
            erro += "Nome muito grande !.  \n";
        }
        if (cliente.getEditora() == null || "".equals(cliente.getEditora()) || cliente.getEditora().startsWith(" ")) {
            erro += "Editora obrigatória. \n";
        }

        if (cliente.getEditora().length() > 30) {
            erro += "Nome de editora muito grande !.  \n";
        }

        if (cliente.getAno() == null) {
            erro += "Ano obrigatório. \n";
        }

        if (cliente.getAno().length() < 4) {
            erro += "Digite o ano corretamente (4 dígitos). \n";
        }


        /*if (ValidadorEmail.validar(cliente.getEmail())) {
            erro += "E-mail obrigatório \n";
        }*/
        if ("".equals(cliente.getQuantidade())) {
            erro += "Estoque obrigatório. \n";
        }

        if (cliente.getQuantidade() < 0) {
            erro += "Estoque inválido !. ";
        }

        if ( "".equals(cliente.getPreco())) {
            erro += "Preço obrigatório. \n";;
        }

        if ( cliente.getPreco()<0) {
            erro += "Preço inválido. \n";;
        }

     

        return erro;
    }

}
