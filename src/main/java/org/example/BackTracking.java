package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BackTracking {

    private static SubConjunto melhorDistribuicao = null;
    private static double melhorMediaGlobal = 0;

    public static void gerarCombinacoes(int[] conjunto) {
        int n = conjunto.length;
        boolean[] usado = new boolean[n];
        List<Integer> caminhao1 = new ArrayList<>();
        List<Integer> caminhao2 = new ArrayList<>();
        List<Integer> caminhao3 = new ArrayList<>();

        backtrack(conjunto, usado, caminhao1, caminhao2, caminhao3);

        System.out.println("Melhor distribuicao: " + melhorDistribuicao);
    }

    private static void backtrack(int[] conjunto, boolean[] usado, List<Integer> caminhao1, List<Integer> caminhao2, List<Integer> caminhao3) {
        if (caminhao1.size() + caminhao2.size() + caminhao3.size() == conjunto.length) {
            // Calcular médias
            double mediaCaminhao1 = calcularMedia(caminhao1);
            double mediaCaminhao2 = calcularMedia(caminhao2);
            double mediaCaminhao3 = calcularMedia(caminhao3);
            double mediaGlobal = obtermediaLocal(mediaCaminhao1, mediaCaminhao2, mediaCaminhao3);

            // Atualizar melhor distribuição
            if (mediaGlobal > melhorMediaGlobal) {
                melhorMediaGlobal = mediaGlobal;
                melhorDistribuicao = new SubConjunto(new ArrayList<>(caminhao1), new ArrayList<>(caminhao2), new ArrayList<>(caminhao3));
            }
            return;
        }

        for (int i = 0; i < conjunto.length; i++) {
            if (!usado[i]) {
                usado[i] = true;

                // Adicionar elemento ao caminhão com menor carga
                int somaCaminhao1 = somarElementos(caminhao1);
                int somaCaminhao2 = somarElementos(caminhao2);
                int somaCaminhao3 = somarElementos(caminhao3);

                if (somaCaminhao1 <= somaCaminhao2 && somaCaminhao1 <= somaCaminhao3) {
                    caminhao1.add(conjunto[i]);
                } else if (somaCaminhao2 <= somaCaminhao3) {
                    caminhao2.add(conjunto[i]);
                } else {
                    caminhao3.add(conjunto[i]);
                }

                backtrack(conjunto, usado, caminhao1, caminhao2, caminhao3);

                // Desfazer a escolha para explorar outras opções
                if (somaCaminhao1 <= somaCaminhao2 && somaCaminhao1 <= somaCaminhao3) {
                    caminhao1.remove(caminhao1.size() - 1);
                } else if (somaCaminhao2 <= somaCaminhao3) {
                    caminhao2.remove(caminhao2.size() - 1);
                } else {
                    caminhao3.remove(caminhao3.size() - 1);
                }

                usado[i] = false;
            }
        }
    }

    private static double calcularMedia(List<Integer> caminhao) {
        if (caminhao.isEmpty()) {
            return 0;
        }

        int soma = 0;
        for (int valor : caminhao) {
            soma += valor;
        }
        return (double) soma / caminhao.size();
    }

    private static double obtermediaLocal(double a, double b, double c) {
        if (a == 100) {
            return (c + b) / 2;
        } else if (b == 100) {
            return (a + c) / 2;
        } else if (c == 100) {
            return (a + b) / 2;
        }

        return (a + b + c) / 3;
    }

    private static int somarElementos(List<Integer> lista) {
        return lista.stream().mapToInt(Integer::intValue).sum();
    }
}