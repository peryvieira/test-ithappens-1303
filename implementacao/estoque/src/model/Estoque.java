/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author peryv
 */
public class Estoque {
    private Filial filial;
    private HashMap<Produto, Integer> estoque = new HashMap<Produto, Integer>();

    public Estoque(Filial filial) {
        this.filial = filial;
    }

    public int getQnt_estoque(Produto produto) {
        return this.estoque.get(produto);
    }

    public void entrada(Produto produto, int quantidade) {

        if (quantidade <= 0)
            System.err.println("Quantidade inválida");
        else {
            if (this.estoque.get(produto) == null) {
                this.estoque.put(produto, quantidade);
            } else {
                this.estoque.put(produto, estoque.get(produto) + quantidade);

            }

        }
    }

    public void saida(Produto produto, int quantidade) {
        if (estoque.get(produto) - quantidade < 0) {
            System.err.println("Quantidade no estoque insuficiente\n");
        } else {
            estoque.put(produto, estoque.get(produto) - quantidade);
        }
    }

}
