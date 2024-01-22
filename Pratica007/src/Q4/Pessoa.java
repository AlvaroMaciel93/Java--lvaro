package Q4;

import java.io.Serializable;
import java.util.ArrayList;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public void salvar() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.salvarPessoa(this);
    }

    
    public static ArrayList<Pessoa> carregarTodos() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        return pessoaDAO.carregarPessoas();
    }

    public void atualizar() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.atualizarPessoa(this);
    }

    public void excluir() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.excluirPessoa(this);
    }
}
