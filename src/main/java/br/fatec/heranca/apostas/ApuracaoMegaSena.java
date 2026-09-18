package br.fatec.heranca.apostas;

import java.util.List;

public class ApuracaoMegaSena extends Apuracao {

	public String apurar(List<Integer> acertos) {
		
		if(acertos.size() == 4) {
			return "ganhou quadra";
		} else if (acertos.size() == 5) {
			return "ganhou quina :) ";
		} else if (acertos.size() == 6) {
			return "GAaaanhhhhou praia 4 ever ";
		}
		
		return "Nao foi desta vez =/ ";
	}
}
