package br.fatec.delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RichLog implements Cotacao{

	@Override
	public Frete cotar(UFEnum ufOrigem, UFEnum ufDestino, Double peso) {
		
		Frete frete = new Frete("richLog");
		
		if(peso <= 10) {
			frete.setPrazo(4);
			frete.setValor(15D);
		} else if(peso <= 30) {
			frete.setPrazo(9);
			frete.setValor(40D);
		} else {
			frete.setValor(peso * 2.3);
			frete.setPrazo(15);
		}
		
		
		if(isAcrescimoPorUf(ufDestino)) {
			frete.setValor(frete.getValor() * 1.55);
		}
		return frete;
	}
	
	private boolean isAcrescimoPorUf(UFEnum ufDestino) {
		//relacao dos unidades de uf norte e nordeste
		List<String> ufsAcrescimo = new ArrayList<>(
				Arrays.asList("AC", "AP", "AM", "PA", "RO", "RR", "TO", 
	            "AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"));
		
		if(ufsAcrescimo.contains(ufDestino.toString())) {
			return true;
		}
		return false;
	}

}
