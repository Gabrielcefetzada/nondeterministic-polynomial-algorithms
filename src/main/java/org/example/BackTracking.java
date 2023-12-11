package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BackTracking {
    public static void gerarCombinacoes(int[] conjunto) {
        SubConjunto melhorDistribuicao = null;
        double melhorMediaGlobal = 0;

        int n = conjunto.length;
        HashSet<SubConjunto> subConjuntosGlobais = new HashSet<>();

        // Gera todas as combinações possíveis de 3 subconjuntos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) { // poda
                        ArrayList<ArrayList<Integer>> subconjuntos = new ArrayList<>();
                        subconjuntos.add(new ArrayList<>(Arrays.asList(conjunto[i], conjunto[j])));
                        subconjuntos.add(new ArrayList<>(Arrays.asList(conjunto[k])));

                        ArrayList<Integer> restantes = new ArrayList<>();
                        for (int l = 0; l < n; l++) {
                            if (l != i && l != j && l != k) {
                                restantes.add(conjunto[l]);
                            }
                        }

                        subconjuntos.add(new ArrayList<>(restantes));
                        SubConjunto novoSubConjuntoCandidato = new SubConjunto(subconjuntos.get(0), subconjuntos.get(1), subconjuntos.get(2));
                        subConjuntosGlobais.add(novoSubConjuntoCandidato);

                        double mediaCaminhao1 = novoSubConjuntoCandidato.calcularPorcentagem(novoSubConjuntoCandidato.totalcaminhao1);
                        double mediaCaminhao2 = novoSubConjuntoCandidato.calcularPorcentagem(novoSubConjuntoCandidato.totalcaminhao2);
                        double mediaCaminhao3 = novoSubConjuntoCandidato.calcularPorcentagem(novoSubConjuntoCandidato.totalcaminhao3);
                        double melhorMedialocal = obtermediaLocal(mediaCaminhao1, mediaCaminhao2, mediaCaminhao3);

                        if(melhorMedialocal > melhorMediaGlobal ) {
                            melhorMediaGlobal = melhorMedialocal;
                            melhorDistribuicao = novoSubConjuntoCandidato;
                        }
                    }
                }
            }
        }

        System.out.println("Melhor distribuicao: " + melhorDistribuicao);
    }

    public static double obtermediaLocal(double a, double b, double c) {
        // Se um dos números for 100, consideramos o próximo maior
        if (a == 100) {
            return (c + b) / 2;
        } else if (b == 100) {
            return (a + c) / 2;
        } else if (c == 100) {
            return (a + b) / 2;
        }

        return (a + b + c) / 3;
    }
}
