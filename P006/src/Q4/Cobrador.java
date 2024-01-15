package Q4;

import java.io.Serializable;
import java.util.ArrayList;

public class Cobrador extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cobrador(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }

    public void salvar() {
        CobradorDAO cobradorDAO = new CobradorDAO();
        cobradorDAO.salvarCobrador(this);
    }

    public static ArrayList<Cobrador> carregarTodos() {
        CobradorDAO cobradorDAO = new CobradorDAO();
        return cobradorDAO.carregarCobradores();
    }

    public void atualizar() {
        CobradorDAO cobradorDAO = new CobradorDAO();
        cobradorDAO.atualizarCobrador(this);
    }

    public void excluir() {
        CobradorDAO cobradorDAO = new CobradorDAO();
        cobradorDAO.excluirCobrador(this);
    }
}
