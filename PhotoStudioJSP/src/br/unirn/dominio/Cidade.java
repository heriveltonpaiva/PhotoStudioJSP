/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;



/**
 *
 * @author HERIVELTON
 */

public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idCidade;
   
    private String descricao;
   
    private Estado idEstadoEstado;

    public Cidade() {
    }

    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(Integer idCidade, String descricao) {
        this.idCidade = idCidade;
        this.descricao = descricao;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   

    public Estado getIdEstadoEstado() {
        return idEstadoEstado;
    }

    public void setIdEstadoEstado(Estado idEstadoEstado) {
        this.idEstadoEstado = idEstadoEstado;
    }

   
    
}
