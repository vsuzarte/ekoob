/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.aztec.koob.model;

import java.sql.Date;

/**
 *
 * @author guilherme.gcosta6
 */
public class Produto {

    private Integer id;
    private String nome;
    private String autor;
    private String editora;
    private String ano;
    private int quantidade;
    private double preco;

    public Produto(String nome, String autor, String editora, String ano, int quantidade, double preco) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    


    public Produto(Integer id, String nome, String autor, String editora, String ano, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

  

}
