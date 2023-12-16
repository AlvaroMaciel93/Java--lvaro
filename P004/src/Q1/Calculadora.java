package Q1;

import java.util.Scanner;

public class Calculadora {

    public static int somar(int a, int b) {
        return a + b;
    }

    public static float somar(float a, float b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {
        return a - b;
    }

    public static float subtrair(float a, float b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static float multiplicar(float a, float b) {
        return a * b;
    }

    public static double dividir(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
    }

    public static float dividir(float a, float b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        float num1 = scanner.nextFloat();

        System.out.print("Digite o segundo número: ");
        float num2 = scanner.nextFloat();

        int resultadoSomaInt = somar((int) num1, (int) num2);
        System.out.println("Soma (int): " + resultadoSomaInt);

        float resultadoSomaFloat = somar(num1, num2);
        System.out.println("Soma (float): " + resultadoSomaFloat);

        int resultadoSubtracaoInt = subtrair((int) num1, (int) num2);
        System.out.println("Subtração (int): " + resultadoSubtracaoInt);

        float resultadoSubtracaoFloat = subtrair(num1, num2);
        System.out.println("Subtração (float): " + resultadoSubtracaoFloat);

        int resultadoMultiplicacaoInt = multiplicar((int) num1, (int) num2);
        System.out.println("Multiplicação (int): " + resultadoMultiplicacaoInt);

        float resultadoMultiplicacaoFloat = multiplicar(num1, num2);
        System.out.println("Multiplicação (float): " + resultadoMultiplicacaoFloat);

        double resultadoDivisaoInt = dividir((int) num1, (int) num2);
        System.out.println("Divisão (int): " + resultadoDivisaoInt);

        float resultadoDivisaoFloat = dividir(num1, num2);
        System.out.println("Divisão (float): " + resultadoDivisaoFloat);

        scanner.close();
    }
}