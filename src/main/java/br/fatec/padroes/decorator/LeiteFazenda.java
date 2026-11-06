package br.fatec.padroes.decorator;

public class LeiteFazenda extends Bebida {

	
	public LeiteFazenda() {
		super.descricao = "Leite da FAzenda";
	}
	
	@Override
	public Double getPreco() {
		return 4D;
	}

	@Override
	public String getDescricao() {
		return super.descricao;
	}

}
