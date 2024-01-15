package Q4;

import java.io.*;
import java.util.List;

public class PontoDeParada {
    private String nome;

    public PontoDeParada(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvar() {
        PontoDeParadaDAO pontoDeParadaDAO = new PontoDeParadaDAO();
        pontoDeParadaDAO.salvarPontoDeParada(this);
    }

    public static List<PontoDeParada> carregarTodos() {
        PontoDeParadaDAO pontoDeParadaDAO = new PontoDeParadaDAO();
        return pontoDeParadaDAO.carregarPontosDeParada();
    }

    public void atualizar() {
        PontoDeParadaDAO pontoDeParadaDAO = new PontoDeParadaDAO();
        pontoDeParadaDAO.atualizarPontoDeParada(this, null);
    }

    public void excluir() {
        PontoDeParadaDAO pontoDeParadaDAO = new PontoDeParadaDAO();
        pontoDeParadaDAO.excluirPontoDeParada(this);
    }

	public void adicionarPontoDeParada() {
		// TODO Auto-generated method stub
		
	}
}
