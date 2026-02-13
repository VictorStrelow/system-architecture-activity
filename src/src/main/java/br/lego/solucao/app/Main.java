package br.lego.solucao.app;

import br.lego.solucao.infra.database.Conexao;

import java.sql.SQLException;

public class Main {
    static void main(String[] args) throws SQLException {

        Conexao.conectar();

    }
}