package Q4;

import java.io.Serializable;

public class RegistroEmbarque implements Serializable {
    private static final long serialVersionUID = 1L;

    private Passageiro passageiro;
    private PontoDeParada pontoEmbarque;
    private String cartaoUtilizado;

    public RegistroEmbarque(Passageiro passageiro, Object pontoEmbarque2, String cartaoUtilizado) {
        this.passageiro = passageiro;
        this.pontoEmbarque = (PontoDeParada) pontoEmbarque2;
        this.cartaoUtilizado = cartaoUtilizado;
    }

    // Getters e Setters

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public PontoDeParada getPontoEmbarque() {
        return pontoEmbarque;
    }

    public void setPontoEmbarque(PontoDeParada pontoEmbarque) {
        this.pontoEmbarque = pontoEmbarque;
    }

    public String getCartaoUtilizado() {
        return cartaoUtilizado;
    }

    public void setCartaoUtilizado(String cartaoUtilizado) {
        this.cartaoUtilizado = cartaoUtilizado;
    }

    @Override
    public String toString() {
        return passageiro.toString() + "," + pontoEmbarque.toString() + "," + cartaoUtilizado;
    }

	public void registrarEmbarque() {
		// TODO Auto-generated method stub
		
	}
}
