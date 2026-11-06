package br.fatec.cep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

//acessa a API publica da ViaCEP e transforma o JSON recebido em um Endereco
public class ViaCepClient {

	private static final String BASE = "https://viacep.com.br/ws/";

	private static final Duration TEMPO_LIMITE = Duration.ofSeconds(10);

	private final HttpClient cliente;

	private final Gson gson;

	public ViaCepClient() {
		this.cliente = HttpClient.newBuilder().connectTimeout(TEMPO_LIMITE).build();
		this.gson = new Gson();
	}

	//devolve o endereco do cep ou null quando a ViaCEP responde que o cep nao existe
	public Endereco consultar(String cep) throws IOException, InterruptedException {

		//a API so aceita os 8 digitos, sem o hifen
		String digitos = somenteDigitos(cep);

		if (digitos.isEmpty()) {
			return null;
		}

		HttpRequest requisicao = HttpRequest.newBuilder()
				.uri(URI.create(BASE + digitos + "/json/"))
				.header("Accept", "application/json")
				.timeout(TEMPO_LIMITE)
				.GET()
				.build();

		HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		if (resposta.statusCode() != 200) {
			throw new IOException("a ViaCEP respondeu com o status " + resposta.statusCode());
		}

		//quando o cep nao existe, a resposta e apenas {"erro": true}, sem os campos do endereco
		JsonObject json = gson.fromJson(resposta.body(), JsonObject.class);

		if (json.has("erro")) {
			return null;
		}

		return gson.fromJson(json, Endereco.class);

	}

	private String somenteDigitos(String texto) {

		StringBuilder digitos = new StringBuilder();

		for (char caractere : texto.toCharArray()) {
			if (Character.isDigit(caractere)) {
				digitos.append(caractere);
			}
		}

		return digitos.toString();

	}

}