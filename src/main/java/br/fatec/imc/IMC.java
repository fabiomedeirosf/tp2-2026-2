package br.fatec.imc;

public class IMC {

	private Double peso;

	private Double altura;

	public IMC(Double peso, Double altura) {
		setPeso(peso);
		setAltura(altura);
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("Peso deve ser maior que zero.");
		}
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		if (altura <= 0) {
			throw new IllegalArgumentException("Altura deve ser maior que zero.");
		}
		this.altura = altura;
	}

	//a altura entra em centimetros e a formula exige metros
	public Double calcular() {
		Double metros = altura / 100;
		return peso / (metros * metros);
	}

	public ClassificacaoIMC classificar() {
		return ClassificacaoIMC.de(calcular());
	}

	@Override
	public String toString() {
		return "IMC [peso=" + peso + ", altura=" + altura + "cm, valor=" + calcular() + "]";
	}

}