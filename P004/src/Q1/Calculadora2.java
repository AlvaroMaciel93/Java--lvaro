package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora2 {

    public static int somar(ArrayList<Integer> numeros) {
        int resultado = 0;
        for (int num : numeros) {
            resultado += num;
        }
        return resultado;
    }

    public static float somarFloat(ArrayList<Float> numeros) {
        float resultado = 0.0f;
        for (float num : numeros) {
            resultado += num;
        }
        return resultado;
    }

    public static int subtrair(ArrayList<Integer> numeros) {
        int resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }

    public static float subtrairFloat(ArrayList<Float> numeros) {
        float resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }

    public static int multiplicar(ArrayList<Integer> numeros) {
        int resultado = 1;
        for (int num : numeros) {
            resultado *= num;
        }
        return resultado;
    }

    public static float multiplicarFloat(ArrayList<Float> numeros) {
        float resultado = 1.0f;
        for (float num : numeros) {
            resultado *= num;
        }
        return resultado;
    }

    public static double dividir(ArrayList<Integer> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) != 0) {
                resultado /= numeros.get(i);
            } else {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }
        }
        return resultado;
    }

    public static float dividirFloat(ArrayList<Float> numeros) {
        float resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) != 0.0f) {
                resultado /= numeros.get(i);
            } else {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números na lista: ");
        int tamanhoLista = scanner.nextInt();

        ArrayList<Integer> listaInteiros = new ArrayList<>();
        ArrayList<Float> listaFloats = new ArrayList<>();

        System.out.println("Digite os números inteiros:");
        for (int i = 0; i < tamanhoLista; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            listaInteiros.add(scanner.nextInt());
        }

        System.out.println("Digite os números de ponto flutuante:");
        for (int i = 0; i < tamanhoLista; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            listaFloats.add(scanner.nextFloat());
        }

        int resultadoSomaInt = somar(listaInteiros);
        System.out.println("Soma (int): " + resultadoSomaInt);

        float resultadoSomaFloat = somarFloat(listaFloats);
        System.out.println("Soma (float): " + resultadoSomaFloat);

        int resultadoSubtracaoInt = subtrair(listaInteiros);
        System.out.println("Subtração (int): " + resultadoSubtracaoInt);

        float resultadoSubtracaoFloat = subtrairFloat(listaFloats);
        System.out.println("Subtração (float): " + resultadoSubtracaoFloat);

        int resultadoMultiplicacaoInt = multiplicar(listaInteiros);
        System.out.println("Multiplicação (int): " + resultadoMultiplicacaoInt);

        float resultadoMultiplicacaoFloat = multiplicarFloat(listaFloats);
        System.out.println("Multiplicação (float): " + resultadoMultiplicacaoFloat);

        double resultadoDivisaoInt = dividir(listaInteiros);
        System.out.println("Divisão (int): " + resultadoDivisaoInt);

        float resultadoDivisaoFloat = dividirFloat(listaFloats);
        System.out.println("Divisão (float): " + resultadoDivisaoFloat);

        scanner.close();
    }
}
