package br.lego.solucao.domain.ports.repositories;

import br.lego.solucao.domain.model.LegoSet;

import java.util.List;

public interface EstoqueRepository {

    List<LegoSet> buscarTodosOsCarros();
    LegoSet buscarPorId(int id);

}