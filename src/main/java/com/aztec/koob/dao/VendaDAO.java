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
import com.aztec.koob.model.Venda;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel.sleal1
 */
public class VendaDAO {

    public static List<Venda> listarVenda() throws SQLException, Exception {

        String sql = "SELECT * FROM venda";

        List<Venda> listaDeVenda = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareCall(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaDeVenda == null) {
                    listaDeVenda = new ArrayList<Venda>();
                }

                int idVenda = result.getInt("idVenda");
                int idCliente = result.getInt("idCliente");
                double valor = result.getDouble("valortotal");

                Venda venda = new Venda();
                venda.setId(idVenda);
                venda.setIdCliente(idCliente);
                venda.setValor(valor);

                listaDeVenda.add(venda);
            }

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }

        }

        return listaDeVenda;
    }

    public static void inserirVenda(int idCliente, double valor) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Venda(idcliente,  valortotal) "
                + "VALUES (?, ?)";

        PreparedStatement stmt = null;

        try {

            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idCliente);

            stmt.setDouble(2, valor);

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
