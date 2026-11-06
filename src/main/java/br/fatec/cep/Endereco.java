package br.fatec.cep;

//os nomes dos atributos sao iguais as chaves do JSON devolvido pela ViaCEP,
//por isso o Gson preenche os campos sem precisar de anotacoes
public class Endereco {

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private String localidade;

	private String uf;

	private String ddd;

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getDdd() {
		return ddd;
	}

	//a ViaCEP devolve complemento vazio em muitos CEPs, aqui o campo ausente vira texto
	public String getComplementoOuPadrao() {
		return complemento == null || complemento.isBlank() ? "-" : complemento;
	}

	public String getLogradouroOuPadrao() {
		return logradouro == null || logradouro.isBlank() ? "-" : logradouro;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}

}