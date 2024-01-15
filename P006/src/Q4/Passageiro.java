package Q4;

import java.io.Serializable;
import java.util.ArrayList;

public class Passageiro extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public Passageiro(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }

    public void salvar() {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        passageiroDAO.salvarPassageiro(this);
    }

    public static ArrayList<Passageiro> carregarTodos() {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        return passageiroDAO.carregarPassageiros();
    }

    public void atualizar() {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        passageiroDAO.atualizarPassageiro(this);
    }

    public void excluir() {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        passageiroDAO.excluirPassageiro(this);
    }
}
