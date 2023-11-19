package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
    private List<int[]> rotas;
    private int numCaminhoes;
    private int menorDiferenca;
    private List<int[]> melhorDistribuicao;
    private int totalEmKm;

    public BackTracking(List<int[]> rotas, int numCaminhoes) {
        this.rotas = rotas;
        this.numCaminhoes = numCaminhoes;
        this.menorDiferenca = Integer.MAX_VALUE;
        this.melhorDistribuicao = new ArrayList<>();
    }

    public void distribuirRotas() {
        List<int[]> distribuicaoAtual = new ArrayList<>();
        distribuirRotasAux(0, new ArrayList<>(), distribuicaoAtual);
    }

    private void distribuirRotasAux(int caminhaoAtual, List<int[]> distribuicaoParcial, List<int[]> distribuicaoAtual) {
        if (caminhaoAtual == numCaminhoes) {
            int diferenca = calcularDiferencaQuilometragem(distribuicaoParcial);
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                melhorDistribuicao = new ArrayList<>(distribuicaoParcial);
            }
            return;
        }

        for (int[] rota : rotas) {
            if (!distribuicaoAtual.contains(rota)) {
                distribuicaoParcial.add(rota);
                distribuicaoAtual.add(rota);

                int diferencaAtual = calcularDiferencaQuilometragem(distribuicaoParcial);
                if (diferencaAtual < menorDiferenca) {
                    distribuirRotasAux(caminhaoAtual + 1, distribuicaoParcial, distribuicaoAtual);
                }

                distribuicaoParcial.remove(rota);
                distribuicaoAtual.remove(rota);
            }
        }
    }

    private int calcularDiferencaQuilometragem(List<int[]> distribuicao) {
        int[] quilometragens = new int[numCaminhoes];
        for (int i = 0; i < distribuicao.size(); i++) {
            int[] caminhoes = distribuicao.get(i);
            for (int rota : caminhoes) {
                quilometragens[i] += rota;
            }
        }

        int maxQuilometragem = Integer.MIN_VALUE;
        int minQuilometragem = Integer.MAX_VALUE;

        for (int quilometragem : quilometragens) {
            maxQuilometragem = Math.max(maxQuilometragem, quilometragem);
            minQuilometragem = Math.min(minQuilometragem, quilometragem);
        }

        return maxQuilometragem - minQuilometragem;
    }

    public List<int[]> getMelhorDistribuicao() {
        return melhorDistribuicao;
    }

    public int getTotalEmKm(int[] rotas) {
        int sum = 0;
        for (int element : rotas) {
            sum += element;
        }

        return sum;
    }
}

