package Q4;

import java.time.LocalDateTime;
import java.util.List;

public class Checkpoint {
    private PontoDeParada ponto;
    private LocalDateTime horaChegada;

    public Checkpoint(PontoDeParada ponto, LocalDateTime horaChegada) {
        this.ponto = ponto;
        this.horaChegada = horaChegada;
    }

    public PontoDeParada getPonto() {
        return ponto;
    }

    public void setPonto(PontoDeParada ponto) {
        this.ponto = ponto;
    }

    public LocalDateTime getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(LocalDateTime horaChegada) {
        this.horaChegada = horaChegada;
    }

    public void registrarChegada() {
        CheckpointDAO checkpointDAO = new CheckpointDAO();
        checkpointDAO.registrarChegada(this);
    }

    public void salvar() {
        CheckpointDAO checkpointDAO = new CheckpointDAO();
        checkpointDAO.salvarCheckpoint(this);
    }

    public static List<Checkpoint> carregarTodos() {
        CheckpointDAO checkpointDAO = new CheckpointDAO();
        return checkpointDAO.carregarCheckpoints();
    }

    public void atualizar() {
        CheckpointDAO checkpointDAO = new CheckpointDAO();
        checkpointDAO.atualizarCheckpoint(this, this);
    }

    public void excluir() {
        CheckpointDAO checkpointDAO = new CheckpointDAO();
        checkpointDAO.excluirCheckpoint(this);
    }
}
