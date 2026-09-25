package br.fatec.delivery;

public class CarolLog implements Cotacao {

	@Override
	public Frete cotar(UFEnum ufOrigem, UFEnum ufDestino, Double peso) {
		
		Frete frete = new Frete("carolLog");

		if(peso <= 5) {
			frete.setPrazo(2);
			frete.setValor(25D);
		} else if (peso > 5 && peso <= 20) {
			frete.setPrazo(4);
			frete.setValor(55D);
		} else {
			return null;
		}
		
		if(!UFEnum.SP.equals(ufOrigem) || !UFEnum.SP.equals(ufDestino)) {
			frete.setValor(frete.getValor() * 1.4);
		}
		frete.setUnidade("dias");
		
		return frete;
	}

}
