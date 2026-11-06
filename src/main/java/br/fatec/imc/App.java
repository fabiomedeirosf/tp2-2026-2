package br.fatec.imc;

import java.util.Scanner;

public class App {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("=== IMC - Indice de Massa Corporal ===");
		System.out.println();

		String continuar = "s";

		while ("s".equalsIgnoreCase(continuar)) {

			Double peso = lerNumero(teclado, "Informe o peso em kg: ");
			Double altura = lerNumero(teclado, "Informe a altura em cm: ");

			try {

				IMC imc = new IMC(peso, altura);
				ClassificacaoIMC classificacao = imc.classificar();

				System.out.println();
				System.out.println(String.format("IMC: %.2f", imc.calcular()));
				System.out.println("Classificação: " + classificacao.getEmoji() + " " + classificacao.getRotulo());
				System.out.println("Faixa: " + classificacao.getFaixa());
				System.out.println("O IMC é uma estimativa e não substitui uma avaliação médica.");

			} catch (IllegalArgumentException erro) {

				System.out.println(erro.getMessage());

			}

			System.out.println();
			System.out.print("Calcular outro IMC? (s/n): ");
			continuar = teclado.nextLine().trim();

		}

		teclado.close();

	}

	//le um numero e repete a pergunta enquanto o que foi digitado nao serve
	private static Double lerNumero(Scanner teclado, String pergunta) {

		while (true) {

			System.out.print(pergunta);

			//aceita 1,75 e 1.75: o Scanner.parseDouble so entenderia um deles,
			//conforme o locale da maquina
			String digitado = teclado.nextLine().trim().replace(',', '.');

			try {
				return Double.parseDouble(digitado);
			} catch (NumberFormatException erro) {
				System.out.println("Entrada inválida. Digite apenas números.");
			}

		}

	}

}