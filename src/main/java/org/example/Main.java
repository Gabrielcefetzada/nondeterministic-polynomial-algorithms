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
        long startTime = 0;
        long endTime = 0;
        long executionTime =0;
        double mediaDeExecucoes = 0;

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
                    startTime = System.currentTimeMillis();

                    for (int[] array : rotasGeradas) {
                        BackTracking backTracking = new BackTracking();
                        backTracking.gerarCombinacoes(array);
                    }

                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    mediaDeExecucoes += executionTime;

                    break;
                case 2:
                    startTime = System.currentTimeMillis();

                    for (int[] array : rotasGeradas) {
                        EstrategiaGulosa1 estrategiaGulosa1 = new EstrategiaGulosa1();
                        estrategiaGulosa1.distribuirRotas(array, numCaminhoes);
                    }

                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    mediaDeExecucoes += executionTime;

                    break;
                case 3:
                    startTime = System.currentTimeMillis();

                    for (int[] array : rotasGeradas) {
                        EstrategiaGulosa2 guloso2 = new EstrategiaGulosa2();
                        guloso2.distribuiRotasParaCaminhoes(numCaminhoes, array);
                    }

                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    mediaDeExecucoes += executionTime;

                    break;
                case 4:
                    startTime = System.currentTimeMillis();

                    for (int[] array : rotasGeradas) {
                        DistribuicaoRotasDivisaoConquista.distribuiRotas(array, numCaminhoes);
                    }

                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    mediaDeExecucoes += executionTime;

                    break;
                case 5:
                    startTime = System.currentTimeMillis();

                    System.out.println("Algoritmo incompleto");

                    //PD.melhoresResultados(rotasGeradas, numCaminhoes, 0);

                    endTime = System.currentTimeMillis();
                    executionTime = endTime - startTime;
                    mediaDeExecucoes += executionTime;
                    break;

                case 6:
                    System.out.println("Saindo...");
                    continua = false;
                    break;

                default:
                    System.out.println("Esta não é uma opção válida!");
            }


            System.out.println("Media de execuções em ms: " + mediaDeExecucoes/tamanhoConjunto);
        }
    }
}