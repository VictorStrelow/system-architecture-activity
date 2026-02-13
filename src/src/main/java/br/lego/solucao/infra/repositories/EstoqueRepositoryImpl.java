package br.lego.solucao.infra.repositories;

import br.lego.solucao.domain.model.LegoSet;
import br.lego.solucao.domain.ports.repositories.EstoqueRepository;
import br.lego.solucao.infra.database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepositoryImpl implements EstoqueRepository {

    @Override
    public List<LegoSet> buscarTodosOsCarros() {
        List<LegoSet> carros = new ArrayList<>();
        String query = "SELECT * FROM carros";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                carros.add(new LegoSet(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getDouble("peso")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carros;
    }

    @Override
    public LegoSet buscarPorId(int id) {
        String query = "SELECT * FROM carros WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new LegoSet(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getDouble("peso")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}