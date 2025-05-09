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

    public String realizarConversao() throws IOException, InterruptedException {
        opcaoMoeda.converterMenu();

        if (!opcaoMoeda.isEntradasValidas()) {
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
        URI endereco;
        try {
            String urlString = "https://v6.exchangerate-api.com/v6/" +
                    apiKey + "/pair/" + siglaDe + "/" + siglaPara + "/" + valor;
            endereco = URI.create(urlString);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar URI: " + e.getMessage());
            return "Erro interno ao formar o pedido de conversão.";
        }

            HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

            try {
                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    String responseBody = response.body();

                    Moeda moedaConvertida = gson.fromJson(responseBody, Moeda.class);

                    if ("success".equalsIgnoreCase(moedaConvertida.getResult())) {

                        return String.format("""
                                        
                                        ****************************************************************
                                        %.2f %s equivalem a %.2f %s (Taxa de conversão: %.4f)
                                        ****************************************************************
                                        """,
                                valor,
                                moedaConvertida.getBase_code(),
                                moedaConvertida.getConversion_result(),
                                moedaConvertida.getTarget_code(),
                                moedaConvertida.getConversion_rate());
                    } else {
                        return "Erro da API ao converter moedas (JSON 'result' não é 'success'). Detalhes: " + responseBody;
                    }
                } else {
                    return "Erro na API: Status " + response.statusCode() + " - Corpo: " + response.body();
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return "Erro de comunicação com a API: " + e.getMessage();
            }
        }

        public void fecharRecursos() {
            if (opcaoMoeda != null) {
                opcaoMoeda.fecharScanner();
            }
        }
    }
