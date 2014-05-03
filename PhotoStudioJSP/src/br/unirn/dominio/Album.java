/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;


import java.util.Date;




public class Album  {
    
    private Integer idAlbum;
  
    private String descricao;
    
    private Date data;
   
    private String obs;
  
    private Integer idFotografo;
    
    private Fotografo idFotografoFotografo;
    

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Album(Integer idAlbum, String descricao, Date data) {
        this.idAlbum = idAlbum;
        this.descricao = descricao;
        this.data = data;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Fotografo getIdFotografoFotografo() {
        return idFotografoFotografo;
    }

    public void setIdFotografoFotografo(Fotografo idFotografoFotografo) {
        this.idFotografoFotografo = idFotografoFotografo;
    }

	public Integer setIdFotografo(Integer idFotografo) {
		return this.idFotografo = idFotografo;
	}
	public Integer getIdFotografo() {
		return idFotografo;
	}

    

    
}
