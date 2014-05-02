/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.math.BigInteger;


public class Carrinho  {
  
   
    private Integer idCarrinho;
    private Selecao selecao;  
    private Cliente idClienteCliente;

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

   public Selecao getSelecao() {
	return selecao;
}
   public void setSelecao(Selecao selecao) {
	this.selecao = selecao;
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
