package Q4;

import java.io.*;
import java.util.ArrayList;

public class CobradorDAO {
    private static final String FILE_PATH = "cobradores.dat";

    public void salvarCobrador(Cobrador cobrador) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            outputStream.writeObject(cobrador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cobrador> carregarCobradores() {
        ArrayList<Cobrador> cobradores = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Cobrador cobrador = (Cobrador) inputStream.readObject();
                cobradores.add(cobrador);
            }
        } catch (EOFException e) {
            // Chegou ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cobradores;
    }

    public void atualizarCobrador(Cobrador cobrador) {
        ArrayList<Cobrador> cobradores = carregarCobradores();
        excluirTodosOsCobradores();

        for (Cobrador c : cobradores) {
            if (c.getCPF().equals(cobrador.getCPF())) {
                c.setNome(cobrador.getNome());
                c.setIdade(cobrador.getIdade());
            }
            salvarCobrador(c);
        }
    }

    public void excluirCobrador(Cobrador cobrador) {
        ArrayList<Cobrador> cobradores = carregarCobradores();
        excluirTodosOsCobradores();

        for (Cobrador c : cobradores) {
            if (!c.getCPF().equals(cobrador.getCPF())) {
                salvarCobrador(c);
            }
        }
    }

    private void excluirTodosOsCobradores() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
