package br.fatec.delivery;

public class App {

	public static void main(String...strings) {
		
		BIDTransporte bid = new BIDTransporte();
		
		System.out.print("Ganhador: "+ bid.cotarFretes(UFEnum.SP, UFEnum.BA, 1D));
	}
}
