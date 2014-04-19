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
   
    private int quantidade;
    
    private String tamanho;
   
    private double valorVenda;
    
    private Fotografo idFotografoFotografo;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, Date dataVenda, int quantidade, String tamanho, double valorVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.valorVenda = valorVenda;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Fotografo getIdFotografoFotografo() {
        return idFotografoFotografo;
    }

    public void setIdFotografoFotografo(Fotografo idFotografoFotografo) {
        this.idFotografoFotografo = idFotografoFotografo;
    }

    
}
