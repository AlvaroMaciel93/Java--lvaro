package Q4;

import java.time.LocalDateTime;
import java.util.List;

public class Jornada {
    private Trajeto trajeto;
    private Motorista motorista;
    private Cobrador cobrador;
    private Veiculo veiculo;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Jornada(Trajeto trajeto, Motorista motorista, Cobrador cobrador, Veiculo veiculo, LocalDateTime inicio, LocalDateTime fim) {
        this.trajeto = trajeto;
        this.motorista = motorista;
        this.cobrador = cobrador;
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
    }
    
	public Trajeto getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(Trajeto trajeto) {
        this.trajeto = trajeto;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Cobrador getCobrador() {
        return cobrador;
    }

    public void setCobrador(Cobrador cobrador) {
        this.cobrador = cobrador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public void registrarInicioJornada() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.registrarInicioJornada(this);
    }

    public void registrarFimJornada() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.registrarFimJornada(this);
    }

    public void salvar() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.salvarJornadas(this);
    }

    public static List<Jornada> carregarTodos() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        return jornadaDAO.carregarJornadas();
    }

    public void atualizar() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.atualizarJornada(this);
    }

    public void excluir() {
        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaDAO.excluirJornada(this);
    }
}
