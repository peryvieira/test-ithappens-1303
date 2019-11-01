
package model;

import model.*;

/**
 *
 * @author peryv
 */

public class ItemPedido {
    private Produto produto;
    private int qnt_item;
    private double valor_unitario;
    private double valor_total;
    // private double valor_custo;
    private StatusPedido statusPedido = StatusPedido.ATIVO;

    // Para saída de Produto
    public ItemPedido(Produto produto, int qnt_item, double valor_unitario, double valor_total) {
        this.produto = produto;
        this.qnt_item = qnt_item;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
    }

    // Para Entrada de Produto (não precisa somar valor se for para entrada de
    // estoque).
    public ItemPedido(Produto produto, int qnt_item) {
        this.produto = produto;
        this.qnt_item = qnt_item;

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQnt_item() {
        return qnt_item;
    }

    // private void setQnt_item(int qnt_item) {
    // this.qnt_item = qnt_item;
    // }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public void adicionarQuantidade(int quantidade) {
        this.qnt_item = qnt_item + quantidade;
        this.valor_total = qnt_item * getValor_unitario();
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

}
