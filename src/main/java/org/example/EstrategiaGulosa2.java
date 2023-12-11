import java.util.Arrays;

public class EstrategiaGulosa2 {
    public static void distribuirRotas(int[][] rotas, int numCaminhoes) {
        Arrays.sort(rotas, (a, b) -> Integer.compare(b[0], a[0]));

        int[] quilometragens = new int[numCaminhoes];

        for (int i = 0; i < rotas.length; i++) {
            int indiceCaminhao = encontrarMenorQuilometragem(quilometragens);
            quilometragens[indiceCaminhao] += rotas[i][0] * (i + 1); // Periculosidade aumenta com a ordem
            System.out.println("Caminhão " + (indiceCaminhao + 1) + ": rota " + rotas[i][0]);
        }
    }

    private static int encontrarMenorQuilometragem(int[] quilometragens) {
        int indiceMenor = 0;
        for (int i = 1; i < quilometragens.length; i++) {
            if (quilometragens[i] < quilometragens[indiceMenor]) {
                indiceMenor = i;
            }
        }
        return indiceMenor;
    }
}