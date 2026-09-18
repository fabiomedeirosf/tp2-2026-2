package br.fatec.banco;

public class Duda2Pay implements Financeira {

	@Override
	public Double depositar(Conta conta, Double valor) {
		if(valor <= 0D) {
			throw new RuntimeException("Valor Inválido para depósito");
		}
		
		return conta.atualizarSaldo(valor);
	}

	@Override
	public Double sacar(Conta conta, Double valor) {
		
		Double limite = conta.getSaldo() * 0.10;
		
		if(valor > (limite + conta.getSaldo())) {
			throw new RuntimeException("Saldo insuficiente: " + conta);
		}
		
		return conta.atualizarSaldo(-valor);
	}

	
}
