package org.example;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tamConjunto = 1;
        int numCaminhoes = 3;
        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(11, tamConjunto,
                1);

        for (int[] array : rotasGeradas) {

            EstrategiaGulosa2 guloso2 = new EstrategiaGulosa2();
            guloso2.distribuiRotasParaCaminhoes(numCaminhoes, array);


        }
    }
}
