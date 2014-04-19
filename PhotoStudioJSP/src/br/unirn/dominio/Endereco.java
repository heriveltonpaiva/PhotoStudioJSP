/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;




/**
 *
 * @author HERIVELTON
 */

public class Endereco  {
 
    
    private Integer idEndereco;
   
    private String descricao;
    
    private Integer numero;
 
    private String cep;
    
    private String complemento;
   
    
    private Bairro idBairroBairro;

    public Endereco() {
    }

    public Endereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Endereco(Integer idEndereco, String descricao) {
        this.idEndereco = idEndereco;
        this.descricao = descricao;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public Bairro getIdBairroBairro() {
        return idBairroBairro;
    }

    public void setIdBairroBairro(Bairro idBairroBairro) {
        this.idBairroBairro = idBairroBairro;
    }

    
    
}
