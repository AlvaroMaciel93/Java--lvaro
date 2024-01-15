package Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrechoDAO {
    private static final String FILENAME = "trechos.txt";

    public void salvarTrecho(Trecho trecho) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(trecho.getOrigem().getNome() + "," + trecho.getDestino().getNome() + "," + trecho.getIntervaloDeMinutos());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Trecho> carregarTrechos() {
        List<Trecho> trechos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                PontoDeParada origem = new PontoDeParada(dados[0]);
                PontoDeParada destino = new PontoDeParada(dados[1]);
                int intervaloDeMinutos = Integer.parseInt(dados[2]);
                Trecho trecho = new Trecho(origem, destino, intervaloDeMinutos);
                trechos.add(trecho);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trechos;
    }

    public void atualizarTrecho(Trecho trechoAntigo, Trecho trechoNovo) {
        List<Trecho> trechos = carregarTrechos();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Trecho t : trechos) {
                if (t.equals(trechoAntigo)) {
                    writer.println(trechoNovo.getOrigem().getNome() + "," + trechoNovo.getDestino().getNome() + "," + trechoNovo.getIntervaloDeMinutos());
                } else {
                    writer.println(t.getOrigem().getNome() + "," + t.getDestino().getNome() + "," + t.getIntervaloDeMinutos());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirTrecho(Trecho trecho) {
        List<Trecho> trechos = carregarTrechos();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Trecho t : trechos) {
                if (!t.equals(trecho)) {
                    writer.println(t.getOrigem().getNome() + "," + t.getDestino().getNome() + "," + t.getIntervaloDeMinutos());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
