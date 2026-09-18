package br.fatec.banco;

public abstract class FinanceiraPadrao implements Financeira {

	@Override
	public Double depositar(Conta conta, Double valor) {
		
		if(valor <= 0D) {
			throw new RuntimeException("Valor Inválido para depósito");
		}
		
		return conta.atualizarSaldo(valor);
	}

	@Override
	public Double sacar(Conta conta, Double valor) {
		
		if(valor > conta.getSaldo()) {
			throw new RuntimeException("Saldo insuficiente: " + conta);
		}
		
		return conta.atualizarSaldo(-valor);
	}
}
