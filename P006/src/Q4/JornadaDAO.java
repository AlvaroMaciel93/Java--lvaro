package Q4;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JornadaDAO {
    private static final String FILENAME = "jornadas.txt";

    public void registrarInicioJornada(Jornada jornada) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(
                    jornada.getTrajeto().getOrigem().getNome() + "," +
                            jornada.getTrajeto().getDestino().getNome() + "," +
                            jornada.getMotorista().getNome() + "," +
                            (jornada.getCobrador() != null ? jornada.getCobrador().getNome() : "") + "," +
                            jornada.getVeiculo().getModelo() + "," +
                            jornada.getInicio() + ","
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarFimJornada(Jornada jornada) {
    	try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(
                    jornada.getTrajeto().getOrigem().getNome() + "," +
                            jornada.getTrajeto().getDestino().getNome() + "," +
                            jornada.getMotorista().getNome() + "," +
                            (jornada.getCobrador() != null ? jornada.getCobrador().getNome() : "") + "," +
                            jornada.getVeiculo().getModelo() + "," +
                            jornada.getInicio() + ","
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Jornada> carregarJornadas() {
        List<Jornada> jornadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                Trajeto trajeto = new Trajeto(new PontoDeParada(dados[0]), new PontoDeParada(dados[1]));
                Motorista motorista = new Motorista(dados[2], 0, line);
                Cobrador cobrador = dados[3].isEmpty() ? null : new Cobrador(dados[3], 0, line);
                Veiculo veiculo = new Veiculo(dados[4], line, line);
                LocalDateTime inicio = LocalDateTime.parse(dados[5]);
                LocalDateTime fim = LocalDateTime.parse(dados[6]);

                Jornada jornada = new Jornada(trajeto, motorista, cobrador, veiculo, inicio, fim);
                jornadas.add(jornada);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jornadas;
    }


    public void atualizarJornada(Jornada jornada) {
        List<Jornada> jornadas = carregarJornadas();
        for (int i = 0; i < jornadas.size(); i++) {
            Jornada jornadaExistente = jornadas.get(i);
            if (jornadaExistente.equals(jornada)) {
                jornadas.set(i, jornada); // Atualiza a jornada existente com os novos dados
                salvarJornadas(jornadas); // Salva a lista atualizada no arquivo
                return;
            }
        }
    }

    public void excluirJornada(Jornada jornada) {
        List<Jornada> jornadas = carregarJornadas();
        jornadas.remove(jornada); // Remove a jornada da lista
        salvarJornadas(jornadas); // Salva a lista atualizada no arquivo
    }

    // Método auxiliar para salvar a lista de jornadas no arquivo
    void salvarJornadas(List<Jornada> jornadas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Jornada j : jornadas) {
                writer.println(
                        j.getTrajeto().getOrigem().getNome() + "," +  // Exemplo, ajuste conforme a estrutura real
                                j.getTrajeto().getDestino().getNome() + "," +
                                j.getMotorista().getNome() + "," +
                                (j.getCobrador() != null ? j.getCobrador().getNome() : "") + "," +
                                j.getVeiculo().getModelo() + "," +
                                j.getInicio() + "," +
                                (j.getFim() != null ? j.getFim() : ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}