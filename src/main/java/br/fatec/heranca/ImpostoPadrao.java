package br.fatec.heranca;

public class ImpostoPadrao extends Imposto {

    @Override 
    public Double calcularImposto(Double valorVenda) {

        Double imposto = (valorVenda * 0.1);

        return imposto;
    }
}
