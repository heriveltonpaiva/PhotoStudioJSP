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

public class Fotografocliente  {
   
    private Integer idFotografocliente;
   
    private Fotografo idFotografoFotografo;
   
    private Cliente idClienteCliente;

    public Fotografocliente() {
    }

    public Fotografocliente(Integer idFotografocliente) {
        this.idFotografocliente = idFotografocliente;
    }

    public Integer getIdFotografocliente() {
        return idFotografocliente;
    }

    public void setIdFotografocliente(Integer idFotografocliente) {
        this.idFotografocliente = idFotografocliente;
    }

    public Fotografo getIdFotografoFotografo() {
        return idFotografoFotografo;
    }

    public void setIdFotografoFotografo(Fotografo idFotografoFotografo) {
        this.idFotografoFotografo = idFotografoFotografo;
    }

    public Cliente getIdClienteCliente() {
        return idClienteCliente;
    }

    public void setIdClienteCliente(Cliente idClienteCliente) {
        this.idClienteCliente = idClienteCliente;
    }

    
}
