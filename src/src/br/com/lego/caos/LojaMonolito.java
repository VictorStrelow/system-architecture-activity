package br.com.lego.caos;

public class LojaMonolito {

    public void processarCompra(String modelo, String tipoEntrega) {
        System.out.println("\n=== INICIANDO PROCESSAMENTO DE VENDA ===");

        double preco = 0;
        if (modelo.equalsIgnoreCase("MERCEDES")) {
            preco = 1200.00;
        } else if (modelo.equalsIgnoreCase("REDBULL")) {
            preco = 1350.00;
        } else if (modelo.equalsIgnoreCase("FERRARI")) {
            preco = 1100.00;
        } else {
            System.out.println("Erro: Produto não cadastrado no sistema legado.");
            return;
        }

        double frete = 0;
        int diasEntrega = 0;

        if (tipoEntrega.equalsIgnoreCase("PADRAO")) {
            frete = 25.00;
            diasEntrega = 10;
            System.out.println("[LOGISTICA] Calculando rota via Correios PAC...");
        } else if (tipoEntrega.equalsIgnoreCase("SEDEX")) {
            frete = 60.00;
            diasEntrega = 3;
            System.out.println("[LOGISTICA] Calculando rota via SEDEX...");
        } else if (tipoEntrega.equalsIgnoreCase("FULL")) {
            frete = 0.00;
            diasEntrega = 1;
            System.out.println("[LOGISTICA] Cliente Prime/Full: Envio Prioritário.");
        } else {
            System.out.println("[ERRO] Tipo de entrega desconhecido. Assumindo padrão.");
            frete = 30.00;
            diasEntrega = 15;
        }

        double total = preco + frete;

        try {
            System.out.println("[DB] Abrindo conexão com banco MySQL (Legado)...");
            Thread.sleep(800);
            System.out.println("[DB] INSERT INTO PEDIDOS (PRODUTO, TOTAL) VALUES ('" + modelo + "', " + total + ")");
            System.out.println("[DB] Transação comitada com sucesso.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[EMAIL] Enviando confirmação: Seu " + modelo + " chega em " + diasEntrega + " dias.");
        System.out.println("=== VENDA CONCLUÍDA: R$ " + total + " ===\n");
    }

}