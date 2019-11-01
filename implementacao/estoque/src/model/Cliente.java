
package model;

/**
 *
 * @author peryv
 */
public class Cliente {
    private int id;
    private String nome_cliente;
    private String cpf_cliente;

    public Cliente(String nome_cliente, String cpf_cliente) {

        this.nome_cliente = nome_cliente;
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public int getId() {
        return id;
    }

}
