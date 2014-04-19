/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.util.Date;



/**
 *
 * @author HERIVELTON
 */

public class Cliente  {
    
   
    private Integer idCliente;
   
    private String nome;
    
    private String login;
    
    private String senha;
    
    private String cpf;
   
    private Date dataNascimento;
   
    private Endereco idEnderecoEndereco;
  
    private Contato idContatoContato;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nome, String login, String senha, String cpf, Date dataNascimento) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   

    public Endereco getIdEnderecoEndereco() {
        return idEnderecoEndereco;
    }

    public void setIdEnderecoEndereco(Endereco idEnderecoEndereco) {
        this.idEnderecoEndereco = idEnderecoEndereco;
    }

    public Contato getIdContatoContato() {
        return idContatoContato;
    }

    public void setIdContatoContato(Contato idContatoContato) {
        this.idContatoContato = idContatoContato;
    }

  
}
