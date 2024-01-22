package p007;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeituraEstudante {

    public static List<String> lerEstudantes(String nomeArquivo) {
        try {
            Path arquivo = Paths.get(nomeArquivo);
            return Files.readAllLines(arquivo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        List<String> linhas = lerEstudantes("estudantes.txt");

        if (linhas != null) {
            System.out.println("Estudantes recuperados:");
            for (String linha : linhas) {
                System.out.println(linha);
            }
        }
    }
}
