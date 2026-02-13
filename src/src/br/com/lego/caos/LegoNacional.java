package br.com.lego.caos;

public class LegoNacional implements IProdutoEcommerce {

    private String nome;
    private double preco;

    public LegoNacional(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrecoBase() {
        return preco;
    }

    @Override
    public void gerarGuiaAlfandega() {
        throw new RuntimeException("ERRO CRÍTICO: Não é possível gerar guia de importação para produto nacional!");
    }

}