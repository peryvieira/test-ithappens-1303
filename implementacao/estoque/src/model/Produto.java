
package model;

/**
 *
 * @author peryv
 */
public class Produto {
    private int id;
    private String descricao;
    private double valor_custo;
    private double valor_unitario;
    private String codigo;

    public Produto() {

    }

    public Produto(String descricao, double valor_custo, double valor_unitario) {
        this.descricao = descricao;
        this.valor_custo = valor_custo;
        this.valor_unitario = valor_unitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return getValor_custo();
    }

    public void setValor(double valor) {
        this.setValor_custo(valor);
    }

    public double getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(double valor_custo) {
        this.valor_custo = valor_custo;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
