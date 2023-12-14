package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    static boolean[][] gerarTabela(int[] rotas, int n, int sum) {
        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

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

    static List<List<Integer>> melhoresResultados(boolean[][] tabela, int[] rotas, int quantVeiculos, int sum) {
        List<List<Integer>> resultados = new ArrayList<>();

        int row = tabela.length - 1;
        int col = tabela[0].length - 1;

        for (int i = 0; i < quantVeiculos; i++) {
            resultados.add(new ArrayList<>());
        }

        int[] rotasRestantes = rotas.clone();

        for (int i = 0; i < quantVeiculos; i++) {
            while (row > 0 && col > 0) {
                if (tabela[row][col] == tabela[row][col - 1]) {
                    col--;
                } else if (tabela[row][col]) {
                    resultados.get(i).add(rotas[col - 1]);
                    row -= rotas[col - 1];
                    col--;
                    rotasRestantes = removeAtIndex(rotasRestantes, col - 1);
                } else {
                    col--;
                }
            }
            tabela = gerarTabela(rotasRestantes, col, sum);
            rotas = rotasRestantes;
        }

        return resultados;
    }

    private static int[] removeAtIndex(int[] arr, int index) {
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }
}
