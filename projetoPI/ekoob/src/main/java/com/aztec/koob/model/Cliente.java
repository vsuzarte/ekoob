/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.model;

import java.sql.Date;

/**
 *
 * @author guigr
 */
public class Cliente {
    
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    private String endereco;
    private String cep;
    private String numCasa;
   
    public Cliente(int id, String nome, String sobrenome,  String cpf, String email, String telefone, String estado, String cidade, String endereco, String cep, String numCasa) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
        this.numCasa = numCasa;
    }

    public Cliente(String nome, String sobrenome, String cpf, String email, String telefone, String estado, String cidade, String endereco, String cep,  String numCasa) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cep = cep;
       
        this.numCasa = numCasa;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

 

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    
}
