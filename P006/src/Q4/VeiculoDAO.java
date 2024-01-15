package Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private static final String FILENAME = "veiculos.dat";

    public void salvarVeiculo(Veiculo veiculo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME, true))) {
            outputStream.writeObject(veiculo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> carregarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            while (true) {
                Veiculo veiculo = (Veiculo) inputStream.readObject();
                veiculos.add(veiculo);
            }
        } catch (EOFException e) {
            // Chegou ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return veiculos;
    }

    public void atualizarVeiculo(Veiculo veiculoAntigo, Veiculo veiculoNovo) {
        List<Veiculo> veiculos = carregarVeiculos();
        excluirTodosOsVeiculos();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.equals(veiculoAntigo)) {
                veiculo = veiculoNovo;
            }
            salvarVeiculo(veiculo);
        }
    }

    public void excluirVeiculo(Veiculo veiculo) {
        List<Veiculo> veiculos = carregarVeiculos();
        excluirTodosOsVeiculos();

        for (Veiculo v : veiculos) {
            if (!v.equals(veiculo)) {
                salvarVeiculo(v);
            }
        }
    }

    private void excluirTodosOsVeiculos() {
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            // Limpa o conteúdo do arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void atualizarVeiculos(Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}
}

