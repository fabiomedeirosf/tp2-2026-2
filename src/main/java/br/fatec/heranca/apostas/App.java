package br.fatec.heranca.apostas;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String...strings) {
		
		Apuracao apuracao = new ApuracaoMegaSena();
		
		List<Integer> listaApostas = Arrays.asList(6, 11, 20, 23,54,55);
		
		List<Integer> listaSorteio = Arrays.asList(6, 11, 17, 23, 51, 55);
		
		List<Integer> listaAcertos = apuracao.apurarAcertos(listaApostas, listaSorteio);
		
		
		System.out.println("Acertos: "+ listaAcertos);
		System.out.println("resultado: " + apuracao.apurar(listaAcertos));
	
	}
}
