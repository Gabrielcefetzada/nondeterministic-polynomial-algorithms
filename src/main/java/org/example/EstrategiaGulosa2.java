package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EstrategiaGulosa2 {
    private ArrayList<Integer> quantidadeDeRotasParaCadaCaminhao = new ArrayList<>();
    private Stack<Integer> pilhaDePrioridades;
    private int[] ordenarConjuntoDeRotas(int[] conjunto) {
        Arrays.sort(conjunto);
        return conjunto;
    }

    private ArrayList<Integer> defineQuantasRotasCadaCaminhaoVaiter(int numCaminhoes, int[] conjunto) {
        int tamConjunto = conjunto.length;

        int quantidadeParaCadaHomogeneo = tamConjunto / numCaminhoes;
        int restoASerDistribuido = tamConjunto % numCaminhoes;

        for(int i = 0; i < numCaminhoes; i++) {
            quantidadeDeRotasParaCadaCaminhao.add(quantidadeParaCadaHomogeneo);
        }

        for (int j = 0; j < restoASerDistribuido; j++) {
            quantidadeDeRotasParaCadaCaminhao.set(j, quantidadeDeRotasParaCadaCaminhao.get(j) + 1);
        }

        return quantidadeDeRotasParaCadaCaminhao;
    }

    public void distribuiRotasParaCaminhoes(int numCaminhoes, int[] conjunto) {
        int casasPercorridas = 0;
        ArrayList<Integer> conjuntoTransformadoEmArrayList = new ArrayList<>();

        for (int elemento : conjunto) {
            conjuntoTransformadoEmArrayList.add(elemento);
        }

        ArrayList<ArrayList<Integer>> matrizDeRotasParaCadacaminhao = new ArrayList<>();

        // Inicializa a matriz com ArrayLists vazios
        for (int i = 0; i < numCaminhoes; i++) {
            matrizDeRotasParaCadacaminhao.add(new ArrayList<>());
        }

        this.ordenarConjuntoDeRotas(conjunto);
        this.defineQuantasRotasCadaCaminhaoVaiter(numCaminhoes, conjunto);

        boolean devePreencherDeCimaParaBaixo = true;
        // DISTRIBUI ROTAS
        while (casasPercorridas < conjunto.length) {
            if (devePreencherDeCimaParaBaixo) {
                for (int i = 0; i < numCaminhoes; i++) {
                    if(casasPercorridas != conjunto.length) {
                        matrizDeRotasParaCadacaminhao.get(i).add(conjunto[casasPercorridas]);
                        casasPercorridas++;
                    }
                }
                devePreencherDeCimaParaBaixo = !devePreencherDeCimaParaBaixo;

            } else {
                for (int i = numCaminhoes - 1; i >= 0; i--) {
                    if(casasPercorridas != conjunto.length) {
                        matrizDeRotasParaCadacaminhao.get(i).add(conjunto[casasPercorridas]);
                        casasPercorridas++;
                    }
                }

                devePreencherDeCimaParaBaixo = !devePreencherDeCimaParaBaixo;
            }
        }

        imprimirMatriz(matrizDeRotasParaCadacaminhao);

    }

    public void imprimirMatriz(ArrayList<ArrayList<Integer>> matriz) {
        int numCaminhoes = matriz.size();

        for (int i = 0; i < numCaminhoes; i++) {
            System.out.print("Caminhao " + (i + 1) + ": ");
            System.out.print(matriz.get(i));

            int soma = 0;
            for (int elemento : matriz.get(i)) {
                soma += elemento;
            }

            System.out.println(" - " + soma + "km");
        }
    }

}