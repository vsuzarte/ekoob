/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.validadores;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author gabriel.sleal1
 */
public class ValidadorData {

    public static Date formatarData(String dataNasc) {

        try {
            //FORMATANDO A DATA EM STRING PARA DATE
            String ano = dataNasc.substring(0, 4);
            String mes = dataNasc.substring(5, 7);
            String dia = dataNasc.substring(8, 10);
            String data = dia + "/" + mes + "/" + ano;

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            java.util.Date dataFormatada = null;

            try {
                dataFormatada = formato.parse(data);
            } catch (Exception E) {

            }

            java.sql.Date dataSql = new java.sql.Date(dataFormatada.getTime());
            return dataSql;
        } catch (Exception E) {
            return null;
        }

    }
}
