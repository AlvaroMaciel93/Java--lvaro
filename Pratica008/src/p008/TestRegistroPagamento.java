package p008;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegistroPagamento {
    //@Test // Adicione esta anotação para indicar que este é um método de teste
    public void testRegistraPagamentoAtualizaFaturaCorretamente() {
        Cliente cliente = new Cliente("João", "123.456.789-01");
        Imovel imovel = new Imovel(cliente, "Rua A, 123");

        imovel.registraLeitura(100);
        Fatura fatura = imovel.getUltimaFatura();

        Pagamento pagamento = new Pagamento(50, java.time.LocalDate.now(), fatura);
        imovel.registraPagamento(fatura, pagamento);

        assertEquals(50, fatura.getValorCalculado(), 0.001);
        assertFalse(fatura.isQuitada());

        Pagamento segundoPagamento = new Pagamento(50, java.time.LocalDate.now(), fatura);
        imovel.registraPagamento(fatura, segundoPagamento);

        assertFalse(fatura.isQuitada());
        assertEquals(100, fatura.getValorCalculado(), 0.001);

        // Teste de reembolso
        Pagamento pagamentoExcedente = new Pagamento(120, java.time.LocalDate.now(), fatura);
        imovel.registraPagamento(fatura, pagamentoExcedente);

        assertEquals(20, imovel.getSaldoReembolso(), 0.001);
    }

	private void assertEquals(int i, double saldoReembolso, double d) {
		// TODO Auto-generated method stub
		
	}

	private void assertFalse(boolean quitada) {
		// TODO Auto-generated method stub
		
	}
}
