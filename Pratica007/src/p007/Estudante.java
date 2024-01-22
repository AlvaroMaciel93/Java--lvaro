package p007;

public class Estudante {
    private String nome;
    private String cpf;
    private float cra;
    private int anoDeAdmissao;

    public Estudante(String nome, String cpf, float cra, int anoDeAdmissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cra = cra;
		this.anoDeAdmissao = anoDeAdmissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getCra() {
		return cra;
	}

	public void setCra(float cra) {
		this.cra = cra;
	}

	public int getAnoDeAdmissao() {
		return anoDeAdmissao;
	}

	public void setAnoDeAdmissao(int anoDeAdmissao) {
		this.anoDeAdmissao = anoDeAdmissao;
	}

	@Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nCRA: " + cra + "\nAno de Admissão: " + anoDeAdmissao;
    }
}
