/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.math.BigInteger;


public class Carrinho  {
  
   
    private Integer idCarrinho;
    private Integer selecao;  
    private Selecao idSelecaoSelecao;
    private Integer idClienteCliente;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Carrinho(Integer idCarrinho, int quantidade, String tamanho, BigInteger valorVenda) {
        this.idCarrinho = idCarrinho;

    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

   public Integer getIdClienteCliente() {
	return idClienteCliente;
}
   public void setIdClienteCliente(Integer idClienteCliente) {
	this.idClienteCliente = idClienteCliente;
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
