package Q4;

import java.io.Serializable;
import java.util.ArrayList;

public class Motorista extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public Motorista(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }

    public void salvar() {
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        motoristaDAO.salvarMotorista(this);
    }

    public static ArrayList<Motorista> carregarTodos() {
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        return motoristaDAO.carregarMotoristas();
    }

    public void atualizar() {
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        motoristaDAO.atualizarMotorista(this);
    }

    public void excluir() {
        MotoristaDAO motoristaDAO = new MotoristaDAO();
        motoristaDAO.excluirMotorista(this);
    }
}
