package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class SubConjunto {
    public ArrayList<Integer> caminhao1;
    public ArrayList<Integer> caminhao2;
    public ArrayList<Integer> caminhao3;
    public int totalcaminhao1;
    public int totalcaminhao2;
    public int totalcaminhao3;

    // Construtor
    public SubConjunto(ArrayList<Integer> caminhao1, ArrayList<Integer> caminhao2, ArrayList<Integer> caminhao3) {
        this.caminhao1 = caminhao1;
        this.caminhao2 = caminhao2;
        this.caminhao3 = caminhao3;

        this.totalcaminhao1 = caminhao1.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);
        this.totalcaminhao2 = caminhao2.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);
        this.totalcaminhao3 = caminhao3.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SubConjunto outroSubConjunto = (SubConjunto) obj;
        return new HashSet<>(caminhao1).equals(new HashSet<>(outroSubConjunto.caminhao1)) &&
                new HashSet<>(caminhao2).equals(new HashSet<>(outroSubConjunto.caminhao2)) &&
                new HashSet<>(caminhao3).equals(new HashSet<>(outroSubConjunto.caminhao3));
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(caminhao1), new HashSet<>(caminhao2), new HashSet<>(caminhao3));
    }

    @Override
    public String toString() {
        return "Caminhao1: " + caminhao1 +
                "\nCaminhao2: " + caminhao2 +
                "\nCaminhao3: " + caminhao3 + "\n";
    }

    public int calcularTotal() {
        this.totalcaminhao1 = caminhao1.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);
        this.totalcaminhao2 = caminhao2.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);
        this.totalcaminhao3 = caminhao3.stream().reduce(0, (subtotal, elemento) -> subtotal + elemento);

        return Math.max(totalcaminhao1, Math.max(totalcaminhao2, totalcaminhao3));
    }


    public double calcularPorcentagem(int total) {
        return (double) total / calcularTotal() * 100;
    }
}
