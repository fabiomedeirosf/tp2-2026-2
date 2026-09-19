package br.fatec.banco;

public class Duda2Pay extends FinanceiraPadrao {


	@Override
	public Double sacar(Conta conta, Double valor) {
		
		Double limite = conta.getSaldo() * 0.10;
		
		if(valor > (limite + conta.getSaldo())) {
			throw new RuntimeException("Saldo insuficiente: " + conta);
		}
		
		return conta.atualizarSaldo(-valor);
	}

	
}
