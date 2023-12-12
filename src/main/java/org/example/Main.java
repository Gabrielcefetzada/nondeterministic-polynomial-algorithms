package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // definindo o array da aula


<<<<<<< HEAD
        System.out.println("Executando pelo metodo divisao e conquista");
        double mediaDeExecucoes = 0;
        long startTime = System.currentTimeMillis();

        DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula1, 3);
        DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula2, 3);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        mediaDeExecucoes += executionTime;
        // Executando backtracing
        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
        System.out.println("");
        System.out.println("Executando pelo metodo de backtracking");
        mediaDeExecucoes = 0;
        startTime = System.currentTimeMillis();
        BackTracking.gerarCombinacoes(arrayAula1);
        BackTracking.gerarCombinacoes(arrayAula2);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
        System.out.println("");

        // Executando guloso
        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
        System.out.println("");
        System.out.println("Executando pelo metodo de backtracking");
        mediaDeExecucoes = 0;
        startTime = System.currentTimeMillis();
        Guloso.distribuirRotas(arrayAula1, 3);
        Guloso.distribuirRotas(arrayAula2, 3);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        mediaDeExecucoes = mediaDeExecucoes / tamConjunto;
        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
        System.out.println("");

=======
>>>>>>> cd21df1ad797653c630b73b2a590db9ab465765e
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

        int tamConjunto = 1;
        int numCaminhoes = 3;
        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(50, tamConjunto,
                1);

        for (int[] array : rotasGeradas) {

            EstrategiaGulosa2 guloso2 = new EstrategiaGulosa2();
            guloso2.distribuiRotasParaCaminhoes(numCaminhoes, array);


        }




    }
}
