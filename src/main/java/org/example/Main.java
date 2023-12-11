package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(10, 5, 0.5);
        BackTracking backTracking = new BackTracking(rotas, 3);
        backTracking.distribuirRotas();
        System.out.println("Melhor distribuição:");
        for (int i = 0; i < backTracking.getMelhorDistribuicao().size(); i++) {
            int[] caminhoes = backTracking.getMelhorDistribuicao().get(i);
            System.out.println("Caminhão " + (i + 1) + ": rotas " + Arrays.toString(caminhoes) + ". Total: "
                    + backTracking.getTotalEmKm(caminhoes));
        }

        // Chamada Divisao E Conquista

        DistribuicaoRotasDivisaoConquista.distribuirRotas();
    
    
        int numCaminhoes = 3;
        int tamanhoInicial = 6;
        int multiplicadorTamanho = 2; 

        
        long tempoLimite = 30000;

        for (int tamanhoConjunto = tamanhoInicial; ; tamanhoConjunto *= multiplicadorTamanho) {
            List<int[]> conjuntoDeRotas = GeradorDeProblemas.geracaoDeRotas(tamanhoConjunto, 10, 0.5);

            System.out.println("Tamanho do Conjunto: " + tamanhoConjunto);

            // Estratégia 1
            long startTimeEstrategia1 = System.currentTimeMillis();
            EstrategiaGulosa1.distribuirRotas(conjuntoDeRotas.toArray(new int[0][]), numCaminhoes);
            long endTimeEstrategia1 = System.currentTimeMillis();
            long tempoExecucaoEstrategia1 = endTimeEstrategia1 - startTimeEstrategia1;
            System.out.println("Tempo de Execução Estratégia 1: " + tempoExecucaoEstrategia1 + "ms");

            // Estratégia 2
            long startTimeEstrategia2 = System.currentTimeMillis();
            EstrategiaGulosa2.distribuirRotas(conjuntoDeRotas.toArray(new int[0][]), numCaminhoes);
            long endTimeEstrategia2 = System.currentTimeMillis();
            long tempoExecucaoEstrategia2 = endTimeEestrategia2 - startTimeEstrategia2;
            System.out.println("Tempo de Execução Estratégia 2: " + tempoExecucaoEstrategia2 + "ms");

            if (tempoExecucaoEstrategia1 > tempoLimite && tempoExecucaoEstrategia2 > tempoLimite) {
                break;
            }

            System.out.println();
        }
    
    
    
    }
}