package br.fatec;

public class App {

	public static void main(String...strings ) {
		
		Calculadora c;
		
		new Calculadora(); //novo objeto (heap)
		
		//instancia novo objeto e referenciado
		//variavel c do tipo Calculadora
		c = new Calculadora(); 
		
		c.tipoCalculadora ="basica";
		
		Calculadora c2 = new Calculadora();
		c2.tipoCalculadora = "cientifica";
		
		System.out.println(c2.somar(4, 3));
	}
}
