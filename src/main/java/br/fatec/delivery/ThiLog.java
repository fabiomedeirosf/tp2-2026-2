package br.fatec.delivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThiLog implements Cotacao{

	@Override
	public Frete cotar(UFEnum ufOrigem, UFEnum ufDestino, Double peso) {
		
		Frete frete = new Frete("thiLog");
		
		frete.setValor(peso * peso * 2.3);
		
		if(ufOrigem.equals(ufDestino)) {
			frete.setPrazo(5);
		} else {
			frete.setPrazo(11);
		}
		
		if(isUfRestricao(ufDestino)) {
			frete.setPrazo(frete.getPrazo() + 5);
		}
		frete.setUnidade("dias");
		
		return frete;
	}
	
	private boolean isUfRestricao(UFEnum ufDestino) {
		//relacao dos unidades de uf norte e nordeste
		List<String> ufsAcrescimo = List.of("PR", "RS", "SC");
		
		if(ufsAcrescimo.contains(ufDestino.toString())) {
			return true;
		}
		return false;
	}

}
