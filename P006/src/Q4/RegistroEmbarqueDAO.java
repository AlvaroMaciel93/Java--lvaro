package Q4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroEmbarqueDAO {
    private static final String FILENAME = "registrosEmbarque.txt";
	private static final Object String = null;
	private static final Passageiro PontoDeParada = null;

    public void registrarEmbarque(RegistroEmbarque registroEmbarque) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            writer.println(registroEmbarque.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarRegistroEmbarque(RegistroEmbarque registroAntigo, RegistroEmbarque registroNovo) {
        List<RegistroEmbarque> registros = carregarRegistrosEmbarque();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (RegistroEmbarque registro : registros) {
                if (registro.equals(registroAntigo)) {
                    writer.println(registroNovo.toString());
                } else {
                    writer.println(registro.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirRegistroEmbarque(RegistroEmbarque registroEmbarque) {
        List<RegistroEmbarque> registros = carregarRegistrosEmbarque();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (RegistroEmbarque registroAtual : registros) {
                if (!registroAtual.equals(registroEmbarque)) {
                    writer.println(registroAtual.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RegistroEmbarque> carregarRegistrosEmbarque() {
        List<RegistroEmbarque> registrosEmbarque = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Separar os dados da linha e criar um novo registro de embarque
                String[] dados = line.split(",");
                Passageiro passageiro = new Passageiro(dados[0], Integer.parseInt(dados[1]), dados[2]);
                PontoDeParada pontoEmbarque = new PontoDeParada(dados[3]);
                String cartaoUtilizado = dados[4];

                RegistroEmbarque registroEmbarque = new RegistroEmbarque(passageiro, pontoEmbarque, cartaoUtilizado);
                registrosEmbarque.add(registroEmbarque);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registrosEmbarque;
    }
}
