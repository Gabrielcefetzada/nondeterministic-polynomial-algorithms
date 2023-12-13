package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numCaminhoes, numRotas, tamanhoConjunto, opcao;
        double dispersao;
        boolean continua = true;

        System.out.println("Digite o número de caminhões");
        numCaminhoes = scanner.nextInt();

        System.out.println("Digite o número de rotas");
        numRotas = scanner.nextInt();

        System.out.println("Digite a dispersao");
        dispersao = scanner.nextDouble();

        System.out.println("Digite o tamanho do conjunto");
        tamanhoConjunto = scanner.nextInt();

        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(numRotas, tamanhoConjunto, dispersao);

        while (continua) {

            System.out.println();
            System.out.println("Escolha qual algoritmo deseja utilizar. Basta digitar o seu número");
            System.out.println("1 - Backtracking");
            System.out.println("2 - Algoritmo Guloso 1");
            System.out.println("3 - Algoritmo Guloso 2");
            System.out.println("4 - Divisão e conquista");
            System.out.println("5 - Programação Dinamica");
            System.out.println("6 - Sair");
            opcao = scanner.nextInt();


            switch (opcao) {
                case 1:

                    for (int[] array : rotasGeradas) {
                        BackTracking backTracking = new BackTracking();
                        backTracking.gerarCombinacoes(array);
                    }

                    break;
                case 2:

                    for (int[] array : rotasGeradas) {
                        EstrategiaGulosa1 estrategiaGulosa1 = new EstrategiaGulosa1();
                        estrategiaGulosa1.distribuirRotas(array, numCaminhoes);
                    }

                    break;
                case 3:

                    for (int[] array : rotasGeradas) {
                        EstrategiaGulosa2 guloso2 = new EstrategiaGulosa2();
                        guloso2.distribuiRotasParaCaminhoes(numCaminhoes, array);
                    }

                    break;
                case 4:

                    for (int[] array : rotasGeradas) {
                        DistribuicaoRotasDivisaoConquista.distribuiRotas(array, numCaminhoes);
                    }

                    break;
                case 5:
                    System.out.println("Método ainda nao implementado");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    continua = false;
                    break;

                default:
                    System.out.println("Esta não é uma opção válida!");
            }
        }
                // BACKTRACKING
        /*
         * int tamConjunto = 10;
         * List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(11, tamConjunto,
         * 0.5);
         *
         * double mediaDeExecucoes = 0;
         * for (int[] array : rotasGeradas) {
         * long startTime = System.currentTimeMillis();
         *
         * BackTracking backTracking = new BackTracking();
         * backTracking.gerarCombinacoes(array);
         *
         * long endTime = System.currentTimeMillis();
         * long executionTime = endTime - startTime;
         *
         * mediaDeExecucoes += executionTime;
         * }
         *
         * mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
         * System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
         */

        // DIVISAO E CONQUISTA
        /*
         * int NumeroVeiculos = 3;
         * List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(10, 5, 0.5);
         *
         * // Chamada Divisao E Conquista
         * for (int[] arrayRotas : rotas) {
         * System.out.println("");
         * DistribuicaoRotasDivisaoConquista.distribuirRotas(arrayRotas,
         * NumeroVeiculos);
         * }
         *
         */


        // GULOSO 1

        // GULOSO 2
    }
}
