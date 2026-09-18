package br.fatec.heranca;

public class App {

    public static void main(String... args) {

        Imposto imposto = new ImpostoPadrao();

        System.out.println("Valor IMposto: " + imposto.calcularImposto(1500D));
        
        imposto = new ImpostoMG();

        System.out.println("mg: " + imposto.calcularImposto(1500D));
        
        imposto = new ImpostoRJ();
        System.out.println("RJ: " + imposto.calcularImposto(12000D));
    }
}
