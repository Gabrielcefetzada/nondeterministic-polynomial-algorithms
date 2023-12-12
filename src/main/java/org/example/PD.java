package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PD {
    //    “Uma empresa de distribuição e logística possui uma frota composta por N caminhões. Semanalmente,
    //    esta empresa organiza suas entregas em M rotas, as quais devem ser distribuídas entre os caminhões
    //    disponíveis. A empresa deseja fazer a distribuição de maneira que cada caminhão cumpra a mesma
    //    quilometragem, evitando assim que ao final do período existam caminhões ociosos enquanto outros
    //    ainda estão executando várias rotas. Se não for possível cumprir a mesma quilometragem, que a
    //    diferença entre a quilometragem dos caminhões seja a menor possível, diminuindo o problema.
    //    Por exemplo, suponha a existência de 3 caminhões e 10 rotas com as seguintes quilometragens: 35, 34,
    //            33, 23, 21, 32, 35, 19, 26, 42. Dentre as distribuições D1 e D2 abaixo, D1 seria considerada melhor.
    //    D1
    //    Caminhão 1: rotas 21, 32, 42 – total 95km
    //    Caminhão 2: rotas 35, 34, 26 – total 95km
    //    Caminhão 3: rotas 23, 19, 35, 33 – total 110km
    //            D2
    //    Caminhão 1: rotas 35, 33, 32, 42 – total 142km
    //    Caminhão 2: rotas 35, 19, 26 – total 80km
    //    Caminhão 3: rotas 23, 34, 21 – total 78km”
    // resolva o problema usando programacao dinamica

    static boolean[][] gerarTabela(int[] rotas, int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean[][] subset = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= rotas[j - 1])
                    subset[i][j]
                            = subset[i][j]
                            || subset[i - rotas[j - 1]][j - 1];
            }
        }

        return subset;
    }

    static List<List<Integer>> melhoresResultados(boolean[][] tabela, int[] rotas, int quantVeiculos) {
        List<List<Integer>> resultados = new ArrayList<>();
        int index = 0;
        for (int i = tabela.length - 1; i > 0; i--) {
            resultados.add(new ArrayList<>());
            for (int j = tabela[0].length - 1; j > 0; j--) {
                if (!tabela[i][j]) continue;

                if (resultados.get(index).size() < quantVeiculos) {
                    resultados.get(index).add(rotas[j - 1]);
                } else {
                    index++;
                    resultados.add(new ArrayList<>());
                    resultados.get(index).add(rotas[j - 1]);
                }
            }
        }

        return resultados;
    }
}
