/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author peryv
 */
public class PedidoEstoque {
    private int id;
    private Filial filial;
    private Usuario usuario;
    private Cliente cliente;
    private String observacao_pedido;
    private TipoPedido tipoPedido;

    public PedidoEstoque(int id, Filial filial, Usuario usuario, Cliente cliente, String observacao_pedido,
            TipoPedido tipoPedido) {
        this.id = id;
        this.filial = filial;
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

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
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

}
