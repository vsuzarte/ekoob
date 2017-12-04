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
    private int qtde = 0;
    private int idProduto;
    private int idVenda;
    private float preco;

    

    public float getpreco() {
        return preco;
    }

    public void setQtd(int qtd) {
        this.qtde = qtde;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void diminuirQtd() {
        if (qtde > 0) {
            qtde--;
        }

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

    public Float getPreco() {
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

  

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setIdProduto(int id) {
        idProduto = id;
    }

    public int getIdProduto() {
        return idProduto;
    }
}
