package br.fatec.heranca;

public abstract class Imposto {

    public abstract Double calcularImposto(Double valorVenda);

    public Double calcularDeducaoImposto(Double valorBruto, Double imposto) {

        if( imposto <= (valorBruto * 0.2)) {
            return (imposto * 0.1);
        } 
        return 0D;
    }
    /**
     * Criar uma funcao para calcular a deducao de um imposto
     * para isso deverá receber o valor bruto, o valor do respectivo
     * imposto e aplicar a lógica: 
     *   - se o valor do imposto for ate 20% do valor bruto
     *     terá dedução de até 10% do valor do imposto
     * 
     * retornará o valor da deduçao
     */

}
