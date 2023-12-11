package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //int[] conjunto1 = {1, 2, 3, 4, 5, 6};

       // BackTracking backTracking = new BackTracking();
       // backTracking.gerarCombinacoes(conjunto1);
        List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(10, 5, 0.5);

        // Chamada Divisao E Conquista

        DistribuicaoRotasDivisaoConquista.distribuirRotas();
    }
}



