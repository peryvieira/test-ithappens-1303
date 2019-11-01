
package model;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author peryv
 */
public class Estoque {
    private Filial filial;
    public HashMap<Produto, Integer> estoqueProdutos = new HashMap<Produto, Integer>();

    public Estoque(Filial filial) {
        this.filial = filial;
    }

    public int getQnt_estoque(Produto produto) {
        return this.estoqueProdutos.get(produto);
    }

    public void entrada(Produto produto, int quantidade) {

        if (quantidade <= 0)
            System.err.println("Quantidade inválida");
        else {
            if (this.estoqueProdutos.get(produto) == null) {
                this.estoqueProdutos.put(produto, quantidade);
            } else {
                this.estoqueProdutos.put(produto, estoqueProdutos.get(produto) + quantidade);

            }

        }
    }

    public void saida(Produto produto, int quantidade) {
        if (estoqueProdutos.get(produto) - quantidade < 0) {
            System.err.println("Quantidade no estoqueProdutos insuficiente\n");
        } else {
            estoqueProdutos.put(produto, estoqueProdutos.get(produto) - quantidade);
        }
    }

    public Produto buscarProdutoEstoque(String descricao) {
        Produto produtoEncontrado = new Produto();

        for (Produto produto : estoqueProdutos.keySet()) {
            if (produto.getDescricao().equals(descricao)) {
                produtoEncontrado = produto;
                System.out.println("\nProduto Encontrado!");
            }
        }

        return produtoEncontrado;
    }
}
