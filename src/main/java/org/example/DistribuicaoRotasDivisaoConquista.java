package org.example;

import java.util.*;

/**
 * Classe de distribuiçao e conquista. Gerado por valores aleatrios, ou por
 * valores pre definidos.
 * 
 */

import java.util.*;

class DistribuicaoRotasDivisaoConquista {

    /**
     * Chamada para distribuir rotas por divisao e conquista. Printa na tela o
     * resultado, e a soma total
     * 
     * @param array o vetor de rotas para serem distribuidos
     * @param n     o numero de veiculos para os quais serao distribuidos
     */
    public static void distribuiRotas(int[] array, int n) {
        if (n == 0) {
            return;
        }
        int[] subconjunto = encontrarSubconjunto(array, n);
        int somaTotal = 0;
        for (int num : array) {
            somaTotal += num;
        }
        System.out.println("Caminhao " + n + Arrays.toString(subconjunto) + " " + somaTotal);
        DistribuicaoRotasDivisaoConquista.distribuiRotas(removerValores(array, subconjunto), n - 1);

    }

    public static int[] encontrarSubconjunto(int[] array, int n) {
        int somaTotal = 0;
        for (int num : array) {
            somaTotal += num;
        }

        int tercoSomaTotal = somaTotal / n;

        int[] subconjunto = divisaoConquista(array, 0, array.length - 1, tercoSomaTotal);

        return subconjunto;
    }

    public static int[] divisaoConquista(int[] array, int inicio, int fim, int alvo) {
        if (inicio > fim) {
            return new int[0];
        }

        int meio = (inicio + fim) / 2;
        int[] subconjuntoEsquerda = encontrarSubconjunto(array, inicio, meio, alvo);
        int[] subconjuntoDireita = encontrarSubconjunto(array, meio + 1, fim, alvo);

        int somaEsquerda = calcularSoma(subconjuntoEsquerda);
        int somaDireita = calcularSoma(subconjuntoDireita);

        if (Math.abs(somaEsquerda - alvo) < Math.abs(somaDireita - alvo)) {
            return subconjuntoEsquerda;
        } else {
            return subconjuntoDireita;
        }
    }

    public static int[] encontrarSubconjunto(int[] array, int inicio, int fim, int alvo) {
        int[] subconjunto = new int[array.length];
        int idx = 0;
        for (int i = inicio; i <= fim; i++) {
            if (array[i] <= alvo) {
                subconjunto[idx++] = array[i];
                alvo -= array[i];
            }
        }
        return Arrays.copyOf(subconjunto, idx);
    }

    public static int calcularSoma(int[] array) {
        int soma = 0;
        for (int num : array) {
            soma += num;
        }
        return soma;
    }

    public static int[] removerValores(int[] array, int[] valores) {
        int[] novoArray = Arrays.copyOf(array, array.length);
        for (int valor : valores) {
            for (int i = 0; i < novoArray.length; i++) {
                if (novoArray[i] == valor) {
                    novoArray[i] = 0; // Marca o valor como zero para remoção posterior
                    break;
                }
            }
        }

        int countZeros = 0;
        for (int i = 0; i < novoArray.length; i++) {
            if (novoArray[i] == 0) {
                countZeros++;
            } else if (countZeros > 0) {
                novoArray[i - countZeros] = novoArray[i];
                novoArray[i] = 0;
            }
        }

        return Arrays.copyOf(novoArray, novoArray.length - countZeros);
    }
}
