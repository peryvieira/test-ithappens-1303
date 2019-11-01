package app;

import model.*;

import java.io.Console;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static Usuario usuario = new Usuario("pery", "peryvieira", "123");
    static Cliente cliente = new Cliente("joao", "027633133123");

    static Filial filialCohama = new Filial("Cohama");
    static Filial filialCohab = new Filial("Cohab");
    static Filial filialCohatrac = new Filial("Cohatrac");

    static Estoque estoqueCohama = new Estoque(filialCohama);
    static Estoque estoqueCohab = new Estoque(filialCohab);
    static Estoque estoqueCohatrac = new Estoque(filialCohatrac);

    static Filial filialAtual = filialCohama;
    static Estoque estoqueAtual = estoqueCohama;

    public static void main(String[] args) throws IOException, Exception, InterruptedException {

    }

}
