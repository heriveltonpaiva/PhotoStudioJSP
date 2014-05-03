package br.unirn.dominio;

public class Selecao {
	
	private Integer idSelecao;
	private Integer quantidade;
	private String tamanho;
	private double valor_venda;
	private Integer idfoto;
	private Integer idcliente;
	private Integer idfotografo;
	
	public Selecao() {
		// TODO Auto-generated constructor stub
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

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}


	public Integer getIdfoto() {
		return idfoto;
	}

	public void setIdfoto(Integer idfoto) {
		this.idfoto = idfoto;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdfotografo() {
		return idfotografo;
	}

	public void setIdfotografo(Integer idfotografo) {
		this.idfotografo = idfotografo;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	public Integer getIdSelecao() {
		return idSelecao;
	}
	
}
