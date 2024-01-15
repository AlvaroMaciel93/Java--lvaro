package Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PontoDeParadaDAO {
    private static final String FILENAME = "pontos_de_parada.txt";

    public void salvarPontoDeParada(PontoDeParada pontoDeParada) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(pontoDeParada.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PontoDeParada> carregarPontosDeParada() {
        List<PontoDeParada> pontosDeParada = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PontoDeParada pontoDeParada = new PontoDeParada(line);
                pontosDeParada.add(pontoDeParada);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pontosDeParada;
    }

    public void atualizarPontoDeParada(PontoDeParada pontoDeParadaAntigo, PontoDeParada pontoDeParadaNovo) {
        List<PontoDeParada> pontosDeParada = carregarPontosDeParada();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (PontoDeParada p : pontosDeParada) {
                if (p.equals(pontoDeParadaAntigo)) {
                    writer.println(pontoDeParadaNovo.getNome());
                } else {
                    writer.println(p.getNome());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirPontoDeParada(PontoDeParada pontoDeParada) {
        List<PontoDeParada> pontosDeParada = carregarPontosDeParada();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (PontoDeParada p : pontosDeParada) {
                if (!p.equals(pontoDeParada)) {
                    writer.println(p.getNome());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
