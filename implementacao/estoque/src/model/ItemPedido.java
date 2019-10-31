
package model;

/**
 *
 * @author peryv
 */

public class ItemPedido {
    private Produto produto;
    private PedidoEstoque pedido;
    private int qnt_item;
    private double valor_unitario;
    private double valor_total;

    public ItemPedido(Produto produto, PedidoEstoque pedido, int qnt_item, double valor_unitario, double valor_total) {
        this.produto = produto;
        this.pedido = pedido;
        this.qnt_item = qnt_item;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PedidoEstoque getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEstoque pedido) {
        this.pedido = pedido;
    }

    public int getQnt_item() {
        return qnt_item;
    }

    public void setQnt_item(int qnt_item) {
        this.qnt_item = qnt_item;
    }

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

}
