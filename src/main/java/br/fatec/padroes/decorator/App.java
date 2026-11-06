package br.fatec.padroes.decorator;

public class App {

	public static void main(String...strings) {
		
		Bebida cafe = new CafeExpresso();
		System.out.println(cafe.getDescricao() + ": " + cafe.getPreco());
		
		Bebida leite = new LeiteFazenda();
		System.out.println(leite.getDescricao() + ": " + leite.getPreco());
		
		BlendDecorator capuccino = new Capuccino(cafe, leite);
		
		System.out.println(capuccino.getDescricao() + capuccino.getPreco());
	}
	
	
}
