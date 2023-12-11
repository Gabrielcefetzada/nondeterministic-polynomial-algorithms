package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // BACKTRACKING
        /*int tamConjunto = 10;
        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(11, tamConjunto, 0.5);

        double mediaDeExecucoes = 0;
        for (int[] array : rotasGeradas) {
            long startTime = System.currentTimeMillis();

            BackTracking backTracking = new BackTracking();
            backTracking.gerarCombinacoes(array);

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            mediaDeExecucoes += executionTime;
        }

        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
         */

        // DIVISAO E CONQUISTA
        /*int NumeroVeiculos = 3;
        List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(10, 5, 0.5);

        // Chamada Divisao E Conquista
        for (int[] arrayRotas : rotas) {
            System.out.println("");
            DistribuicaoRotasDivisaoConquista.distribuirRotas(arrayRotas, NumeroVeiculos);
        }

         */
    }
}
