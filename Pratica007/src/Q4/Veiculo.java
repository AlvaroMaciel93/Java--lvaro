package Q4;

import java.io.Serializable;
import java.util.ArrayList;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String modelo;
    private String placa;
    private String capacidade;

    public Veiculo(String modelo, String placa, String capacidade) {
        this.modelo = modelo;
        this.placa = placa;
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public void salvar() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.salvarVeiculo(this);
    }

    public static ArrayList<Veiculo> carregarTodos() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        return (ArrayList<Veiculo>) veiculoDAO.carregarVeiculos();
    }

    public void atualizar() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.atualizarVeiculos(this);
    }

    public void excluir() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.excluirVeiculo(this);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", capacidade='" + capacidade + '\'' +
                '}';
    }
}

