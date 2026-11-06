package br.fatec.padroes.observer;

public interface Subject {

	public void assinar(PedidoObserver observer);
	
	public void cancelar(PedidoObserver observer);
	
	public void notificarObservers();
}
