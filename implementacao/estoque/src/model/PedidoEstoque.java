/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import model.TipoPedido;

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

    public PedidoEstoque(int id, Estoque estoque, Usuario usuario, Cliente cliente, String observacao_pedido,
            TipoPedido tipoPedido) {
        this.id = id;
        this.estoque = estoque;
        this.usuario = usuario;
        this.cliente = cliente;
        this.observacao_pedido = observacao_pedido;
        this.tipoPedido = tipoPedido;

    }

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

    public void adicionarItemPedido(Produto produto, int quantidade) {

        if (tipoPedido == TipoPedido.SAIDA) {
            int quantidadeEstoque = this.estoque.getQnt_estoque(produto);

            if (quantidadeEstoque < quantidade) {
                System.out.println("Quantidade menor do que o Estoque !");
            } else {
                double valor_custo = produto.getValor_custo();
                double valor_total = produto.getValor_custo() * quantidade;

                ItemPedido item = new ItemPedido(produto, quantidade, valor_custo, valor_total);

                itemPedidoLista.add(item);

                System.out.println("Item " + produto.getDescricao() + " adicionado ");
            }
        } else {
            if (quantidade >= 0) {
                boolean flagNovoProduto = true;

                for (ItemPedido itemPedido : itemPedidoLista) {
                    if (itemPedido.getProduto() == produto) {
                        itemPedido.adicionarQuantidade(quantidade);
                        flagNovoProduto = false;
                    }
                }

                if (flagNovoProduto) {

                    ItemPedido item = new ItemPedido(produto, quantidade);
                    itemPedidoLista.add(item);
                }

                System.out.println(
                        String.valueOf(quantidade) + " " + produto.getDescricao() + " Adicionado(s) ao Pedido");

            }
        }
    }

    public void excluirItemPedido(Produto produto) {
        boolean flagExcluido = false;

        for (ItemPedido itemPedido : itemPedidoLista) {
            if (itemPedido.getProduto() == produto) {
                itemPedidoLista.remove(itemPedido);
                flagExcluido = true;
            }
        }
        if (flagExcluido) {
            System.out.println("Produto " + produto.getDescricao() + " removido");
        } else {
            System.out.println("Produto não encontrado no Pedido");
        }
    }

    public void listaItens() {
        if (tipoPedido == TipoPedido.SAIDA) {
            for (ItemPedido itemPedido : itemPedidoLista) {
                System.out.printf(
                        "Produto: %s \nQuantidade: %d\nValor Unitario: %.2f\nValor Total: %.2f\n----------------------\n",
                        itemPedido.getProduto().getDescricao(), itemPedido.getQnt_item(),
                        itemPedido.getValor_unitario(), itemPedido.getValor_total());
            }
        } else {
            for (ItemPedido itemPedido : itemPedidoLista) {
                System.out.printf(
                        "Produto: %s \nQuantidade: %d\nValor Custo: %.2f\nValor Unitario: %.2f\n----------------------\n",
                        itemPedido.getProduto().getDescricao(), itemPedido.getQnt_item(),
                        itemPedido.getProduto().getValor_custo(), itemPedido.getProduto().getValor_unitario());
            }
        }
    }

    public void concluirPedido() {
        if (tipoPedido == TipoPedido.ENTRADA) {
            for (ItemPedido itemPedido : itemPedidoLista) {
                estoque.entrada(itemPedido.getProduto(), itemPedido.getQnt_item());
                itemPedido.setStatusPedido(StatusPedido.PROCESSADO);
            }
        } else {
            for (ItemPedido itemPedido : itemPedidoLista) {
                estoque.saida(itemPedido.getProduto(), itemPedido.getQnt_item());
                itemPedido.setStatusPedido(StatusPedido.PROCESSADO);
            }
        }
        System.out.println("Processado");

    }

}
