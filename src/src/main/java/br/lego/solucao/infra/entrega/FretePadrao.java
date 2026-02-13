package br.lego.solucao.infra.entrega;

import br.lego.solucao.domain.ports.strategies.FreteStrategy;

public class FretePadrao implements FreteStrategy {

    @Override
    public double calcular(double peso) {
        return peso * 20.00;
    }

    @Override
    public String getNomeMetodo() {
        return "PAC (Normal)";
    }

}