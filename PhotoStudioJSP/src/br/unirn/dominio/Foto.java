/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;




public class Foto  {
    
    
    private Integer idFoto;
    
    private String descricao;
    
    private double valor;
    
    private byte[] arquivo;
    
    private String dataUpload;
    
    private String obs;
    
    private String fotoNome;
   
    private String contenttype;
   
    private Integer idAlbumAlbum;

    public Foto() {
    }

    public Foto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public Foto(Integer idFoto, String descricao, double valor, byte[] arquivo, String dataUpload, String fotoNome, String contenttype) {
        this.idFoto = idFoto;
        this.descricao = descricao;
        this.valor = valor;
        this.arquivo = arquivo;
        this.dataUpload = dataUpload;
        this.fotoNome = fotoNome;
        this.contenttype = contenttype;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(String dataUpload) {
        this.dataUpload = dataUpload;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getFotoNome() {
        return fotoNome;
    }

    public void setFotoNome(String fotoNome) {
        this.fotoNome = fotoNome;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public Integer getIdAlbumAlbum() {
        return idAlbumAlbum;
    }

    public void setIdAlbumAlbum(Integer idAlbumAlbum) {
        this.idAlbumAlbum = idAlbumAlbum;
    }

  
    
}
