
package model;

import model.TipoPedido;
import model.StatusPedido;
import model.FormaPagamento;
import model.ItemPedido;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author peryv
 */
public class PedidoEstoque {
    private int id;
    private Estoque estoque;
    private Usuario usuario;
    private Cliente cliente;
    private String observacao_pedido;
    private TipoPedido tipoPedido;
    private List<ItemPedido> itemPedidoLista = new ArrayList<ItemPedido>();
    private FormaPagamento formaPagamento;

    public PedidoEstoque() {

    }

    public PedidoEstoque(Estoque estoque, Usuario usuario, Cliente cliente, TipoPedido tipoPedido) {
        this.estoque = estoque;
        this.usuario = usuario;
        this.cliente = cliente;

        this.tipoPedido = tipoPedido;

    }
    // #region Getters / Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacao_pedido() {
        return observacao_pedido;
    }

    public void setObservacao_pedido(String observacao_pedido) {
        this.observacao_pedido = observacao_pedido;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }

    // #endregion

    public void adicionarItemPedido(Produto produto, int quantidade) {

        if (tipoPedido == TipoPedido.SAIDA) {
            int quantidadeEstoque = this.estoque.getQnt_estoque(produto);
            int quantidadePedido = verificaQuantidadePedidoAtual(produto);

            if (quantidadeEstoque < quantidadePedido + quantidade) {
                System.out.println("Quantidade menor do que o Estoque !");
            } else {
                boolean flagNovoProduto = true;

                // Impede Repetição de Produtos iguais na Lista de Itens
                for (ItemPedido itemPedido : itemPedidoLista) {
                    if (itemPedido.getProduto() == produto) {
                        itemPedido.adicionarQuantidade(quantidade);
                        flagNovoProduto = false;
                    }
                }

                // Novo Produto na Lista de Itens
                if (flagNovoProduto) {
                    double valor_custo = produto.getValor_custo();
                    double valor_total = produto.getValor_custo() * quantidade;

                    ItemPedido item = new ItemPedido(produto, quantidade, valor_custo, valor_total);

                    itemPedidoLista.add(item);
                }

                System.out.println("Item " + produto.getDescricao() + " adicionado ao Pedido ");
            }
        } else {

            // PEDIDO DE ENTRADA

            ItemPedido item = new ItemPedido(produto, quantidade);
            itemPedidoLista.add(item);
            System.out
                    .println(String.valueOf(quantidade) + " " + produto.getDescricao() + " Adicionado(s) ao Pedido\n");
        }

    }

    private int verificaQuantidadePedidoAtual(Produto produto) {
        int quant = 0;
        for (ItemPedido itemPedido : itemPedidoLista) {
            if (itemPedido.getProduto() == produto) {
                quant = quant + itemPedido.getQnt_item();
            }
        }
        return quant;
    }

    public void excluirItemPedido(Produto produto) {
        boolean flagExcluido = false;

        for (Iterator<ItemPedido> itemPedido = itemPedidoLista.iterator(); itemPedido.hasNext();) {
            ItemPedido item = itemPedido.next();
            if (item.getProduto() == produto) {
                item.setStatusPedido(StatusPedido.CANCELADO);

                flagExcluido = true;
            }
        }

        if (flagExcluido) {
            System.out.println("Produto " + produto.getDescricao() + " removido\n");
        } else {
            System.out.println("Produto não encontrado no Pedido\n");
        }
    }

    private double somaValorPedido() {
        // Não soma Item com Status Cancelado
        double soma = 0;
        for (ItemPedido itemPedido : itemPedidoLista) {
            if (itemPedido.getStatusPedido() != StatusPedido.CANCELADO)
                soma = soma + itemPedido.getValor_total();
        }
        return soma;
    }

    public void listaItens() {

        double valorFinal = this.somaValorPedido();

        if (tipoPedido == TipoPedido.SAIDA) {
            for (ItemPedido itemPedido : itemPedidoLista) {
                System.out.printf(
                        "Produto: %s \nQuantidade: %d\nValor Unitario: %.2f\nValor Total: %.2f\nStatus do Item: %s\n----------------------\n",
                        itemPedido.getProduto().getDescricao(), itemPedido.getQnt_item(),
                        itemPedido.getValor_unitario(), itemPedido.getValor_total(),
                        String.valueOf(itemPedido.getStatusPedido()));
            }
            System.out.printf("______________________\nValor Final: %.2f\n______________________\n", valorFinal);
        } else {
            for (ItemPedido itemPedido : itemPedidoLista) {
                System.out.printf(
                        "Produto: %s \nQuantidade: %d\nValor Custo: %.2f\nValor Unitario: %.2f\nStatus do Item: %s\n----------------------\n",
                        itemPedido.getProduto().getDescricao(), itemPedido.getQnt_item(),
                        itemPedido.getProduto().getValor_custo(), itemPedido.getProduto().getValor_unitario(),
                        String.valueOf(itemPedido.getStatusPedido()));
            }
        }
    }

    private void informarFormaPagamento() {
        boolean flagFormaPagamento = true;

        while (flagFormaPagamento) {
            Scanner ler = new Scanner(System.in);
            System.out.print("Informa Método de Pagamento(1- A vista | 2- Cartao | 3- Boleto: ");
            int opcao = ler.nextInt();
            switch (opcao) {
            case 1:
                this.setFormaPagamento(FormaPagamento.A_VISTA);
                flagFormaPagamento = false;
                break;
            case 2:
                this.setFormaPagamento(FormaPagamento.CARTAO);
                flagFormaPagamento = false;
                break;
            case 3:
                this.setFormaPagamento(FormaPagamento.BOLETO);
                flagFormaPagamento = false;
                break;
            default:
                System.out.println("Opção Inválida");
                flagFormaPagamento = true;
                break;
            }
        }

    }

    public void concluirPedido() {
        if (tipoPedido == TipoPedido.ENTRADA) {

            for (ItemPedido itemPedido : itemPedidoLista) {
                if (itemPedido.getStatusPedido() != StatusPedido.CANCELADO) {

                    estoque.entrada(itemPedido.getProduto(), itemPedido.getQnt_item());

                    itemPedido.setStatusPedido(StatusPedido.PROCESSADO);
                }
            }
        } else {

            this.informarFormaPagamento();

            for (ItemPedido itemPedido : itemPedidoLista) {
                if (itemPedido.getStatusPedido() != StatusPedido.CANCELADO) {
                    estoque.saida(itemPedido.getProduto(), itemPedido.getQnt_item());

                    itemPedido.setStatusPedido(StatusPedido.PROCESSADO);
                }
            }
            listaItens();
        }

        System.out.println("\nPedido Concluido com Sucesso\n________________________");

    }

    public Produto buscarProdutoPedido(String descricao) {
        Produto produto = new Produto();
        for (ItemPedido itemPedido : itemPedidoLista) {
            if (itemPedido.getProduto().getDescricao().equals(descricao)) {
                produto = itemPedido.getProduto();
            }
        }

        return produto;

    }

    public StatusPedido getStatusPedido(Produto produto) {
        StatusPedido status = StatusPedido.ATIVO;

        for (ItemPedido itemPedido : itemPedidoLista) {
            if (itemPedido.getProduto() == produto) {
                status = itemPedido.getStatusPedido();
            }
        }
        return status;
    }
}
