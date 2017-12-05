/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztec.koob.model;

import java.sql.Date;

/**
 *
 * @author Gabriel
 */
public class Usuario {

    private Integer id;
    private String nome;;
    private String sobrenome;;
    private String funcao;;
 
    private String cep;;
    private String username;
    private String cpf;;
    private String estado;;
    private String cidade;;
    private String endereco;;
    private String email;;
    private String telefone;;
    private String senha;
    
    public Usuario(){
        
    }

    public Usuario(int id, String nome, String sobrenome, 
            String cpf, String email, String telefone, String estado, 
            String cidade, String endereco, String cep, 
            String funcao, String senha, String username){
        
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
        this.funcao = funcao;
        this.senha = senha;
        this.username = username;
        
    }

  
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getSobrenome() {
        return sobrenome;
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

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
