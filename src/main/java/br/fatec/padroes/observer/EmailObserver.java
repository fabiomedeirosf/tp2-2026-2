package br.fatec.padroes.observer;

public class EmailObserver implements PedidoObserver {

	@Override
	public void processar(Pedido pedido) {
		System.out.println("EmailObserver.processar()" + pedido);		
	}
}
