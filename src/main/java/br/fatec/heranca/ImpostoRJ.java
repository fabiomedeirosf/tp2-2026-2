package br.fatec.heranca;

public class ImpostoRJ extends ImpostoPadrao {

    @Override
    public Double calcularImposto(Double valorVenda) {
        
        if(valorVenda <= 10000D) {
            return super.calcularImposto(valorVenda);
        } else if (valorVenda > 10000D && valorVenda <= 100000D) {
            return (valorVenda *0.08);
        } else {
            return (valorVenda * 0.13);
        }
    }
}
