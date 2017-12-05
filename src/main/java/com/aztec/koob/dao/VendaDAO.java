/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.dao;

import com.aztec.koob.conexao.ConnectionUtils;
import com.aztec.koob.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author gabriel.sleal1
 */
public class VendaDAO {
     public static void inserirVenda(int idCliente, double valor) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Venda(idcliente,  valortotal) "
                + "VALUES (?, ?)";

        PreparedStatement stmt = null;

        try {

            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idCliente);

            stmt.setDouble(2,  valor);

          

          

            stmt.execute();

        } finally {

            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (conn != null && !conn.isClosed()) {
                conn.isClosed();
            }

        }

    }
}
