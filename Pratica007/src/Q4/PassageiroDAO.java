package Q4;

import java.io.*;
import java.util.ArrayList;

public class PassageiroDAO {
    private static final String FILE_PATH = "passageiros.dat";

    public void salvarPassageiro(Passageiro passageiro) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            outputStream.writeObject(passageiro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Passageiro> carregarPassageiros() {
        ArrayList<Passageiro> passageiros = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Passageiro passageiro = (Passageiro) inputStream.readObject();
                passageiros.add(passageiro);
            }
        } catch (EOFException e) {
            // Chegou ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return passageiros;
    }

    public void atualizarPassageiro(Passageiro passageiro) {
        ArrayList<Passageiro> passageiros = carregarPassageiros();
        excluirTodosOsPassageiros();

        for (Passageiro p : passageiros) {
            if (p.getCPF().equals(passageiro.getCPF())) {
                p.setNome(passageiro.getNome());
                p.setIdade(passageiro.getIdade());
            }
            salvarPassageiro(p);
        }
    }

    public void excluirPassageiro(Passageiro passageiro) {
        ArrayList<Passageiro> passageiros = carregarPassageiros();
        excluirTodosOsPassageiros();

        for (Passageiro p : passageiros) {
            if (!p.getCPF().equals(passageiro.getCPF())) {
                salvarPassageiro(p);
            }
        }
    }

    private void excluirTodosOsPassageiros() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
