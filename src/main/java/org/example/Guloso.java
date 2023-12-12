package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Guloso {
    /**
     * Gera aleatoriamente um conjunto de rotas e distribui entre um número
     * aleatório de caminhões, imprimindo os resultados.
     */
    public static void distribuirRotas() {
        Random random = new Random();
        int tamanhoRotas = random.nextInt(41) + 10;
        int numCaminhoes = random.nextInt(11) + 1;
        System.out.println("Quantidade de rotas: " + tamanhoRotas + ", quantidade de caminhões: " + numCaminhoes);
        int[] rotas = gerarRotas(tamanhoRotas);
        Map<Integer, List<Integer>> rotasPorCaminhao = distribuirRotas(rotas, numCaminhoes);
        imprimirDistribuicao(rotasPorCaminhao);
    }

    /**
     * Distribui as rotas entre o número especificado de caminhões e retorna um mapa
     * representando as rotas de cada caminhão.
     * 
     * @param rotas        O vetor de rotas a serem distribuídas entre os caminhões.
     * @param numCaminhoes O número de caminhões para os quais as rotas serão
     *                     distribuídas.
     * @return Um mapa representando as rotas de cada caminhão.
     */
    public static Map<Integer, List<Integer>> distribuirRotas(int[] rotas, int numCaminhoes) {
        Arrays.sort(rotas);
        int[] distribuicao = new int[numCaminhoes];
        Arrays.fill(distribuicao, 0);
        Map<Integer, List<Integer>> rotasPorCaminhao = new HashMap<>();

        distribuir(rotas, rotas.length - 1, distribuicao, rotasPorCaminhao);
        imprimirDistribuicao(rotasPorCaminhao);
        return rotasPorCaminhao;
    }

    private static void distribuir(int[] rotas, int index, int[] distribuicao,
            Map<Integer, List<Integer>> rotasPorCaminhao) {
        if (index < 0)
            return;

        int minIndex = minIndex(distribuicao);

        distribuicao[minIndex] += rotas[index];
        rotasPorCaminhao.computeIfAbsent(minIndex, k -> new ArrayList<>()).add(rotas[index]);

        distribuir(rotas, index - 1, distribuicao, rotasPorCaminhao);
    }

    private static int minIndex(int[] distribuicao) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distribuicao.length; i++) {
            if (distribuicao[i] < min) {
                min = distribuicao[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static int[] gerarRotas(int tamanho) {
        Random random = new Random();
        int[] rotas = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            rotas[i] = random.nextInt(41) + 10;
        }
        System.out.println("Rotas geradas:");
        for (int i = 0; i < rotas.length; i++) {
            System.out.print(rotas[i] + ", ");
        }
        System.out.println();
        return rotas;
    }

    private static void imprimirDistribuicao(Map<Integer, List<Integer>> rotasPorCaminhao) {
        for (Map.Entry<Integer, List<Integer>> entry : rotasPorCaminhao.entrySet()) {
            int caminhao = entry.getKey();
            List<Integer> rotas = entry.getValue();
            System.out.println(
                    "Caminhão " + (caminhao + 1) + ": rotas " + rotas + " - total " + calcularDistancia(rotas) + "km");
        }

        int distanciaMaxima = calcularDistanciaMaxima(rotasPorCaminhao);
        System.out.println("Distância máxima percorrida: " + distanciaMaxima + "km");
    }

    private static int calcularDistancia(List<Integer> rotas) {
        int distancia = 0;
        for (int rota : rotas) {
            distancia += rota;
        }
        return distancia;
    }

    private static int calcularDistanciaMaxima(Map<Integer, List<Integer>> rotasPorCaminhao) {
        int distanciaMaxima = 0;
        for (List<Integer> rotas : rotasPorCaminhao.values()) {
            int distanciaCaminhao = calcularDistancia(rotas);
            distanciaMaxima = Math.max(distanciaMaxima, distanciaCaminhao);
        }
        return distanciaMaxima;
    }
}
