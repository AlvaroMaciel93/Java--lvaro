package p008;

import java.time.LocalDate;

public class Pagamento {
    private double valor;
    private LocalDate data;
    private Fatura fatura; // Adicionando um campo para a fatura associada ao pagamento

    public Pagamento(double valor, LocalDate data, Fatura fatura) {
        this.valor = valor;
        this.data = data;
        this.fatura = fatura;
    }

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

    
}
