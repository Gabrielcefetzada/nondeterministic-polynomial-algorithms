package org.example;

import java.util.*;

/**
 * Classe de distribuiçao e conquista. Gerado por valores aleatrios, ou por
 * valores pre definidos.
 * 
 */

import java.util.*;

class DistribuicaoRotasDivisaoConquista {
    public static void main(String[] args) {

        int[] arrayAula1 = { 40, 36, 38, 29, 32, 28, 31, 35, 31, 30, 32, 30, 29, 39, 35, 38, 39, 35, 32, 38, 32, 33, 29,
                33, 29, 39, 28 };
        int[] arrayAula2 = { 32, 51, 32, 43, 42, 30, 42, 51, 43, 51, 29, 25, 27, 32, 29, 55, 43, 29, 32, 44, 55, 29, 53,
                30, 24, 27 };
        double mediaDeExecucoes = 0;
        long startTime = System.currentTimeMillis();

        DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula1, 3);
        DistribuicaoRotasDivisaoConquista.distribuiRotas(arrayAula2, 3);
        // DistribuicaoRotasDivisaoConquista.distribuiRotas(array, 3);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        mediaDeExecucoes += executionTime;

        System.out.println("Media de execuções em ms: " + mediaDeExecucoes);
    }

    public static void distribuiRotas(int[] array, int numCaminhoes) {
        if (numCaminhoes == 1) {
            System.out.println("Caminhao " + numCaminhoes + " " +
                    Arrays.toString(array));
            return;
        }

        int soma = Arrays.stream(array).sum();
        // int[] aux = distribuir(array, soma / numCaminhoes, 10);
        int[] aux = Arrays.stream(distribuir(array, soma / numCaminhoes, 10))
                .filter(num -> num != 0)
                .toArray();
        System.out.println("Caminhao " + numCaminhoes + " " + Arrays.toString(aux));

        distribuiRotas(removerElementos(array, aux), numCaminhoes - 1);
    }

    public static int[] distribuir(int array[], int target, int margemErroUnidades) {
        int somaArrayInicial = Arrays.stream(array).sum();

        if (somaArrayInicial > target - margemErroUnidades && somaArrayInicial < target + margemErroUnidades) {
            return array;
        }
        if (array.length <= 2) {
            Arrays.sort(array);
            return array;
        }

        int[] array1 = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] array2 = Arrays.copyOfRange(array, array.length / 2, array.length);

        int somaArray1 = Arrays.stream(array1).sum();
        int somaArray2 = Arrays.stream(array2).sum();

        if (somaArray1 + somaArray2 > target + margemErroUnidades) {
            while (somaArray1 + somaArray2 > target + margemErroUnidades) {
                if (somaArray1 > somaArray2) {
                    if (array1.length == 1)
                        break; // Evitar tentativa de remoção de um único elemento
                    int lastElement = array1[array1.length - 1];
                    array1 = Arrays.copyOf(array1, array1.length - 1);
                    array2 = Arrays.copyOf(array2, array2.length + 1);
                    array2[0] = lastElement;
                } else {
                    if (array2.length == 1)
                        break; // Evitar tentativa de remoção de um único elemento
                    int firstElement = array2[0];
                    array2 = Arrays.copyOfRange(array2, 1, array2.length);
                    array1 = Arrays.copyOf(array1, array1.length + 1);
                    array1[array1.length - 1] = firstElement;
                }
                somaArray1 = Arrays.stream(array1).sum();
                somaArray2 = Arrays.stream(array2).sum();
            }
        }

        distribuir(array1, target, margemErroUnidades);
        distribuir(array2, target, margemErroUnidades);

        return juntarArrays(array1, array2);
    }

    private static int[] juntarArrays(int[] primeiroArray, int[] segundoArray) {
        int tamanhoTotal = primeiroArray.length + segundoArray.length;
        int[] arrayJunto = new int[tamanhoTotal];

        // Copiando os elementos do primeiroArray para o arrayJunto
        System.arraycopy(primeiroArray, 0, arrayJunto, 0, primeiroArray.length);

        // Copiando os elementos do segundoArray para o arrayJunto
        System.arraycopy(segundoArray, 0, arrayJunto, primeiroArray.length, segundoArray.length);

        return arrayJunto;
    }

    /**
     * Remove os elementos presentes em arr2 do arr1
     * 
     * @param arr1 conjunto o qual vai ser removido os itens
     * @param arr2 conjunto o qual vai ser usado de paramentro para remover os itens
     * @return o array resultante
     * 
     */
    public static int[] removerElementos(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr2) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (int num : arr1) {
            if (counts.containsKey(num) && counts.get(num) > 0) {
                counts.put(num, counts.get(num) - 1);
            } else {
                result.add(num);
            }
        }

        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}
