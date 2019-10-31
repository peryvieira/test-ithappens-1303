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
public class Estoque {
    private Filial filial;
    private Produto produto;
    private int qnt_estoque;

    public Estoque(Filial filial, Produto produto, int qnt_estoque) {
        this.filial = filial;
        this.produto = produto;
        this.qnt_estoque = qnt_estoque;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQnt_estoque() {
        return qnt_estoque;
    }

    public void setQnt_estoque(int qnt_estoque) {
        this.qnt_estoque = qnt_estoque;
    }

}
