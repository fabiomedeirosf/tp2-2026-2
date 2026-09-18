package br.fatec.heranca.apostas;

import java.util.List;

public class ApuracaoLotoFacil extends Apuracao{

	@Override
	public String apurar(List<Integer> acertos) {
		
		if(acertos.size() == 15) {
			return "voce ganhou";
		} 
		
		return "nao foi dessa vez";
	}

}
