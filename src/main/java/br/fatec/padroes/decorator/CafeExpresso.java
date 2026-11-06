package br.fatec.padroes.decorator;

public class CafeExpresso extends Bebida {
	
	public CafeExpresso() {
		this.descricao = "Cafe Expresso da Montanha";
	}
	
	@Override
	public Double getPreco() {
		return 5D;
	}

	@Override
	public String getDescricao() {
		return super.descricao;
	}
	

}
