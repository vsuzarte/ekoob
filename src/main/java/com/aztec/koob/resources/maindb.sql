/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  guilherme.rpinto
 * Created: 03/10/2017
 */

    CREATE TABLE Produto(
        idProduto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeProduto VARCHAR(50) NOT NULL,
        quantidade INT NOT NULL,
        autor VARCHAR(255),
        editora VARCHAR(255),
        ano VARCHAR(255),
        valorProduto DOUBLE NOT NULL,
        disponivel BOOLEAN
       
);

    CREATE TABLE Cliente (
        idCliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeCliente VARCHAR(50) NOT NULL,
        sobrenomeCliente VARCHAR(50) NOT NULL,
        cpfCliente VARCHAR(14) NOT NULL UNIQUE,
        emailCliente VARCHAR(50) NOT NULL,
        telefoneCliente VARCHAR(14) NOT NULL,
        estadoCliente VARCHAR(50),
        cidadeCliente VARCHAR(50),
        enderecoCliente VARCHAR(50),
        cepCliente VARCHAR(50),
        numCasa INT NOT NULL,
        disponivel BOOLEAN
);

    CREATE TABLE Usuario (
        idUsuario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeUsuario VARCHAR(50) NOT NULL,
        sobrenomeUsuario VARCHAR(50) NOT NULL,
        funcao VARCHAR(50) NOT NULL,
        cpfUsuario VARCHAR(14) NOT NULL UNIQUE,
        emailUsuario VARCHAR(50) NOT NULL,
        telefoneUsuario VARCHAR(14) NOT NULL,
        estadoUsuario VARCHAR(50),
        cidadeUsuario VARCHAR(50),
        enderecoUsuario VARCHAR(50),
        cepUsuario VARCHAR(10),
        userName VARCHAR(20)NOT NULL,
        senha VARCHAR(20) NOT NULL,
        disponivel BOOLEAN
        
);

    CREATE TABLE Venda (
        idVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        idCliente INT NOT NULL,
        valorTotal DOUBLE NOT NULL,
        FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
      
);

    CREATE TABLE ItemVenda(
        idItemVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        idVenda INTEGER NOT NULL,
        idProduto INTEGER NOT NULL,
        Quantidade INT NOT NULL,
        FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
        FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);

   

INSERT INTO USUARIO(NOMEUSUARIO,SOBRENOMEUSUARIO,FUNCAO,CPFUSUARIO,EMAILUSUARIO,TELEFONEUSUARIO,ESTADOUSUARIO,CIDADEUSUARIO,ENDERECOUSUARIO,CEPUSUARIO,USERNAME,SENHA,DISPONIVEL) VALUES ('ADMIN','ADMIN','gerente','ADMIN','ADMIN','ADMIN','ADMIN','ADMIN','ADMIN','ADMIN','ADMIN','ADMIN',TRUE);
INSERT INTO USUARIO(NOMEUSUARIO,SOBRENOMEUSUARIO,FUNCAO,CPFUSUARIO,EMAILUSUARIO,TELEFONEUSUARIO,ESTADOUSUARIO,CIDADEUSUARIO,ENDERECOUSUARIO,CEPUSUARIO,USERNAME,SENHA,DISPONIVEL) VALUES ('VENDEDOR','VENDEDOR','vendedor','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR','VENDEDOR',TRUE);



/*

    CREATE TABLE Filial (
        idFilial INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, ICREMENT BY 1)
        CONSTRAINT PK_Filial PRIMARY KEY,
        nomeFilial VARCHAR(50) NOT NULL,
        estadoFilial VARCHAR(50) NOT NULL,
        cidadeFilial VARCHAR(50) NOT NULL
);

    CREATE TABLE Relatorio(
        idRelatorio INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nmProduto VARCHAR(50) NOT NULL,
        nmCliente VARCHAR(50) NOT NULL,
        venda TIMESTAMP NOT NULL,
        vlFinal DOUBLE NOT NULL,
        valorProduto DOUBLE NOT NULL,
        quantProduto INT NOT NULL
        FOREIGN KEY (nomeProduto) REFERENCES Produto(nomeProduto),
        FOREIGN KEY(nomeCliente) REFERENCES Cliente(nomeCliente),
        FOREIGN KEY (venda) REFERENCES Venda(dataVenda),
        FOREIGN KEY (vlFinal) REFERENCES Venda(valorFinal),
        FOREIGN KEY(valorProduto) REFERENCES Produto(valorProduto),
        FOREIGN KEY(quantProduto) REFERENCES Produto(quantidade)
);*/
