package src.br.com.alura.main;

import java.util.Scanner;

public class ConverterMenu {
    Scanner sc = new Scanner(System.in);

    public void converterMenu() {

        System.out.println("""
                $$$$$$$$$$ CONVERSOR DE MOEDAS $$$$$$$$$$
                Escolha pelo número uma das opções abaixo:
                
                Converter de:
                1. Real Brasileiro (BRL)
                2. Dólar Americano (USD)
                3. Euro (EUR)
                4. Peso Argentino (ARS)
                5. Yene Japones (JPy)
                
                *******************************************
                
                Digite a opção escolhida:
                """);
         var opcaoConverterDe = sc.nextInt();

        System.out.println("""
                
                 Para:
                1. Real Brasileiro (BRL)
                2. Dólar Americano (USD)
                3. Euro (EUR)
                4. Peso Argentino (ARS)
                5. Yene Japones (JPy)
                
                *******************************************
                
                Digite a opção escolhida:
                """);
        var opcaoPara = sc.nextInt();

        System.out.println("\nDigite o valor a ser convertido:");
        var valorParaConverter = sc.nextDouble();
    }
}
