package br.fatec.banco;

public class DennerBank extends FinanceiraPadrao {

	@Override
	public Double depositar(Conta conta, Double valor) {
		
		if(valor <= 0D) {
			throw new RuntimeException("Valor Inválido: " + valor);
		}
		
		Double incentivo = 0D;
		/*if(valor <= 1000) {
			incentivo = (valor * 0.03);
		} else {
			incentivo = 100D;
		}*/
		
		incentivo = (valor <= 1000D) ? (valor * 0.03) : 100D;
		
		conta.atualizarSaldo(valor);
		
		Double saldoAtualizado = conta.atualizarSaldo(incentivo);
		return saldoAtualizado;
	}

	

}
