package Q4;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckpointDAO {
    private static final String FILENAME = "checkpoints.txt";

    public void salvarCheckpoint(Checkpoint checkpoint) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(
                    checkpoint.getPonto().toString() + ","
                            + checkpoint.getHoraChegada());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarChegada(Checkpoint checkpoint) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(checkpoint.getPonto().toString() + "," + checkpoint.getHoraChegada());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCheckpoint(Checkpoint checkpointAntigo, Checkpoint checkpointNovo) {
        List<Checkpoint> checkpoints = carregarCheckpoints();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Checkpoint checkpoint : checkpoints) {
                if (checkpoint.equals(checkpointAntigo)) {
                    writer.println(checkpointNovo.getPonto().toString() + "," + checkpointNovo.getHoraChegada());
                } else {
                    writer.println(checkpoint.getPonto().toString() + "," + checkpoint.getHoraChegada());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirCheckpoint(Checkpoint checkpoint) {
        List<Checkpoint> checkpoints = carregarCheckpoints();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Checkpoint checkpointAtual : checkpoints) {
                if (!checkpointAtual.equals(checkpoint)) {
                    writer.println(checkpointAtual.getPonto().toString() + "," + checkpointAtual.getHoraChegada());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Checkpoint> carregarCheckpoints() {
        List<Checkpoint> checkpoints = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                PontoDeParada ponto = new PontoDeParada(dados[0]);
                LocalDateTime horaChegada = LocalDateTime.parse(dados[1]);
                Checkpoint checkpoint = new Checkpoint(ponto, horaChegada);
                checkpoints.add(checkpoint);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkpoints;
    }

}
