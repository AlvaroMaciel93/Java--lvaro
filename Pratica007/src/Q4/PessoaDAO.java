package Q4;

import java.io.*;
import java.util.ArrayList;

public class PessoaDAO {
    private static final String FILE_PATH = "pessoas.dat";

    public void salvarPessoa(Pessoa pessoa) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            outputStream.writeObject(pessoa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pessoa> carregarPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Pessoa pessoa = (Pessoa) inputStream.readObject();
                pessoas.add(pessoa);
            }
        } catch (EOFException e) {
            // Chegou ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public void atualizarPessoa(Pessoa pessoa) {
        ArrayList<Pessoa> pessoas = carregarPessoas();
        excluirTodasAsPessoas();

        for (Pessoa p : pessoas) {
            if (p.getCPF().equals(pessoa.getCPF())) {
                p.setNome(pessoa.getNome());
                p.setIdade(pessoa.getIdade());
            }
            salvarPessoa(p);
        }
    }

    public void excluirPessoa(Pessoa pessoa) {
        ArrayList<Pessoa> pessoas = carregarPessoas();
        excluirTodasAsPessoas();

        for (Pessoa p : pessoas) {
            if (!p.getCPF().equals(pessoa.getCPF())) {
                salvarPessoa(p);
            }
        }
    }

    private void excluirTodasAsPessoas() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

