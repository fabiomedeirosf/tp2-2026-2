package br.fatec.padroes.decorator;

import java.util.ArrayList;
import java.util.List;

public class Capuccino extends BlendDecorator {

	private List<Bebida> bebidas = new ArrayList<Bebida>();
	
	/**
	 * Construtor 
	 * @param bebidas varargs = lista de parametros = bebida[]
	 */
	public Capuccino(Bebida... bebidas) {
		this.bebidas = List.of(bebidas);
	}
	
	@Override
	public Double getPreco() {
		Double total = 0D;
		
		for(Bebida b : this.bebidas) {
			total += b.getPreco();
		}
		return (total + (total * 0.15));
	}

	@Override
	public String getDescricao() {
		String descricao = "Capuccino: Ingredientes [";
		for(Bebida b : this.bebidas) {
			descricao += b.getDescricao() + ", ";
		}
		descricao += "]";
		return descricao;
	}
	
	

	/**
	 * Carol, matheus eduardo, duda, duda, gabriel moretti, thiago henrique, kailany, yago, fernando, povidaico, rafael silva, rafael araujo, ronie, denner, thiago william
	 */
}
