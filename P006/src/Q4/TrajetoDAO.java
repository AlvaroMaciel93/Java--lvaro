package Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrajetoDAO {
    private static final String FILENAME = "trajetos.txt";

    public void salvarTrajeto(Trajeto trajeto) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            for (Trecho trecho : trajeto.getTrechos()) {
                writer.println(trecho.getOrigem().getNome() + "," + trecho.getDestino().getNome() + "," + trecho.getIntervaloDeMinutos());
            }
            writer.println("---"); // Indicador de fim do trajeto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Trajeto> carregarTrajetos() {
        List<Trajeto> trajetos = new ArrayList<>();
        List<Trecho> trechos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    trajetos.add(new Trajeto(new ArrayList<>(trechos)));
                    trechos.clear();
                } else {
                    String[] dados = line.split(",");
                    PontoDeParada origem = new PontoDeParada(dados[0]);
                    PontoDeParada destino = new PontoDeParada(dados[1]);
                    int intervaloDeMinutos = Integer.parseInt(dados[2]);
                    Trecho trecho = new Trecho(origem, destino, intervaloDeMinutos);
                    trechos.add(trecho);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trajetos;
    }

    public void atualizarTrajeto(Trajeto trajetoAntigo, Trajeto trajetoNovo) {
        List<Trajeto> trajetos = carregarTrajetos();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Trajeto t : trajetos) {
                if (t.equals(trajetoAntigo)) {
                    for (Trecho trecho : trajetoNovo.getTrechos()) {
                        writer.println(trecho.getOrigem().getNome() + "," + trecho.getDestino().getNome() + "," + trecho.getIntervaloDeMinutos());
                    }
                    writer.println("---");
                } else {
                    for (Trecho trecho : t.getTrechos()) {
                        writer.println(trecho.getOrigem().getNome() + "," + trecho.getDestino().getNome() + "," + trecho.getIntervaloDeMinutos());
                    }
                    writer.println("---");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirTrajeto(Trajeto trajeto) {
        List<Trajeto> trajetos = carregarTrajetos();
        try (PrintWriter writer = new PrintWriter(FILENAME)) {
            for (Trajeto t : trajetos) {
                if (!t.equals(trajeto)) {
                    for (Trecho trecho : t.getTrechos()) {
                        writer.println(trecho.getOrigem().getNome() + "," + trecho.getDestino().getNome() + "," + trecho.getIntervaloDeMinutos());
                    }
                    writer.println("---");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
