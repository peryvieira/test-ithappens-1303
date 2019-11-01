
package model;

/**
 *
 * @author peryv
 */
public class Filial {
    private int id;
    private String nome_filial;

    public Filial(String nome_filial) {
        this.nome_filial = nome_filial;
    }

    public String getNome_filial() {
        return nome_filial;
    }

    public void setNome_filial(String nome_filial) {
        this.nome_filial = nome_filial;
    }

    public int getId() {
        return id;
    }

}
