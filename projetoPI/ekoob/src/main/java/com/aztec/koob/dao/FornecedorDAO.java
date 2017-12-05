/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.dao;

import com.aztec.koob.conexao.ConnectionUtils;
import com.aztec.koob.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author guilherme.gcosta6
 */
public class FornecedorDAO {
    
    public static void inserirFornecedor(Fornecedor fornecedor) throws SQLException, Exception {
        
        Connection conn = null;
        
        String sql = "INSERT INTO Fornecedor(razaoSocial, cnpj, enderecoFornecedor, emailFornecedor, telefoneFornecedor,"
                + " disponivel) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = null;
        
        try {
            conn = ConnectionUtils.getConnection();
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getRazaoSocial());
            
            stmt.setString(2, fornecedor.getCnpj());
            
            stmt.setString(3, fornecedor.getEndereco());
            
            stmt.setString(4, fornecedor.getEmail());
            
            stmt.setString(5, fornecedor.getTel());
            
            stmt.setBoolean(6, true);
            
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
    
     public static List<Fornecedor> procurarFornecedor(String razaoS) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um fornecedor de acordo com o nome ou letra.
        //ultilizando o valor passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM fornecedor WHERE UPPER (RAZAOSOCIAL) LIKE UPPER (?) AND DISPONIVEL=?";

        //Lista de clientes de resultado
        List<Fornecedor> listaFornecedor = null;

        //connection para abertura e fechamento.
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {

            //chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente.
            //cada preparedStatement ira ocupar a interrogação na instrução SQL.
            preparedStatement.setString(1, "%" + razaoS + "%");
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //While passa por cada item (linha) do resultado
            while (result.next()) {

                //Se a lista não foi inicializada, a inicializa
                if (listaFornecedor == null) {
                    listaFornecedor = new ArrayList<Fornecedor>();
                }

                /*Cria a instância Cliente, pega os valores obtidos pela consulta ao banco,
                e a popula.*/
                int id = result.getInt("idFornecedor");
                String razaoSocial = result.getString("razaoSocial");
                String cnpj = result.getString("cnpj");
                String enderecoFornecedor = result.getString("enderecoFornecedor");
                String emailFornecedor = result.getString("emailFornecedor");
                String telefoneFornecedor = result.getString("telefoneFornecedor");
                

                Fornecedor fornecedor = new Fornecedor(id, razaoSocial, cnpj,
                        enderecoFornecedor, emailFornecedor, telefoneFornecedor );

                //Adiciona a instãncia na lista.
                listaFornecedor.add(fornecedor);
            }

        } finally {

            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }

            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

        //Retorna a lista de cliente do banco de dados.
        return listaFornecedor;
    }
    public static void excluirFornecedor(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para "excluir" um cliente do banco de dados.
        //ultilizando o ID passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE fornecedor SET DISPONIVEL=? WHERE (idFornecedor=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        try {

            //chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente
            //cada preparedStatement ira ocupar uma interrogação na instrução SQL
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            //Exucuta o comando do banco de dados.
            preparedStatement.execute();

        } finally {

            //Se o statement ainda estiver aberto, realiza seu fechamento. 
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            //Se a conexão ainda estiver aberta, realiza seu fechamento.
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

    }
  
    public static void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, Exception {

        String sql = "UPDATE fornecedor SET razaoSocial=?, cnpj=?, "
                + "enderecoFornecedor=?, emailFornecedor=?, "
                + "telefoneFornecedor=? WHERE (idFornecedor=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, fornecedor.getRazaoSocial());

            preparedStatement.setString(2, fornecedor.getCnpj());

            preparedStatement.setString(3, fornecedor.getEndereco());

            preparedStatement.setString(4, fornecedor.getEmail());

            preparedStatement.setString(5, fornecedor.getTel());

            preparedStatement.setInt(6, fornecedor.getId());

            preparedStatement.execute();

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        }

    }
    
    
    public static List<Fornecedor> listarFornecedor() throws SQLException, Exception {

        String sql = "SELECT * FROM fornecedor WHERE (DISPONIVEL=?)";

        List<Fornecedor> listaFornecedor = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            //     DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (result.next()) {

                if (listaFornecedor == null) {
                    listaFornecedor = new ArrayList<Fornecedor>();
                }

                int idFornecedor = result.getInt("idFornecedor");
                String razaoSocial = result.getString("razaoSocial");
                String cnpj = result.getString("cnpj");
                String enderecoFornecedor = result.getString("enderecoFornecedor");
                String emailFornecedor = result.getString("emailFornecedor");
                String telefoneFornecedor = result.getString("telefoneFornecedor");
                
                Fornecedor fornecedor = new Fornecedor(idFornecedor, razaoSocial, cnpj, enderecoFornecedor, emailFornecedor, telefoneFornecedor);

                //Adiciona a instãncia na lista.
                listaFornecedor.add(fornecedor);
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
        return listaFornecedor;
    }
    
    
}

