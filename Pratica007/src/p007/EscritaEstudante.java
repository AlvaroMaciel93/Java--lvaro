package p007;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscritaEstudante {

    public static void escreverEstudantes(List<Estudante> estudantes, String nomeArquivo) {
        try {
            List<String> linhas = new ArrayList<>();
            for (Estudante estudante : estudantes) {
                linhas.add(estudante.toString());
            }
            Path arquivo = Paths.get(nomeArquivo);
            Files.write(arquivo, linhas);
            System.out.println("Dados dos estudantes foram gravados no arquivo " + nomeArquivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Estudante> listaEstudantes = new ArrayList<>();

        while (true) {
            System.out.println("Digite os dados do estudante (ou digite 'sair' para encerrar):");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("CRA: ");
            float cra = Float.parseFloat(scanner.nextLine());

            System.out.print("Ano de Admissão: ");
            int anoDeAdmissao = Integer.parseInt(scanner.nextLine());

            Estudante estudante = new Estudante(nome, cpf, cra, anoDeAdmissao);
            listaEstudantes.add(estudante);
        }

        escreverEstudantes(listaEstudantes, "estudantes.json");
    }
}
