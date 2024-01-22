package Q4;

import java.io.*;
import java.util.List;

public class Trecho {
    private PontoDeParada origem;
    private PontoDeParada destino;
    private int intervaloDeMinutos;

    public Trecho(PontoDeParada origem, PontoDeParada destino, int intervaloDeMinutos) {
        this.origem = origem;
        this.destino = destino;
        this.intervaloDeMinutos = intervaloDeMinutos;
    }

    public PontoDeParada getOrigem() {
        return origem;
    }

    public void setOrigem(PontoDeParada origem) {
        this.origem = origem;
    }

    public PontoDeParada getDestino() {
        return destino;
    }

    public void setDestino(PontoDeParada destino) {
        this.destino = destino;
    }

    public int getIntervaloDeMinutos() {
        return intervaloDeMinutos;
    }

    public void setIntervaloDeMinutos(int intervaloDeMinutos) {
        this.intervaloDeMinutos = intervaloDeMinutos;
    }

    public void salvar() {
        TrechoDAO trechoDAO = new TrechoDAO();
        trechoDAO.salvarTrecho(this);
    }

    public static List<Trecho> carregarTodos() {
        TrechoDAO trechoDAO = new TrechoDAO();
        return trechoDAO.carregarTrechos();
    }

    public void atualizar() {
        TrechoDAO trechoDAO = new TrechoDAO();
        trechoDAO.atualizarTrecho(this, null);
    }

    public void excluir() {
        TrechoDAO trechoDAO = new TrechoDAO();
        trechoDAO.excluirTrecho(this);
    }

	public void calcularTempoEstimado() {
		// TODO Auto-generated method stub
		
	}
}
