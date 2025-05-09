package src.br.com.alura.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConverterMenu {
    Scanner sc = new Scanner(System.in);

    private int opcaoConverterDe;
    private int opcaoPara;
    private double valorParaConverter;
    private boolean entradasValidas = false;
    private String siglaConverterDe = null;
    private String siglaPara = null;

    private String obterSiglaMoeda(int opcao) {
        String sigla;
        switch (opcao) {
            case 1:
                sigla = "BRL";
                break;
            case 2:
                sigla = "USD";
                break;
            case 3:
                sigla = "EUR";
                break;
            case 4:
                sigla = "ARS";
                break;
            case 5:
                sigla = "JPY";
                break;
            default:
                sigla = "Opção inválida!";
        }
        return sigla;
    }

    public void converterMenu() {

        this.entradasValidas = false;

        try {

            System.out.println("""
                    $$$$$$$$$$ CONVERSOR DE MOEDAS $$$$$$$$$$
                    
                    Bem-vindo ao Conversor de Moedas!
                    API Utilizada: ExchangeRate-API
                    
                    Escolha pelo número uma das opções abaixo:
                                    
                    Converter de:
                    1. Real Brasileiro (BRL)
                    2. Dólar Americano (USD)
                    3. Euro (EUR)
                    4. Peso Argentino (ARS)
                    5. Yene Japones (JPY)
                    0. Sair
                    *******************************************
                       
                    Digite a opção escolhida: """);
            this.opcaoConverterDe = sc.nextInt();
            sc.nextLine();

            if (this.opcaoConverterDe == 0) {
                this.entradasValidas = true;
                return;
            }

            this.siglaConverterDe = obterSiglaMoeda(this.opcaoConverterDe);
            if (this.siglaConverterDe == null) {
                System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println("""
                    
                    Para:
                    1. Real Brasileiro (BRL)
                    2. Dólar Americano (USD)
                    3. Euro (EUR)
                    4. Peso Argentino (ARS)
                    5. Yene Japones (JPY)
                    0. Sair
                    *******************************************
                    
                    Digite a opção escolhida: """);
            this.opcaoPara = sc.nextInt();
            sc.nextLine();

            this.siglaPara = obterSiglaMoeda(this.opcaoPara);
            if (this.siglaPara == null) {
                System.out.println("Opção inválida! Tente novamente.");
            }
            if (this.siglaPara.equals(this.siglaConverterDe)) {
                System.out.println("Não é possível converter uma moeda para ela mesma. Tente novamente.");
            }

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

    public String getSiglaConverterDe() {
        return siglaConverterDe;
    }

    public String getSiglaPara() {
        return siglaPara;
    }
}
