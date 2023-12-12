package org.example;

import java.util.Arrays;

public class teste {

    private static int[] juntarArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
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

    public static void main(String[] args) {
        int[] array = { 3, 5, 7, 2, 6, 4 };
        int target = 12;
        int margemErroUnidades = 2;

        int[] resultado = distribuir(array, target, margemErroUnidades);

        System.out.println("Array resultante:");
        System.out.println(Arrays.toString());
    }
}
