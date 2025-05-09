package src.br.com.alura.main;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConverterMenu menuPrincipal = new ConverterMenu();
        //menuPrincipal.converterMenu();
        Conversor conversor = new Conversor();
        String resultadoDaConversao = conversor.realizarConversao();
        System.out.println(resultadoDaConversao);
    }
}
