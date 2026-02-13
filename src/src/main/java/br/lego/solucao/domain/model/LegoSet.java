package br.lego.solucao.domain.model;

public class LegoSet {

    private int id;
    private String nome;
    private double preco;
    private double peso;

    // Construtor
    public LegoSet() {}

    public LegoSet(int id, String nome, double preco, double peso) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | R$ " + preco + " | " + peso + "kg";
    }

}