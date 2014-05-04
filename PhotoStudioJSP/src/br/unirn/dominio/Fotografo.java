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

public class Fotografo  {
   
    
    private Integer idFotografo;
    
    
    private String nome;
   
    private String cpfFotografo;
   
    private String login;
   
    private String senha;
   
    private Date dataNascimento;
   
    private Gestor idGestorGestor;
       
    private Integer idEndereco;
    
    private Endereco idEnderecoEndereco;
    
    private Contato idContatoContato;
   
    public Fotografo() {
    }

    public Fotografo(Integer idFotografo) {
        this.idFotografo = idFotografo;
    }

    public Fotografo(Integer idFotografo, String nome, String cpfFotografo, String login, String senha, Date dataNascimento, Integer idEndereco) {
        this.idFotografo = idFotografo;
        this.nome = nome;
        this.cpfFotografo = cpfFotografo;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.idEndereco = idEndereco;
    }

    public Integer getIdFotografo() {
        return idFotografo;
    }

    public void setIdFotografo(Integer idFotografo) {
        this.idFotografo = idFotografo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfFotografo() {
        return cpfFotografo;
    }

    public void setCpfFotografo(String cpfFotografo) {
        this.cpfFotografo = cpfFotografo;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   public Integer getIdEndereco() {
	return idEndereco;
}
   public void setIdEndereco(Integer idEndereco) {
	this.idEndereco = idEndereco;
}
    public Gestor getIdGestorGestor() {
        return idGestorGestor;
    }

    public void setIdGestorGestor(Gestor idGestorGestor) {
        this.idGestorGestor = idGestorGestor;
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

    

	@Override
	public String toString() {
		return "Fotografo [idFotografo=" + idFotografo + ", nome=" + nome
				+ ", cpfFotografo=" + cpfFotografo + ", login=" + login
				+ ", senha=" + senha + ", dataNascimento=" + dataNascimento
				+ ", idGestorGestor=" + idGestorGestor
				+ ", idEnderecoEndereco=" + idEnderecoEndereco
				+ ", idContatoContato=" + idContatoContato + "]";
	}
   
    
}
