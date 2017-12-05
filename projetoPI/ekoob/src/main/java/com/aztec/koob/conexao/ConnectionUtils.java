package com.aztec.koob.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtils {
    //Classe ultilizada para abertura e fechamento de conexões com o banco de dados.
    

    //consegue um conexão com o banco de dados.
    public static Connection getConnection() {

        //Connection representa uma conexão ao banco de dados.
        //variável connection para abertura e fechamento.
        Connection connection = null;

        try {

            //Classe MainConstants é chamada por conter os dados do banco de dados.
            
            
            //Endereço de conexão com o banco de dados
            String dbURL = MainConstants.DB_ADDRESS;
            
            //Properties serve para passar configurações para uma determinada aplicação que 
            //necessita de configurações externas e a mesma em si não pode 
            //ser alterada.

            
            Properties properties = new Properties();

            properties.put("user", MainConstants.DB_USER);
            properties.put("password", MainConstants.DB_PASS);

            //DriverManager: O serviço básico para gerenciar um conjunto de drivers JDBC. 
            
            ////Realiza a conexão com o banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }

        //Retorna a conexão
        return connection;

    }

}