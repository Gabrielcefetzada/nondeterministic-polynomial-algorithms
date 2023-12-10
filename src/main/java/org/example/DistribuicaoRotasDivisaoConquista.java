package org.example;

import java.util.*;

/*
 * Funcao de distribuiçao e conquista. Gerado por valores aleatrios, ou por valores pre definidos.
 * 
 */
class DistribuicaoRotasDivisaoConquista {
    // Função para distribuir as rotas entre os caminhões, com um numero aleatorio
    // de rotas e de caminhoes
    public static void distribuirRotas() {
        Random random = new Random();
        int tamanhoRotas = random.nextInt(41) + 10; // quantidade de rotas aleatorias de 10 a 50
        int numCaminhoes = random.nextInt(11) + 1; // quantidade de caminhoes aleatorios de 1 a 10
        System.out.println("Quantidade de rodas: " + tamanhoRotas + ", quantidade de caminhoes: " + numCaminhoes);
        // Gerar rotas aleatórias (simulando seu gerador de problemas)
        int[] rotas = gerarRotas(tamanhoRotas);

        // Chamar a função para distribuir as rotas entre os caminhões
        DistribuicaoRotasDivisaoConquista.distribuirRotas(rotas, numCaminhoes);
    }

    // Função para distribuir as rotas entre os caminhões
    public static void distribuirRotas(int[] rotas, int numCaminhoes) {
        Arrays.sort(rotas); // Ordena as rotas em ordem crescente
        int[] distribuicao = new int[numCaminhoes]; // Array para armazenar a quilometragem de cada caminhão
        Arrays.fill(distribuicao, 0); // Inicializa com 0

        // Chama a função auxiliar para distribuir as rotas
        distribuir(rotas, rotas.length - 1, distribuicao);

        // Imprime a distribuição de rotas
        for (int i = 0; i < numCaminhoes; i++) {
            System.out.println("Caminhão " + (i + 1) + ": total " + distribuicao[i] + "km");
        }
    }

    // Função auxiliar que distribui as rotas entre os caminhões usando divisão e
    // conquista
    private static void distribuir(int[] rotas, int index, int[] distribuicao) {
        if (index < 0)
            return;

        int minIndex = minIndex(distribuicao); // Obtém o índice do caminhão com a menor quilometragem

        // Atribui a rota atual ao caminhão com a menor quilometragem
        distribuicao[minIndex] += rotas[index];

        // Chama recursivamente para a próxima rota
        distribuir(rotas, index - 1, distribuicao);
    }

    // Função para obter o índice do caminhão com a menor quilometragem
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

    // Gera um array aleatorio para rotas aleatorias
    private static int[] gerarRotas(int tamanho) {
        Random random = new Random();
        int[] rotas = new int[tamanho];

        // Preencher o array de rotas com valores aleatórios entre 10 e 50 (apenas como
        // exemplo)
        for (int i = 0; i < tamanho; i++) {
            rotas[i] = random.nextInt(41) + 10; // Gera números entre 10 e 50
        }
        System.out.println("Rotas geradas:");
        for (int i = 0; i < rotas.length; i++) {
            System.out.print(rotas[i] + ", ");

        }
        System.out.println();
        return rotas;
    }
    // public static void main(String[] args) {
    // int[] rotas = { 35, 34, 33, 23, 21, 32, 35, 19, 26, 42 };
    // int numCaminhoes = 3;
    // distribuirRotas(rotas, numCaminhoes);
    // }
}
