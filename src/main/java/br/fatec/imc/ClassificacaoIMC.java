package br.fatec.imc;

public enum ClassificacaoIMC {

	//	emoji, rotulo, limite inferior (incluso), limite superior (exclusivo)
	MAGREZA("🍃", "Magreza", 0D, 18.5D),

	NORMAL("✅", "Normal", 18.5D, 25D),

	SOBREPESO("⚠️", "Sobrepeso", 25D, 30D),

	OBESIDADE_I("🟠", "Obesidade grau I", 30D, 35D),

	OBESIDADE_II("🔴", "Obesidade grau II", 35D, 40D),

	OBESIDADE_III("🚨", "Obesidade grau III", 40D, Double.MAX_VALUE);

	private final String emoji;

	private final String rotulo;

	private final Double limiteInferior;

	private final Double limiteSuperior;

	private ClassificacaoIMC(String emoji, String rotulo, Double limiteInferior, Double limiteSuperior) {
		this.emoji = emoji;
		this.rotulo = rotulo;
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
	}

	//descobre a faixa de um valor de IMC. Cada faixa e fechada na esquerda
	//e aberta na direita, por isso 25.0 ja pertence a SOBREPESO e nao a NORMAL.
	public static ClassificacaoIMC de(Double imc) {
		for (ClassificacaoIMC classificacao : values()) {
			if (imc >= classificacao.limiteInferior && imc < classificacao.limiteSuperior) {
				return classificacao;
			}
		}
		return OBESIDADE_III;
	}

	public String getEmoji() {
		return emoji;
	}

	public String getRotulo() {
		return rotulo;
	}

	public String getFaixa() {
		return "[" + limiteInferior + ", " + limiteSuperior + ")";
	}

}