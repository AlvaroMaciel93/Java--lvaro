package Q3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarArquivo {

    public static void main(String[] args) {
        String nomeArquivoOrigem = "origem.txt";
        String nomeArquivoDestino = "destino.txt";

        try {
            FileReader arquivoOrigem = new FileReader(nomeArquivoOrigem);
            BufferedReader leitor = new BufferedReader(arquivoOrigem);

            FileWriter arquivoDestino = new FileWriter(nomeArquivoDestino);
            BufferedWriter escritor = new BufferedWriter(arquivoDestino);

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }

            leitor.close();
            escritor.close();
            System.out.println("Conteúdo do arquivo '" + nomeArquivoOrigem + "' foi copiado para '" + nomeArquivoDestino + "'.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a cópia do arquivo: " + e.getMessage());
        }
    }
}
