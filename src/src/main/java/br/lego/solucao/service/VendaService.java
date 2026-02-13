package br.lego.solucao.service;

import br.lego.solucao.domain.model.LegoSet;
import br.lego.solucao.domain.ports.repositories.PedidoRepository;
import br.lego.solucao.domain.ports.strategies.FreteStrategy;

public class VendaService {

    private final FreteStrategy freteStrategy;
    private final PedidoRepository pedidoRepository;

    public VendaService(FreteStrategy freteStrategy, PedidoRepository pedidoRepository) {
        this.freteStrategy = freteStrategy;
        this.pedidoRepository = pedidoRepository;
    }

    public void registrarCompra(LegoSet lego) {
        System.out.println("\n--- PROCESSANDO VENDA ---");

        double valorFrete = freteStrategy.calcular(lego.getPeso());
        double total = lego.getPreco() + valorFrete;

        System.out.println("Carro: " + lego.getNome());
        System.out.println("Preço Base: R$" + lego.getPreco());
        System.out.println("Frete (" + freteStrategy.getNomeMetodo() + "): R$" + valorFrete);
        System.out.println("TOTAL A PAGAR: R$" + total  );

        pedidoRepository.salvarVenda(lego, freteStrategy.getNomeMetodo(), valorFrete, total);

        System.out.println("--- VENDA FINALIZADA ---");
    }

}