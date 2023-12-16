package Q2;

import java.util.ArrayList;
import java.util.Scanner;

class ItemPedido {
    String descricao;
    double preco;

    public ItemPedido(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
}

public class Pedido {
    int numeroPedido;
    String cpfCliente;
    ArrayList<ItemPedido> itens = new ArrayList<>();

    public Pedido(int numeroPedido, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.cpfCliente = cpfCliente;
    }

    public void adicionarItem(String descricao, double preco) {
        itens.add(new ItemPedido(descricao, preco));
    }

    // Sobrecarga: Adiciona uma lista de itens ao pedido
    public void adicionarItens(ArrayList<ItemPedido> itensAdicionais) {
        itens.addAll(itensAdicionais);
    }

    // Sobrecarga: Calcula o total do pedido com desconto à vista
    public double calcularTotal(double percentualDesconto) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        return total * (1 - percentualDesconto / 100);
    }

    // Sobrecarga: Calcula o total do pedido a prazo com juros
    public double calcularTotal(int numeroPrestacoes, double taxaJuros) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        return total * (1 + taxaJuros / 100) / numeroPrestacoes;
    }

    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println(" - " + item.descricao + ": R$" + item.preco);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedido com desconto à vista
        System.out.print("Digite o número do Pedido: ");
        int numeroPedidoDesconto = scanner.nextInt();

        System.out.print("Digite o CPF do Cliente: ");
        String cpfClienteDesconto = scanner.next();

        Pedido pedidoComDesconto = new Pedido(numeroPedidoDesconto, cpfClienteDesconto);

        System.out.println("Adicione itens ao Pedido com Desconto à Vista:");

        char adicionarMaisDesconto;
        do {
            System.out.print("Digite a descrição do item: ");
            String descricaoItem = scanner.next();

            System.out.print("Digite o preço do item: ");
            double precoItem = scanner.nextDouble();

            pedidoComDesconto.adicionarItem(descricaoItem, precoItem);

            System.out.print("Deseja adicionar mais itens? (S/N): ");
            adicionarMaisDesconto = scanner.next().charAt(0);
        } while (adicionarMaisDesconto == 'S' || adicionarMaisDesconto == 's');

        System.out.print("Digite o percentual de desconto à vista: ");
        double percentualDesconto = scanner.nextDouble();

        System.out.println("\nInformações do Pedido com Desconto à Vista:");
        pedidoComDesconto.exibirInformacoes();
        System.out.println("Total com " + percentualDesconto + "% de desconto à vista: R$" +
                pedidoComDesconto.calcularTotal(percentualDesconto));

        System.out.println();

        // Pedido a prazo com juros
        System.out.print("\nDigite o número do Pedido a Prazo: ");
        int numeroPedidoPrazo = scanner.nextInt();

        System.out.print("Digite o CPF do Cliente a Prazo: ");
        String cpfClientePrazo = scanner.next();

        Pedido pedidoAPrazo = new Pedido(numeroPedidoPrazo, cpfClientePrazo);

        System.out.println("Adicione itens ao Pedido a Prazo:");

        char adicionarMaisPrazo;
        do {
            System.out.print("Digite a descrição do item: ");
            String descricaoItem = scanner.next();

            System.out.print("Digite o preço do item: ");
            double precoItem = scanner.nextDouble();

            pedidoAPrazo.adicionarItem(descricaoItem, precoItem);

            System.out.print("Deseja adicionar mais itens? (S/N): ");
            adicionarMaisPrazo = scanner.next().charAt(0);
        } while (adicionarMaisPrazo == 'S' || adicionarMaisPrazo == 's');

        System.out.print("Digite o número de prestações a prazo: ");
        int numeroPrestacoes = scanner.nextInt();

        System.out.print("Digite a taxa de juros a prazo: ");
        double taxaJuros = scanner.nextDouble();

        System.out.println("\nInformações do Pedido a Prazo:");
        pedidoAPrazo.exibirInformacoes();
        System.out.println("Total a prazo em " + numeroPrestacoes + " vezes com " + taxaJuros +
                "% de juros: R$" + pedidoAPrazo.calcularTotal(numeroPrestacoes, taxaJuros));

        scanner.close();
    }
}
