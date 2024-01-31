package p008;

import java.time.LocalDate;

public class Fatura {
    private int penultimaLeitura;
    private int ultimaLeitura;
    private LocalDate dataEmissao;
    private double valorCalculado;
    private boolean quitada;

    public Fatura(int penultimaLeitura, int ultimaLeitura) {
        this.penultimaLeitura = penultimaLeitura;
        this.ultimaLeitura = ultimaLeitura;
        this.dataEmissao = LocalDate.now();
        this.valorCalculado = calcularValor();
        this.quitada = false;
    }

    private double calcularValor() {
        // Lógica de cálculo do valor da fatura (R$ 10 por KWh, por exemplo)
        return 10 * (ultimaLeitura - penultimaLeitura);
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

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public void setQuitada(boolean quitada) {
		this.quitada = quitada;
	}
}
