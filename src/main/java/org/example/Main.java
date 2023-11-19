package org.example;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(10, 5, 0.5);
        BackTracking backTracking = new BackTracking(rotas, 3);
        backTracking.distribuirRotas();
        System.out.println("Melhor distribuição:");
        for (int i = 0; i < backTracking.getMelhorDistribuicao().size(); i++) {
            int[] caminhoes = backTracking.getMelhorDistribuicao().get(i);
            System.out.println("Caminhão " + (i + 1) + ": rotas " + Arrays.toString(caminhoes) + ". Total: " + backTracking.getTotalEmKm(caminhoes));
        }
    }
}