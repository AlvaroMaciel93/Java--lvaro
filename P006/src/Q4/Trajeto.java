package Q4;

import java.util.ArrayList;
import java.util.List;

public class Trajeto {
    private ArrayList<Trecho> trechos;

    public Trajeto(ArrayList<Trecho> trechos) {
        this.trechos = trechos;
    }

    public Trajeto(PontoDeParada pontoDeParada, PontoDeParada pontoDeParada2) {
	}

	public ArrayList<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(ArrayList<Trecho> trechos) {
        this.trechos = trechos;
    }

    public void adicionarTrecho(Trecho trecho) {
        trechos.add(trecho);
    }

    public void removerTrecho(Trecho trecho) {
        trechos.remove(trecho);
    }

    public void salvar() {
        TrajetoDAO trajetoDAO = new TrajetoDAO();
        trajetoDAO.salvarTrajeto(this);
    }

    public static List<Trajeto> carregarTodos() {
        TrajetoDAO trajetoDAO = new TrajetoDAO();
        return trajetoDAO.carregarTrajetos();
    }

    public void atualizar() {
        TrajetoDAO trajetoDAO = new TrajetoDAO();
        trajetoDAO.atualizarTrajeto(this, null);
    }

    public void excluir() {
        TrajetoDAO trajetoDAO = new TrajetoDAO();
        trajetoDAO.excluirTrajeto(this);
    }

	public Pessoa getOrigem() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa getDestino() {
		// TODO Auto-generated method stub
		return null;
	}
}
