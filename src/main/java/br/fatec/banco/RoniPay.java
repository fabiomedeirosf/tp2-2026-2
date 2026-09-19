package br.fatec.banco;

public class RoniPay extends FinanceiraPadrao 
					 implements Financiamento {

	@Override
	public Double financiar(Conta conta, Double valor) {
	
		Double valorAprovado = conta.getSaldo() * 0.20;
		
		if(valor > valorAprovado) {
			throw new RuntimeException(
					"Valor não aprovado! Disponível: " + valorAprovado);
		}
		
		conta.setValorFinanciamento(valor);
		
		return valor;
	}
	

}
