package br.fatec.banco;

public class App {

	public static void main(String...strings) {
		
		Financeira roniPay = new RoniPay();
		
		
		Conta c1 = new Conta(123, "fabio");
		
		
		roniPay.depositar(c1, 100D);
		roniPay.sacar(c1, 50D);
		
		System.out.println(c1);
		
		Financeira dennerBank = new DennerBank();
		Conta c2 = new Conta(321, "Roni");
		
		dennerBank.depositar(c2, 1000D);
		System.out.println(c2);
		dennerBank.depositar(c2, 12000D);
		System.out.println(c2);
		
		Financeira dudaPay = new Duda2Pay();
		
		Conta c3 = new Conta(6778, "Denner");
		dudaPay.depositar(c3, 100D);
		System.out.println(c3);
		dudaPay.sacar(c3, 110D);
		dudaPay.depositar(c3, 300D);
		System.out.println(c3);
		dudaPay.sacar(c3, 50D); //erro
	}
}
