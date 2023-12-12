package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arrayAula1 = { 40, 36, 38, 29, 32, 28, 31, 35, 31, 30, 32, 30, 29, 39, 35, 38, 39, 35, 32, 38, 32, 33, 29,
                33, 29, 39, 28 };
        int[] arrayAula2 = { 32, 51, 32, 43, 42, 30, 42, 51, 43, 51, 29, 25, 27, 32, 29, 55, 43, 29, 32, 44, 55, 29, 53,
                30, 24, 27 };
        int tamConjunto = 1;
        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(10, tamConjunto,
                0.5);

        double mediaDeExecucoes = 0;
        for (int[] array : rotasGeradas) {
            long startTime = System.currentTimeMillis();

            System.out.println(Arrays.toString(array));

            DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula1, 3);
            DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula2, 3);
            // DistribuicaoRotasDivisaoConquista.distribuiRotas(array, 3);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            mediaDeExecucoes += executionTime;
        }

        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
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

        // int numCaminhoes = 3;
        // int tamanhoInicial = 6;
        // int multiplicadorTamanho = 2;

        // long tempoLimite = 30000;

        // for (int tamanhoConjunto = tamanhoInicial;; tamanhoConjunto *=
        // multiplicadorTamanho) {
        // List<int[]> conjuntoDeRotas =
        // GeradorDeProblemas.geracaoDeRotas(tamanhoConjunto, 10, 0.5);

        // System.out.println("Tamanho do Conjunto: " + tamanhoConjunto);

        // // Estratégia 1
        // long startTimeEstrategia1 = System.currentTimeMillis();
        // EstrategiaGulosa1.distribuirRotas(conjuntoDeRotas.toArray(new int[0][]),
        // numCaminhoes);
        // long endTimeEstrategia1 = System.currentTimeMillis();
        // long tempoExecucaoEstrategia1 = endTimeEstrategia1 - startTimeEstrategia1;
        // System.out.println("Tempo de Execução Estratégia 1: " +
        // tempoExecucaoEstrategia1 + "ms");

        // // Estratégia 2
        // long startTimeEstrategia2 = System.currentTimeMillis();
        // EstrategiaGulosa2.distribuirRotas(conjuntoDeRotas.toArray(new int[0][]),
        // numCaminhoes);
        // long endTimeEstrategia2 = System.currentTimeMillis();
        // long tempoExecucaoEstrategia2 = endTimeEestrategia2 - startTimeEstrategia2;
        // System.out.println("Tempo de Execução Estratégia 2: " +
        // tempoExecucaoEstrategia2 + "ms");

        // if (tempoExecucaoEstrategia1 > tempoLimite && tempoExecucaoEstrategia2 >
        // tempoLimite) {
        // break;
        // }

        // System.out.println();
        // }

    }
}
