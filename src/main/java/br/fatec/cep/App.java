package br.fatec.cep;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);
		ViaCepClient cliente = new ViaCepClient();

		System.out.println("=== Consulta de CEP - ViaCEP ===");
		System.out.println();

		String continuar = "s";

		while ("s".equalsIgnoreCase(continuar)) {

			System.out.print("Informe o CEP: ");
			String cep = teclado.nextLine().trim();

			try {

				Endereco endereco = cliente.consultar(cep);

				if (endereco == null) {
					System.out.println("CEP não encontrado. Confira o número digitado.");
				} else {
					System.out.println();
					System.out.println("CEP: " + endereco.getCep());
					System.out.println("Logradouro: " + endereco.getLogradouroOuPadrao());
					System.out.println("Complemento: " + endereco.getComplementoOuPadrao());
					System.out.println("Bairro: " + endereco.getBairro());
					System.out.println("Cidade: " + endereco.getLocalidade());
					System.out.println("UF: " + endereco.getUf());
					System.out.println("DDD: " + endereco.getDdd());
				}

			} catch (IOException erro) {
				System.out.println("Não foi possível consultar o CEP: " + erro.getMessage());
			} catch (InterruptedException erro) {
				Thread.currentThread().interrupt();
				System.out.println("Consulta interrompida.");
				break;
			}

			System.out.println();
			System.out.print("Consultar outro CEP? (s/n): ");
			continuar = teclado.nextLine().trim();

		}

		teclado.close();

	}

}