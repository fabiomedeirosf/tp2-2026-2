package br.fatec.heranca;

public class ImpostoMG extends Imposto {

    @Override
    public Double calcularImposto(Double valorVenda) {
        
        if(valorVenda > 100D && valorVenda <=1000D) {
            return (valorVenda * 0.065);
        } else if (valorVenda > 1000D) {
            return (valorVenda * 0.12);
        }

        return 0D;
    }
}
