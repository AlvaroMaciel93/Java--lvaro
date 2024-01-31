package p008;

import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private Cliente cliente;
    private String endereco;
    private int penultimaLeitura;
    private int ultimaLeitura;
    private List<Fatura> faturas;
    private double saldoReembolso;

    public Imovel(Cliente cliente, String endereco) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.faturas = new ArrayList<>();
        this.penultimaLeitura = 0;
        this.ultimaLeitura = 0;
        this.saldoReembolso = 0.0;
    }

    public void registraLeitura(int leituraAtual) {
        penultimaLeitura = ultimaLeitura;
        ultimaLeitura = leituraAtual;

        Fatura fatura = new Fatura(penultimaLeitura, ultimaLeitura);
        faturas.add(fatura);
    }

    public Fatura getUltimaFatura() {
        return faturas.get(faturas.size() - 1);
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getPenultimaLeitura() {
		return penultimaLeitura;
	}

	public void setPenultimaLeitura(int penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	public void setUltimaLeitura(int ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}

	public List<Fatura> getFaturas() {
		return faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public double getSaldoReembolso() {
		return saldoReembolso;
	}

	public void setSaldoReembolso(double saldoReembolso) {
		this.saldoReembolso = saldoReembolso;
	}

	public void registraPagamento11(Fatura fatura, Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	public void registraPagamento(Fatura fatura, Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}

	public void registraPagamento1(Fatura fatura, Pagamento pagamento) {
		// TODO Auto-generated method stub
		
	}
}
