package app;

import model.*;

import java.io.Console;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static Usuario usuario = new Usuario("pery", "peryvieira", "123");
    static Cliente cliente = new Cliente("joao", "027633133123");

    static Filial filialCohama = new Filial("Cohama");
    static Filial filialCohab = new Filial("Cohab");
    static Filial filialCohatrac = new Filial("Cohatrac");

    static Estoque estoqueCohama = new Estoque(filialCohama);
    static Estoque estoqueCohab = new Estoque(filialCohab);
    static Estoque estoqueCohatrac = new Estoque(filialCohatrac);

    static Filial filialAtual = filialCohama;
    static Estoque estoqueAtual = estoqueCohama;

    public static void main(String[] args) throws IOException, Exception, InterruptedException {

        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        do {

            System.out.printf("\n\n ### FILIAL : %s ###", filialAtual.getNome_filial());
            System.out.println("\n =========================");
            System.out.println(" | 1 - Nova Venda |");
            System.out.println(" | 2 - Entrada Estoque |");
            System.out.println(" | 3 - Cadastro Produto |");
            System.out.println(" | 4 - Trocar Filial |");
            System.out.println(" | 0 - Sair |");
            System.out.println(" =========================\n");

            opcao = scan.nextInt();
            System.out.print("\n");

            switch (opcao) {
            case 1:
                novaVenda();
                break;
            case 2:
                entradaEstoque();
                break;
            case 3:
                cadastroProduto();
                break;
            case 4:
                trocarFilial();
                limpaTela();
                break;
            default:
                limpaTela();
                System.out.println("Opção Inválida!");
                scan.nextLine();

                break;
            }
        } while (opcao != 0);

    }

    public static void limpaTela() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    public static void novaVenda() throws IOException, InterruptedException {
        limpaTela();

    }

    public static void entradaEstoque() throws IOException, InterruptedException {
        limpaTela();

        String observacao = null;
        int opcao = 0;
        int quantidadeProduto = 0;
        Scanner scan = new Scanner(System.in);
        Produto produtoSelecionado = new Produto();
        String descricao = null;

        PedidoEstoque pedidoEntrada = new PedidoEstoque(1, estoqueAtual, usuario, cliente, "obs2", TipoPedido.ENTRADA);

        System.out.println("Informe uma observacao de entrega: ");
        observacao = scan.nextLine();

        do {
            System.out.println("Deseja inserir Produto? (1- SIM | 2 - NÃO) :");
            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                limpaTela();
                System.out.print("Informe descrição do produto : ");
                descricao = scan.nextLine();

                produtoSelecionado = estoqueAtual.buscarProdutoDescricao(descricao);

                if (produtoSelecionado.getDescricao() == null) {
                    System.out.println("\nProduto Não Encontrado\n");
                    System.out.println("Cadastrando Produto...\n");
                    System.out.print("Insira valor de custo: ");
                    double valor = scan.nextDouble();
                    System.out.print("\nInsira o valor de venda: ");
                    double valorVenda = scan.nextDouble();
                    System.out.print("\nInsira quantidade de produto para entrada: ");
                    int qnt = scan.nextInt();

                    Produto produto = new Produto(descricao, valor, valorVenda);

                    pedidoEntrada.adicionarItemPedido(produto, qnt);
                    scan.nextLine();
                } else {
                    System.out.print("\nInsira quantidade de produto para entrada: ");
                    int qnt = scan.nextInt();
                    pedidoEntrada.adicionarItemPedido(produtoSelecionado, qnt);
                    scan.nextLine();
                }

                scan.nextLine();
                limpaTela();
            } else {
                if (opcao == 2) {
                    pedidoEntrada.concluirPedido();
                    System.out.println("\n");
                    pedidoEntrada.listaItens();
                    scan.nextLine();
                    limpaTela();
                }
            }
        } while (opcao != 2);

    }

    public static void cadastroProduto() throws IOException, InterruptedException {
        limpaTela();

    }

    public static void trocarFilial() throws IOException, InterruptedException {
        limpaTela();
        Scanner scan = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("1 - Cohama\n2 - Cohab\n3 - Cohatrac");
            op = scan.nextInt();

            switch (op) {
            case 1:
                filialAtual = filialCohama;
                estoqueAtual = estoqueCohama;

                break;
            case 2:
                filialAtual = filialCohab;
                estoqueAtual = estoqueCohab;

                break;
            case 3:
                filialAtual = filialCohatrac;
                estoqueAtual = estoqueCohatrac;

                break;

            default:
                limpaTela();
                System.out.println("Opcao Invalida");
                break;
            }
        } while (op > 3 || op < 1);
    }

}
