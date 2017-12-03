/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.dao;

import com.aztec.koob.conexao.ConnectionUtils;
import com.aztec.koob.model.Usuario;
import com.aztec.koob.validadores.ValidadorData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author guigr
 */
public class UsuarioDAO {

    public static void inserirUsuario(Usuario usuario) throws SQLException, Exception {

        Connection conn = null;

        String sql = "INSERT INTO Usuario(nomeUsuario, sobrenomeUsuario, "
                + "funcao,  cpfUsuario, emailUsuario, telefoneUsuario,"
                + " estadoUsuario,"
                + " cidadeUsuario, enderecoUsuario, disponivel, cepUsuario, "
                + "username, senha) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;

        try {
            conn = ConnectionUtils.getConnection();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());

            stmt.setString(2, usuario.getSobrenome());

            stmt.setString(3, usuario.getFuncao());

            stmt.setString(4, usuario.getCpf());

            stmt.setString(5, usuario.getEmail());

            stmt.setString(6, usuario.getTelefone());

            stmt.setString(7, usuario.getEstado());

            stmt.setString(8, usuario.getCidade());

            stmt.setString(9, usuario.getEndereco());

            stmt.setBoolean(10, true);

            stmt.setString(11, usuario.getCep());

            stmt.setString(12, usuario.getUsername());

            stmt.setString(13, usuario.getSenha());

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

    public static List<Usuario> listarUsuario() throws SQLException, Exception {

        String sql = "SELECT * FROM Usuario WHERE (DISPONIVEL=?)";

        List<Usuario> listaUsuario = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;

        try {

            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            // DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
            while (result.next()) {
                if (listaUsuario == null) {
                    listaUsuario = new ArrayList<Usuario>();
                }

                int idFuncionario = result.getInt("idUsuario");
                String nomeUsuario = result.getString("nomeUsuario");
                String sobrenomeUsuario = result.getString("sobrenomeUsuario");
                String funcao = result.getString("funcao");

                String cpfUsuario = result.getString("cpfUsuario");
                String emailUsuario = result.getString("emailUsuario");
                String telefoneUsuario = result.getString("telefoneUsuario");
                String estadoUsuario = result.getString("estadoUsuario");
                String cidadeUsuario = result.getString("cidadeUsuario");
                String enderecoUsuario = result.getString("enderecoUsuario");
                String cepUsuario = result.getString("cepUsuario");
                String username = result.getString("username");
                String senha = result.getString("senha");

                Usuario usuario = new Usuario(idFuncionario, nomeUsuario, sobrenomeUsuario,
                        cpfUsuario, emailUsuario,
                        telefoneUsuario, estadoUsuario, cidadeUsuario,
                        enderecoUsuario, cepUsuario, funcao,
                        senha, username);

                listaUsuario.add(usuario);
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

        return listaUsuario;
    }

    public static List<Usuario> procurarUsuario(String nome) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um usuario de acordo com o nome ou letra.
        //ultilizando o valor passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM usuario WHERE UPPER (NOMEUSUARIO) LIKE UPPER (?) AND DISPONIVEL=?";

        //Lista de usuarios de resultado
        List<Usuario> listaUsuario = null;

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
            preparedStatement.setString(1, "%" + nome + "%");
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //While passa por cada item (linha) do resultado
            while (result.next()) {

                //Se a lista não foi inicializada, a inicializa
                if (listaUsuario == null) {
                    listaUsuario = new ArrayList<Usuario>();
                }

                //Cria a instância Usuario, pega os valores obtidos pela consulta ao banco,
                //e a popula.
                int idUsuario = result.getInt("idUsuario");
                String nomeUsuario = result.getString("nomeUsuario");
                String sobrenomeUsuario = result.getString("sobrenomeUsuario");
                String funcao = result.getString("funcao");

                String cpfUsuario = result.getString("cpfUsuario");
                String emailUsuario = result.getString("emailUsuario");
                String telefoneUsuario = result.getString("telefoneUsuario");
                String estadoUsuario = result.getString("estadoUsuario");
                String cidadeUsuario = result.getString("cidadeUsuario");
                String enderecoUsuario = result.getString("enderecoUsuario");
                String cepUsuario = result.getString("cepUsuario");
                String username = result.getString("username");
                String senha = result.getString("senha");

                Usuario usuario = new Usuario(idUsuario, nomeUsuario, sobrenomeUsuario,
                        cpfUsuario, emailUsuario,
                        telefoneUsuario, estadoUsuario, cidadeUsuario,
                        enderecoUsuario, cepUsuario, funcao,
                        senha, username);

                //Adiciona a instãncia na lista.
                listaUsuario.add(usuario);
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
        return listaUsuario;
    }

    public static void excluirUsuario(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para "excluir" um cliente do banco de dados.
        //ultilizando o ID passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE usuario SET DISPONIVEL=? WHERE (idUsuario=?)";

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

    public static void atualizarUsuario(Usuario usuario) throws SQLException, Exception {

        //Monta a string com o comando SQL para atualizar dados na tabela cliente
        //ultilizando os dados do cliente passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "UPDATE usuario SET nomeUsuario=?, sobrenomeUsuario=?, cpfUsuario=?, emailUsuario=?, telefoneUsuario=?, estadoUsuario=?, cidadeUsuario=?,"
                + "enderecoUsuario=?, cepUsuario=?, senha=?, cargo=?"
                + "WHERE (idUsuario=?)";

        //connection para abertura e fechamento.
        Connection connection = null;

        //PreparedStatement para os comandos SQL e fechamento do mesmo.
        PreparedStatement preparedStatement = null;

        try {

            ////chama a classe criada ConnectionUtils.
            //abre a conexão com o banco de dados.
            connection = ConnectionUtils.getConnection();

            //cria um statement para execução de instruções SQL.
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do PreparedSatamente
            //cada preparedStatement ira ocupar uma interrogação na instrução SQL
            //que foi digitada acima, trocando seus valores pelo obtido do Cliente.
            preparedStatement.setString(1, usuario.getNome());

            preparedStatement.setString(2, usuario.getSobrenome());

            preparedStatement.setString(3, usuario.getCpf());

            preparedStatement.setString(4, usuario.getEmail());

            preparedStatement.setString(5, usuario.getTelefone());

            preparedStatement.setString(6, usuario.getEstado());

            preparedStatement.setString(7, usuario.getCidade());

            preparedStatement.setString(8, usuario.getEndereco());

            preparedStatement.setString(9, usuario.getCep());

            preparedStatement.setString(10, usuario.getSenha());

            preparedStatement.setString(11, usuario.getFuncao());

            preparedStatement.setInt(12, usuario.getId());

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

    public static Usuario procurarUsername(String username) throws SQLException, Exception {
        String sql = "SELECT * FROM Usuario WHERE USERNAME = (?) AND Disponivel = true ";
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
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            if (result.next()) {

                Usuario usuario = new Usuario();

                int idUsuario = result.getInt("idUsuario");
                String nomeUsuario = result.getString("nomeUsuario");
                String sobrenomeUsuario = result.getString("sobrenomeUsuario");
                String funcao = result.getString("funcao");

                String cpfUsuario = result.getString("cpfUsuario");
                String emailUsuario = result.getString("emailUsuario");
                String telefoneUsuario = result.getString("telefoneUsuario");
                String estadoUsuario = result.getString("estadoUsuario");
                String cidadeUsuario = result.getString("cidadeUsuario");
                String enderecoUsuario = result.getString("enderecoUsuario");
                String cepUsuario = result.getString("cepUsuario");
                username = result.getString("username");
                String senha = result.getString("senha");

                usuario.setNome(nomeUsuario);
                usuario.setId(idUsuario);
                usuario.setSobrenome(sobrenomeUsuario);
                usuario.setFuncao(funcao);

                usuario.setCpf(cpfUsuario);
                usuario.setEmail(emailUsuario);
                usuario.setTelefone(telefoneUsuario);
                usuario.setCidade(cidadeUsuario);
                usuario.setEstado(estadoUsuario);
                usuario.setEndereco(enderecoUsuario);
                usuario.setUsername(username);
                usuario.setSenha(senha);
                usuario.setCep(cepUsuario);

                return usuario;

            }

        } catch (Exception E) {
            E.printStackTrace();
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

        return null;
    }

    public static Usuario obterUsuario(Integer id) throws SQLException, Exception {

        //Monta a string com o comando SQL para procurar um cliente de acordo com o ID,
        //passado por parâmetro.
        //A String ira ser ultilizada pelo prepared statement
        String sql = "SELECT * FROM usuario WHERE (idUsuario=? AND disponivel=?)";

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
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados.
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {

                //Cria a instância Cliente, pega os valores obtidos pela consulta ao banco,
                //e a popula.
                int idCliente = result.getInt("idUsuario");
                String nomeCliente = result.getString("nomeUsuario");
                String sobrenomeCliente = result.getString("sobrenomeUsuario");

                String cpfCliente = result.getString("cpfUsuario");
                String emailCliente = result.getString("emailUsuario");
                String telefoneCliente = result.getString("telefoneUsuario");
                String estadoCliente = result.getString("estadoUsuario");
                String cidadeCliente = result.getString("cidadeUsuario");
                String enderecoCliente = result.getString("enderecoUsuario");
                String cepCliente = result.getString("cepUsuario");
                String funcao = result.getString("funcao");
                String username = result.getString("username");
                String senha = result.getString("senha");

                Usuario cliente = new Usuario(idCliente, nomeCliente, sobrenomeCliente, cpfCliente, 
                        emailCliente, telefoneCliente, estadoCliente, cidadeCliente, 
                        enderecoCliente, cepCliente, funcao, senha, username);

                //Retorna o resultado
                return cliente;
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

        //Se chegamos aqui, não foi encontrado nenhum cliente porque
        //a pesquisa não teve resultados
        //Neste caso, não há um cliente a retornar, então retornamos "null"
        return null;

    }

}
