package src.br.com.alura.main;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    Gson gson = new Gson();
    ConverterMenu opcaoMoeda = new ConverterMenu();
    private  String apiKey = "290c59e959480fa728c37287";

    public Conversor () {
        this.opcaoMoeda = new ConverterMenu();
    }

    public String realizarConversao() {
        opcaoMoeda.converterMenu();

        if(!opcaoMoeda.isEntradasValidas()) {
            if (opcaoMoeda.getOpcaoConverterDe() == 0 && opcaoMoeda.isEntradasValidas()) {
                return "Operação cancelada pelo usoário";
            }
            return "Erro: Dados de entrada inválidos ou incompletos. Não foi possível realizar a conversão.";
        }

        String siglaDe = opcaoMoeda.getSiglaConverterDe();
        String siglaPara = opcaoMoeda.getSiglaPara();
        double valor = opcaoMoeda.getValorParaConverter();

        if (siglaDe == null || siglaPara == null || valor <= 0) {
            return "Erro: Dados para conversão inválidos (moedas ou valor).";
        }

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" +
                apiKey + "/pair/" + siglaDe + "/" + siglaPara + "/" + valor);

        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moeda moedaconvertida = gson.fromJson(response.body(), Moeda.class);
            return String.format("Valor convertido: %.2f %s (Taxa: 1 %s = %.4f %s)",
                    valorFinalConvertido,
                    moedaConvertida.getTarget_code(),
                    moedaConvertida.getBase_code(),
                    moedaConvertida.getConversion_rate(),
                    moedaConvertida.getTarget_code());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
