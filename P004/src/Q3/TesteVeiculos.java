package Q3;

class Veiculo {
    private String modelo;
    private String cor;
    private int ano;

    public Veiculo(String modelo, String cor, int ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("Veículo acelerando");
    }

    public void ligar() {
        System.out.println("Veículo ligado");
    }

    public void parar() {
        System.out.println("Veículo parado");
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }
}

class Carro extends Veiculo {
    private int portas;

    public Carro(String modelo, String cor, int ano, int portas) {
        super(modelo, cor, ano);
        this.portas = portas;
    }

    @Override
    public void ligar() {
        System.out.println("Carro ligado");
    }

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando");
    }

    @Override
    public void parar() {
        System.out.println("Carro parado");
    }

    public int getPortas() {
        return portas;
    }
}

class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String modelo, String cor, int ano, boolean partidaEletrica) {
        super(modelo, cor, ano);
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public void ligar() {
        System.out.println("Moto ligada");
    }

    @Override
    public void acelerar() {
        System.out.println("Moto acelerando");
    }

    @Override
    public void parar() {
        System.out.println("Moto parada");
    }

    public boolean hasPartidaEletrica() {
        return partidaEletrica;
    }
}

public class TesteVeiculos {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Civic", "Preto", 2022, 4);
        Moto minhaMoto = new Moto("CBR", "Vermelha", 2021, true);

        // Polimorfismo
        System.out.println("Informações do Carro:");
        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Cor: " + meuCarro.getCor());
        System.out.println("Ano: " + meuCarro.getAno());
        System.out.println("Portas: " + meuCarro.getPortas());

        meuCarro.ligar();
        meuCarro.acelerar();
        meuCarro.parar();

        System.out.println();

        System.out.println("Informações da Moto:");
        System.out.println("Modelo: " + minhaMoto.getModelo());
        System.out.println("Cor: " + minhaMoto.getCor());
        System.out.println("Ano: " + minhaMoto.getAno());
        System.out.println("Partida Elétrica: " + (minhaMoto.hasPartidaEletrica() ? "Sim" : "Não"));

        minhaMoto.ligar();
        minhaMoto.acelerar();
        minhaMoto.parar();
    }
}