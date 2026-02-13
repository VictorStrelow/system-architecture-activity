package br.com.lego.caos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LojaMonolito sistemaRuim = new LojaMonolito();

        System.out.println(">>> SISTEMA LEGADO - LEGO F1 STORE <<<");

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Comprar Mercedes W14 (R$ 1200)");
            System.out.println("2 - Comprar RedBull RB19 (R$ 1350)");
            System.out.println("3 - Tentar gerar Guia de Importação (Teste de Erro)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String opcao = scanner.nextLine();

            if (opcao.equals("0")) break;

            if (opcao.equals("3")) {
                LegoNacional produtoSp = new LegoNacional("Ferrari SF-23", 1100.00);
                System.out.println("Tentando processar alfândega para produto local...");
                try {
                    produtoSp.gerarGuiaAlfandega();
                } catch (Exception e) {
                    System.out.println("\n!!! ERRO DE DESIGN (ISP) DETECTADO !!!");
                    System.out.println("Mensagem: " + e.getMessage());
                    System.out.println("Explicação: A interface obriga exportação em produto nacional.\n");
                }
                continue;
            }

            String modelo = "";
            if (opcao.equals("1")) modelo = "MERCEDES";
            else if (opcao.equals("2")) modelo = "REDBULL";
            else {
                System.out.println("Opção inválida!");
                continue;
            }

            System.out.println("Escolha o Frete: (PADRAO / SEDEX / FULL)");
            String frete = scanner.nextLine();

            sistemaRuim.processarCompra(modelo, frete);
        }

        scanner.close();
        System.out.println("Sistema encerrado.");

    }

}