/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.math.BigInteger;


public class Carrinho  {
  
   
    private Integer idCarrinho;
    
   
    private String descricao;
    
    private int quantidade;
   
    private String tamanho;
   
    private BigInteger valorVenda;
    
    private Cliente idClienteCliente;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Carrinho(Integer idCarrinho, int quantidade, String tamanho, BigInteger valorVenda) {
        this.idCarrinho = idCarrinho;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.valorVenda = valorVenda;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public BigInteger getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigInteger valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Cliente getIdClienteCliente() {
        return idClienteCliente;
    }

    public void setIdClienteCliente(Cliente idClienteCliente) {
        this.idClienteCliente = idClienteCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrinho != null ? idCarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.idCarrinho == null && other.idCarrinho != null) || (this.idCarrinho != null && !this.idCarrinho.equals(other.idCarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Carrinho[ idCarrinho=" + idCarrinho + " ]";
    }
    
}
