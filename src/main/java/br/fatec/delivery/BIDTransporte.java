package br.fatec.delivery;

public class BIDTransporte {

	public Frete cotarFretes(UFEnum origem, UFEnum destino, Double peso) {
		
		Cotacao cotacao = new CarolLog();
		
		Frete carolLog = cotacao.cotar(origem, destino, peso);
		
		cotacao = new RichLog();
		
		Frete richLog = cotacao.cotar(origem, destino, peso);
		
		cotacao = new ThiLog();
		
		Frete thiLog = cotacao.cotar(origem, destino, peso);
		
		Frete vencedor = carolLog;
		
		System.out.println(carolLog);
		System.out.println(thiLog);
		System.out.println(richLog);
		
		if(richLog.getValor() < vencedor.getValor()) {
			vencedor = richLog;
		}
		
		if(thiLog.getValor() < vencedor.getValor() ) {
			vencedor = thiLog;
		}
		
		return vencedor;
		
	}
}
