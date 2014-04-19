/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.util.List;


public class Bairro  {
 
    
    private Integer idBairro;
   
    private String descricao;
    
    private Cidade idCidadeCidade;
  
    private List<Endereco> enderecoList;

    public Bairro() {
    }

    public Bairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public Bairro(Integer idBairro, String descricao) {
        this.idBairro = idBairro;
        this.descricao = descricao;
    }

    public Integer getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cidade getIdCidadeCidade() {
        return idCidadeCidade;
    }

    public void setIdCidadeCidade(Cidade idCidadeCidade) {
        this.idCidadeCidade = idCidadeCidade;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

   
    
}
