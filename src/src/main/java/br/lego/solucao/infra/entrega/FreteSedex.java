package br.lego.solucao.infra.entrega;

import br.lego.solucao.domain.ports.strategies.FreteStrategy;

public class FreteSedex implements FreteStrategy {

    @Override
    public double calcular(double peso) {
        return peso * 50.00;
    }

    @Override
    public String getNomeMetodo() {
        return "SEDEX (Rápido)";
    }

}