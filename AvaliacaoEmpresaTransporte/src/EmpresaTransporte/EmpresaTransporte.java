package EmpresaTransporte;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EmpresaTransporte {
	public class Veiculo {
		private String modelo;
		private String placa;
		private String capacidade;
		
		/*possível método para Veiculo: iniciar percurso*/
		public void iniciarPercurso() {
	        
	    }
	}
	
	abstract class Pessoa {
	    private String nome;
	    private int idade;
	    private String CPF;

	    public Pessoa(String nome, int idade, String CPF) {
	        this.nome = nome;
	        this.idade = idade;
	        this.CPF = CPF;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getIdade() {
	        return idade;
	    }

	    public void setIdade(int idade) {
	        this.idade = idade;
	    }
	    
	    public String getCPF() {
	        return CPF;
	    }

	    public void setCPF(String CPF) {
	        this.CPF = CPF;
	    }
	    
	    public String detalhesPessoa() {
	        return "Nome: " + nome + ", Idade: " + idade + ", CPF: " + CPF;
	    }
	}
	public class Motorista extends Pessoa {
	    public Motorista(String nome, int idade, String CPF) {
	        super(nome, idade, CPF);
	    }
	    
	    /*possível método para Motorista: iniciar viagem*/
	    public void iniciarViagem() {
	        
	    }
	}

	public class Cobrador extends Pessoa {
	    public Cobrador(String nome, int idade, String CPF) {
	        super(nome, idade, CPF);
	    }
	    
	    /*possível método para Cobrador: cobrar tarifa*/
	    public void cobrarTarifa() {
	      
	    }
	}

	public class Passageiro extends Pessoa {
	    public Passageiro(String nome, int idade, String CPF) {
	        super(nome, idade, CPF);
	    }
	    
	    /*possível método para Passageiro: adquirir bilhete*/
	    public void adquirirBilhete() {
	        
	    }
	}

	public class PontoDeParada {
		private String NomeDoPonto;
		
		/*possível método para Ponto de Parada: adicionar ponto*/
		public void adicionarPontoDeParada() {
	 
	    }
		
		/*possível método para Ponto de Parada: remover ponto*/
	    public void removerPontoDeParada() {
	        
	    }
	}
	
	public class Trecho {
		private PontoDeParada origem;
		private PontoDeParada destino;
		private int IntervaloDeMinutos;
		
		/*possível método para calcular o tempo estimado para realização do percurso do trecho*/
		public int calcularTempoEstimado() {
			
	        return IntervaloDeMinutos; 
	    }
	}
	
	public class Trajeto {
		private ArrayList<Trecho> trechos;
		
		/*possível método para adição de trecho*/
		public void adicionarTrecho() {
	        
	    }
		
		/*possível método para remoção de trecho*/
	    public void removerTrecho() {
	        
	    }
	}
	
	public class Jornada {
	    private Trajeto trajeto;
	    private Motorista motorista;
	    private Cobrador cobrador;
	    private Veiculo veiculo;
	    private LocalDateTime inicio;
	    private LocalDateTime fim;
	    
	    /*possível método para registrar o início da jornada*/
	    public void registrarInicioJornada() {

	    }
	    
	    /*possível método para registrar o fim da jornada*/
	    public void registrarFimJornada() {

	    }
	}
	
	public class Checkpoint {
	    private PontoDeParada ponto;
	    private LocalDateTime horaChegada;
	    
	    /*possível método para registrar a chegada ao checkpoint*/
	    public void registrarChegada() {

	    }
	}
	
	public class RegistroEmbarque {
	    private Passageiro passageiro;
	    private PontoDeParada pontoEmbarque;
	    private String cartaoUtilizado;
	    
	    /*possível método para registrar o embarque de um passageiro em um ponto específico*/
	    public void registrarEmbarque() {

	    }
	}
}
