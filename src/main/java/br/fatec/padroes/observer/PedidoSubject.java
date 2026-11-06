package br.fatec.padroes.observer;

import java.util.ArrayList;
import java.util.List;

public class PedidoSubject implements Subject {

	private List<PedidoObserver> listaAssinantes = new ArrayList<PedidoObserver>();
	
	private Pedido pedido;
	
	@Override
	public void assinar(PedidoObserver observer) {
		this.listaAssinantes.add(observer);
		
	}

	@Override
	public void cancelar(PedidoObserver observer) {
		this.listaAssinantes.remove(observer);
		
	}

	@Override
	public void notificarObservers() {
		// TODO Auto-generated method stub
		
	}
	
	public void atualizarPedido(Pedido pedido) {
		this.pedido = pedido;
		
		this.notificarObservers();
	}

}
