package br.fatec.delivery;

public interface Cotacao {

	public Frete cotar(UFEnum ufOrigem, UFEnum ufDestino, Double peso);
	
	
}
