package src.br.com.alura.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterMenu {
    Scanner sc = new Scanner(System.in);

    private int opcaoConverterDe;
    private int opcaoPara;
    private double valorParaConverter;
    private boolean entradasValidas = false;

    public void converterMenu() {
        this.entradasValidas = false;

        try {

            System.out.println("""
                    $$$$$$$$$$ CONVERSOR DE MOEDAS $$$$$$$$$$
                    Escolha pelo número uma das opções abaixo:
                                    
                    Converter de:
                    1. Real Brasileiro (BRL)
                    2. Dólar Americano (USD)
                    3. Euro (EUR)
                    4. Peso Argentino (ARS)
                    5. Yene Japones (JPy)
                    0. Sair
                                    
                    *******************************************
                                    
                    Digite a opção escolhida:
                    """);
            this.opcaoConverterDe = sc.nextInt();
            sc.nextLine();

            if (this.opcaoConverterDe == 0) {
                this.entradasValidas = true;
                return;
            }

            System.out.println("""
                                    
                     Para:
                    1. Real Brasileiro (BRL)
                    2. Dólar Americano (USD)
                    3. Euro (EUR)
                    4. Peso Argentino (ARS)
                    5. Yene Japones (JPy)
                    0. Sair
                                    
                    *******************************************
                                    
                    Digite a opção escolhida:
                    """);
            this.opcaoPara = sc.nextInt();
            sc.nextLine();

            System.out.println("\nDigite o valor a ser convertido:");
            this.valorParaConverter = sc.nextDouble();
            sc.nextLine();

            this.entradasValidas = true;

        } catch (InputMismatchException e) {
            System.out.println("Opção inválida! Digite um dos números solicitados.");
            System.out.println("Tente novamente a partir do menu principal.\n");
            sc.nextLine();
        }
    }

    public int getOpcaoConverterDe() {
        return opcaoConverterDe;
    }

    public int getOpcaoPara() {
        return opcaoPara;
    }

    public double getValorParaConverter() {
        return valorParaConverter;
    }

    public boolean isEntradasValidas() {
        return entradasValidas;
    }

    public void fecharScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}
