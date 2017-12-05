/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.model;

/**
 *
 * @author Gabriel
 */
public class ItemVenda {

    private int id;
    private int qtde;
    private int idProduto;
    private String nome;
    private double preco;
    private double valor;

    public String getnomeProduto() {
        return nome;
    }

    public double getpreco() {
        return preco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    

    public void setId(int novo) {
        this.id = novo;
    }

    public int getId() {
        return id;
    }

    public void calcPreco() {
        this.preco = preco * qtde;

    }

    public double getPreco() {
        return preco;
    }

    public void aumentarQtde() {
        this.qtde++;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int n) {
        qtde = n;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setIdProduto(int id) {
        idProduto = id;
    }

    public int getIdProduto() {
        return idProduto;
    }
}
