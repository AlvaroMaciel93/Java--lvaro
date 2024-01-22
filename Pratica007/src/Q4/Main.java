package Q4;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Veiculo veiculo = new Veiculo("Modelo1", "ABC123", "30");
        veiculo.salvar();

        Motorista motorista = new Motorista("Motorista1", 30, "123456789");
        motorista.salvar();

        Cobrador cobrador = new Cobrador("Cobrador1", 28, "111222333");
        cobrador.salvar();

        Passageiro passageiro = new Passageiro("Passageiro1", 25, "987654321");
        passageiro.salvar();

        PontoDeParada pontoDeParada = new PontoDeParada(null);
        pontoDeParada.adicionarPontoDeParada();

        Trecho trecho = new Trecho(pontoDeParada, pontoDeParada, 0);
        trecho.calcularTempoEstimado();

        Trajeto trajeto = new Trajeto(null);
        trajeto.adicionarTrecho(trecho);

        Jornada jornada = new Jornada(trajeto, motorista, cobrador, veiculo, null, null);
        jornada.registrarInicioJornada();
        jornada.registrarFimJornada();

        Checkpoint checkpoint = new Checkpoint(pontoDeParada, null);
        checkpoint.registrarChegada();

        // Criar registro de embarque
        RegistroEmbarque registroEmbarque = new RegistroEmbarque(passageiro, null, null);
        registroEmbarque.registrarEmbarque();

        // Realizar algumas operações de atualização
        veiculo.setModelo("ModeloAtualizado");
        veiculo.atualizar();

        motorista.setIdade(31);
        motorista.atualizar();

        cobrador.setNome("CobradorAtualizado");
        cobrador.atualizar();

        passageiro.setNome("PassageiroAtualizado");
        passageiro.atualizar();
    }
}


