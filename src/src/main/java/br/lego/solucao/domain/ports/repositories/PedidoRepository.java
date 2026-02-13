package br.lego.solucao.domain.ports.repositories;

import br.lego.solucao.domain.model.LegoSet;

public interface PedidoRepository {

    void salvarVenda(LegoSet lego, String tipoFrete, double valorFrete, double total);

}