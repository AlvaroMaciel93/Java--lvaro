package Q4;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private static final String FILENAME = "veiculos.json";

    public void salvarVeiculo(Veiculo veiculo) {
        try {
            List<Veiculo> veiculos = carregarVeiculos();
            veiculos.add(veiculo);
            salvarNoArquivo(veiculos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvarNoArquivo(List<Veiculo> veiculos) throws IOException {
        JSONArray veiculosArray = new JSONArray(null);

        // Carregar dados existentes, se houver algum
        if (Files.exists(Paths.get(FILENAME))) {
            String jsonData = new String(Files.readAllBytes(Paths.get(FILENAME)), StandardCharsets.UTF_8);
            if (!jsonData.isEmpty()) {
                veiculosArray = new JSONArray(jsonData);
            }
        }

        // Adicionar veículos
        for (Veiculo veiculo : veiculos) {
            JSONObject veiculoJson = new JSONObject();
            veiculoJson.put("modelo", veiculo.getModelo());
            veiculoJson.put("placa", veiculo.getPlaca());
            veiculoJson.put("capacidade", veiculo.getCapacidade());
            veiculosArray.put(veiculoJson);
        }

        // Escrever no arquivo
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            writer.print(veiculosArray.toString());
        }
    }

    public List<Veiculo> carregarVeiculos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME, StandardCharsets.UTF_8))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            return converterJsonParaLista(jsonContent.toString());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void atualizarVeiculo(Veiculo veiculoAntigo, Veiculo veiculoNovo) throws IOException {
        List<Veiculo> veiculos = carregarVeiculos();

        veiculos.remove(veiculoAntigo);
        veiculos.add(veiculoNovo);

        salvarNoArquivo(veiculos);
    }

    public void excluirVeiculo(Veiculo veiculo) throws IOException {
        List<Veiculo> veiculos = carregarVeiculos();
        veiculos.remove(veiculo);

        salvarNoArquivo(veiculos);
    }

    private String converterListaParaJson(List<Veiculo> veiculos) {
        JSONArray jsonArray = new JSONArray(null);
        for (Veiculo veiculo : veiculos) {
            JSONObject jsonVeiculo = new JSONObject();
            jsonVeiculo.put("modelo", veiculo.getModelo());
            jsonVeiculo.put("placa", veiculo.getPlaca());
            jsonVeiculo.put("capacidade", veiculo.getCapacidade());
            jsonArray.put(jsonVeiculo);
        }
        return jsonArray.toString(2);  // 2 para indentação
    }

    private List<Veiculo> converterJsonParaLista(String json) {
        List<Veiculo> veiculos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonVeiculo = jsonArray.getJSONObject(i);
            Veiculo veiculo = new Veiculo(
                    jsonVeiculo.getString("modelo"),
                    jsonVeiculo.getString("placa"),
                    jsonVeiculo.getString("capacidade")
            );
            veiculos.add(veiculo);
        }
        return veiculos;
    }
}
