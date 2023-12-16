package Q4;

import java.util.ArrayList;

class Veiculo {
    private String modelo;
    private String cor;
    private int ano;
    private boolean eletrico;

    public Veiculo(String modelo, String cor, int ano, boolean eletrico) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.eletrico = eletrico;
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

    public void estacionar(Garagem garagem) {
        garagem.adicionarVeiculo(this);
        System.out.print("Veículo estacionado");
        if (garagem.temTomadaEletrica() && eletrico) {
            System.out.println(" e carregando");
        } else {
            System.out.println();
        }
    }

    public boolean isEletrico() {
        return eletrico;
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

    public Carro(String modelo, String cor, int ano, boolean eletrico, int portas) {
        super(modelo, cor, ano, eletrico);
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

    public Moto(String modelo, String cor, int ano, boolean eletrico, boolean partidaEletrica) {
        super(modelo, cor, ano, eletrico);
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

class Garagem {
    private ArrayList<Veiculo> veiculos;
    private boolean temTomadaEletrica;

    public Garagem(boolean temTomadaEletrica) {
        this.veiculos = new ArrayList<>();
        this.temTomadaEletrica = temTomadaEletrica;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public boolean temTomadaEletrica() {
        return temTomadaEletrica;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
}

public class TesteVeiculos {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Civic", "Preto", 2022, false, 4);
        Moto minhaMoto = new Moto("CBR", "Vermelha", 2021, true, true);

        Garagem minhaGaragem = new Garagem(true);
        Garagem garagemSemTomada = new Garagem(false);

        meuCarro.estacionar(minhaGaragem);
        minhaMoto.estacionar(garagemSemTomada);

        minhaGaragem.adicionarVeiculo(meuCarro);
        minhaGaragem.adicionarVeiculo(minhaMoto);

        System.out.println("\nVeículos na minha garagem:");
        for (Veiculo veiculo : minhaGaragem.getVeiculos()) {
            System.out.println(" - " + veiculo.getModelo());
        }

        minhaGaragem.removerVeiculo(meuCarro);

        System.out.println("\nVeículos restantes na minha garagem:");
        for (Veiculo veiculo : minhaGaragem.getVeiculos()) {
            System.out.println(" - " + veiculo.getModelo());
        }
    }
}