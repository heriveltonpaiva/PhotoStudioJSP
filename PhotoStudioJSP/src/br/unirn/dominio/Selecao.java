package br.unirn.dominio;

public class Selecao {
	
	private Integer idSelecao;
	private Integer quantidade;
	private String tamanho;
	private double valor_venda;
	private Foto foto;
	private Cliente cliente;
	private Fotografo fotografo;
	
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

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fotografo getFotografo() {
		return fotografo;
	}

	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	
	public void setIdSelecao(Integer idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	public Integer getIdSelecao() {
		return idSelecao;
	}
	
}
