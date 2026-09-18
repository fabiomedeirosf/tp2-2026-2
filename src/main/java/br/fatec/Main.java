package br.fatec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        final int TOTAL = 100;
        final int LIMITE = 100; // numeros de 0 a 99 (0 inclusive, 100 exclusive). Use 10 para 0-9

        List<Integer> numeros = gerarNumeros(TOTAL, LIMITE);
        Map<Integer, Integer> frequencia = contarFrequencia(numeros);

        System.out.println("Numeros sorteados (" + numeros.size() + "):");
        System.out.println(numeros);

        System.out.println("\nFrequencia de cada numero sorteado:");
        Map<Integer, Integer> ordenado = new TreeMap<>(frequencia);
        for (Entry<Integer, Integer> e : ordenado.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue() + " vez(es)");
        }

        int soma = frequencia.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nTotal verificado: " + soma);
        System.out.println("Numeros distintos: " + frequencia.size());
    }

    public static List<Integer> gerarNumeros(int quantidade, int limite) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>(quantidade);
        for (int i = 0; i < quantidade; i++) {
            lista.add(random.nextInt(limite));
        }
        return lista;
    }

    public static Map<Integer, Integer> contarFrequencia(List<Integer> numeros) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer n : numeros) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        return freq;
    }
}