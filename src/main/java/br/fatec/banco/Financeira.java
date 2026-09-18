package br.fatec.banco;

public interface Financeira {

	public abstract Double depositar(Conta conta, Double valor);
	
	public Double sacar(Conta conta, Double valor);
	

}
