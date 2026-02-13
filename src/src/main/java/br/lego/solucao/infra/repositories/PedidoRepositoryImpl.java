package br.lego.solucao.infra.repositories;

import br.lego.solucao.domain.model.LegoSet;
import br.lego.solucao.domain.ports.repositories.PedidoRepository;
import br.lego.solucao.infra.database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoRepositoryImpl implements PedidoRepository {

    @Override
    public void salvarVenda(LegoSet lego, String tipoFrete, double valorFrete, double total) {
        String query = "INSERT INTO pedidos (carro_nome, tipo_frete, valor_frete, valor_total) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, lego.getNome());
            stmt.setString(2, tipoFrete);
            stmt.setDouble(3, valorFrete);
            stmt.setDouble(4, total);
            stmt.executeUpdate();

            System.out.println("[DB] Venda dalva na tabela 'pedidos' com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar venda: " + e.getMessage());
        }
    }

}