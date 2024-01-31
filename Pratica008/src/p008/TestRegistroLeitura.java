package p008;

import org.junit.Test;
import java.time.LocalDate;

public class TestRegistroLeitura {
    public void testRegistraLeituraAtualizaValoresCorretamente() {
        Cliente cliente = new Cliente("João", "123.456.789-01");
        Imovel imovel = new Imovel(cliente, "Rua A, 123");

        imovel.registraLeitura(100);  // Valor da leitura atual
        Fatura fatura = imovel.getUltimaFatura();

        assertEquals(0, imovel.getPenultimaLeitura(), 0);
        assertEquals(100, imovel.getUltimaLeitura(), 0);
        assertEquals(0, fatura.getPenultimaLeitura(), 0);
        assertEquals(100, fatura.getUltimaLeitura(), 0);
        assertEquals(LocalDate.now(), fatura.getDataEmissao());
        assertEquals(1000.0, fatura.getValorCalculado(), 0.001);
        assertFalse(fatura.isQuitada());
    }

	private void assertFalse(boolean quitada) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(double d, double valorCalculado, double e) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(LocalDate localDate, LocalDate localDate2) {
		// TODO Auto-generated method stub
		
	}
}
