package br.fatec.heranca.apostas;

import java.util.ArrayList;
import java.util.List;

public abstract class Apuracao {

	public List<Integer> apurarAcertos(List<Integer> apostas, List<Integer> sorteios) {

		List<Integer> listaAcertos = new ArrayList<>();
		
		for(Integer aposta : apostas) {
			if(sorteios.contains(aposta)) {
				listaAcertos.add(aposta);
			}
		}
		
		return listaAcertos;
	}
	
	public abstract String apurar(List<Integer> acertos);
}
