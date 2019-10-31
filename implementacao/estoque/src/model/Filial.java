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
