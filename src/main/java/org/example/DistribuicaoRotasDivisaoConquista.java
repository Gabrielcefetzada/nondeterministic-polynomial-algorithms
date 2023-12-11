package org.example;

import java.util.*;

/**
 * Classe de distribuiçao e conquista. Gerado por valores aleatrios, ou por
 * valores pre definidos.
 * 
 */
class DistribuicaoRotasDivisaoConquista {
    /**
     * Funçao de gerar uma soluçao a partir de valores de rotas e numero de
     * caminhões aleatorios.
     * Printa o resultado e os valores aleatorizados no cmd
     */
    public static void distribuirRotas() {
        Random random = new Random();
        int tamanhoRotas = random.nextInt(41) + 10;
        int numCaminhoes = random.nextInt(11) + 1;
        System.out.println("Quantidade de rodas: " + tamanhoRotas + ", quantidade de caminhoes: " + numCaminhoes);
        int[] rotas = gerarRotas(tamanhoRotas);
        DistribuicaoRotasDivisaoConquista.distribuirRotas(rotas, numCaminhoes);
    }

    /**
     * Função que gera uma soluçao para um numero de rotas e caminhões.
     * 
     * @param rotas        O vetor de rotas que serão distribuidos entres os
     *                     veiculos
     * @param numCaminhoes O numero de veicuos para os quais serão distribuidos as
     *                     rotas.
     */
    public static void distribuirRotas(int[] rotas, int numCaminhoes) {
        Arrays.sort(rotas);
        int[] distribuicao = new int[numCaminhoes];
        Arrays.fill(distribuicao, 0);

        distribuir(rotas, rotas.length - 1, distribuicao);

        for (int i = 0; i < numCaminhoes; i++) {
            System.out.println("Caminhão " + (i + 1) + ": total " + distribuicao[i] + "km");
        }
    }

    /**
     * Função auxiliar que distribui as rotas entre os caminhões usando
     */
    private static void distribuir(int[] rotas, int index, int[] distribuicao) {
        if (index < 0)
            return;

        int minIndex = minIndex(distribuicao);

        distribuicao[minIndex] += rotas[index];

        distribuir(rotas, index - 1, distribuicao);
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

    /**
     * Função para gerar rotas aletatorias
     * 
     * @param tamanho Tamanho do vetor
     * @return Conjunto das rotas definidas aleatoriamente.
     */
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

}
