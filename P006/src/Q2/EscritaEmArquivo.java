package Q2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscritaEmArquivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "saida.txt";

        try {
            FileWriter arquivo = new FileWriter(nomeArquivo);
            BufferedWriter escritor = new BufferedWriter(arquivo);

            System.out.println("Digite as linhas de texto (digite 'sair' para finalizar):");

            String linha;
            while (!(linha = scanner.nextLine()).equalsIgnoreCase("sair")) {
                escritor.write(linha);
                escritor.newLine();
            }

            escritor.close();
            System.out.println("As linhas foram gravadas no arquivo '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
