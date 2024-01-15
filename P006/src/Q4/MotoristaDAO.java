package Q4;

import java.io.*;
import java.util.ArrayList;

public class MotoristaDAO {
    private static final String FILE_PATH = "motoristas.dat";

    public void salvarMotorista(Motorista motorista) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            outputStream.writeObject(motorista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Motorista> carregarMotoristas() {
        ArrayList<Motorista> motoristas = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                Motorista motorista = (Motorista) inputStream.readObject();
                motoristas.add(motorista);
            }
        } catch (EOFException e) {
            // Chegou ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return motoristas;
    }

    public void atualizarMotorista(Motorista motorista) {
        ArrayList<Motorista> motoristas = carregarMotoristas();
        excluirTodosOsMotoristas();

        for (Motorista m : motoristas) {
            if (m.getCPF().equals(motorista.getCPF())) {
                m.setNome(motorista.getNome());
                m.setIdade(motorista.getIdade());
            }
            salvarMotorista(m);
        }
    }

    public void excluirMotorista(Motorista motorista) {
        ArrayList<Motorista> motoristas = carregarMotoristas();
        excluirTodosOsMotoristas();

        for (Motorista m : motoristas) {
            if (!m.getCPF().equals(motorista.getCPF())) {
                salvarMotorista(m);
            }
        }
    }

    private void excluirTodosOsMotoristas() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
