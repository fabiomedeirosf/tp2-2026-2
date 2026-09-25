package br.fatec.delivery;

public class Frete {

	private String transportadora;
	
	private Double valor;
	
	private Integer prazo;
	
	private String unidade;
	
	public Frete(String transportadora) {
		this.transportadora = transportadora;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Frete [transportadora=" + transportadora + ", valor=" + valor + ", prazo=" + prazo + ", unidade="
				+ unidade + "]";
	}

	
}
	
