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

public class Venda  {
   
 
    private Integer idVenda;
   
    private String descricao;
    
    private Date dataVenda;
   
    private Integer selecao; 
    
    private Selecao idSelecaoSelecao;
    
    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, Date dataVenda, int quantidade, String tamanho, double valorVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;

    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

  public Integer getSelecao() {
	return selecao;
}
  public void setSelecao(Integer selecao) {
	this.selecao = selecao;
}

  public Selecao getIdSelecaoSelecao() {
	return idSelecaoSelecao;
}
  public void setIdSelecaoSelecao(Selecao idSelecaoSelecao) {
	this.idSelecaoSelecao = idSelecaoSelecao;
}
    
}
