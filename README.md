# java-challenge-currency-converter-api

# 💰 Conversor de Moedas Dinâmico com API

Este projeto é um Conversor de Moedas desenvolvido em Java como parte de um desafio de programação. O objetivo principal é criar uma aplicação de console interativa que permita aos usuários realizar conversões entre diferentes moedas, com taxas de câmbio obtidas dinamicamente através de uma API externa.

## 🎯 Objetivo do Desafio

Desenvolver um Conversor de Moedas que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 6 opções distintas de conversões de moedas em um menu. A taxa de conversão não será estática, mas sim dinamicamente obtida por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.

## ✨ Funcionalidades Principais

*   **Interface de Console Interativa:** Menu com opções claras para o usuário.
*   **Taxas de Câmbio Dinâmicas:** Consumo de uma API externa para obter as taxas de câmbio mais recentes.
*   **Múltiplas Opções de Conversão:** Suporte para pelo menos 6 pares de moedas para conversão.
*   **Manipulação de JSON:** Análise da resposta da API (formato JSON) para extrair as taxas.
*   **Filtro de Moedas:** Seleção e exibição apenas das moedas de interesse para o usuário.
*   **Exibição Clara de Resultados:** Apresentação do valor convertido de forma compreensível.

## 🛠️ Tecnologias Utilizadas

*   **Java (JDK 11+ recomendado)**
*   **Biblioteca HTTP Client:** Java `java.net.http.HttpClient` (ou alternativas como OkHttp, Apache HttpClient).
*   **Biblioteca JSON:** Gson, Jackson, ou `org.json` (para parsear a resposta da API).
*   **Maven ou Gradle (opcional):** Para gerenciamento de dependências, se utilizado.

## 🌐 API de Taxas de Câmbio

Este projeto utiliza uma API de taxas de câmbio para buscar os valores em tempo real.

*   **API Utilizada:** [Indique o nome da API aqui, ex: ExchangeRate-API, Frankfurter API, Open Exchange Rates]
*   **Chave da API (API Key):** Se a API escolhida requer uma chave de acesso, você precisará se registrar na plataforma da API para obtê-la.
    *   **Importante:** **NUNCA** comite sua API Key diretamente no repositório público. Configure-a através de variáveis de ambiente ou um arquivo de configuração local (ex: `config.properties`) que esteja incluído no seu `.gitignore`.

## 🚀 Como Executar o Projeto

1.  **Clone o Repositório:**
    ```bash
    git clone https://github.com/tknu/java-challenge-currency-converter-api/
    cd NOME_DO_SEU_REPOSITORIO
    ```

2.  **Configure a API Key (se necessário):**
    *   Siga as instruções específicas do seu código para configurar a API Key. Geralmente, isso envolve criar um arquivo `config.properties` na pasta `src/main/resources` ou definir uma variável de ambiente.
    *   Exemplo de `config.properties`:
        ```properties
        api_key=SUA_CHAVE_API_AQUI
        ```
    *   Certifique-se de que este arquivo (se contiver a chave) esteja no `.gitignore`.

3.  **Compile o Projeto:**
    *   Se estiver usando **Maven**:
        ```bash
        mvn clean package
        ```
    *   Se estiver compilando **manualmente** (ajuste os caminhos e nomes de classe conforme necessário):
        ```bash
        # Exemplo para compilar todos os .java em src/main/java para uma pasta 'out'
        javac -d out src/main/java/com/seupacote/*.java
        ```
        (Se tiver dependências externas não gerenciadas por Maven/Gradle, você precisará adicioná-las ao classpath `-cp`)

4.  **Execute o Projeto:**
    *   Se estiver usando **Maven** e gerou um JAR executável (verifique o `pom.xml`):
        ```bash
        java -jar target/nome-do-seu-artefato-executavel.jar
        ```
    *   Se compilou **manualmente**:
        ```bash
        # Substitua com.seupacote.ClassePrincipal pelo nome completo da sua classe principal
        java -cp out com.seupacote.ClassePrincipal
        ```

## 📖 Como Usar

Ao iniciar a aplicação, um menu será exibido no console, similar a este:

```
***************************************************
Bem-vindo ao Conversor de Moedas!

Escolha uma das opções de conversão:
1) Dólar Americano (USD) => Real Brasileiro (BRL)
2) Real Brasileiro (BRL) => Dólar Americano (USD)
3) Euro (EUR) => Real Brasileiro (BRL)
4. Real Brasileiro (BRL) => Euro (EUR)
5) Dólar Americano (USD) => Euro (EUR)
6) Euro (EUR) => Dólar Americano (USD)
7) Sair

Digite a opção desejada:
***************************************************
```

1.  Digite o número da opção de conversão desejada e pressione `Enter`.
2.  Insira o valor que você deseja converter quando solicitado e pressione `Enter`.
3.  O programa exibirá o valor convertido com base na taxa de câmbio atual obtida da API.
4.  Para sair, escolha a opção "Sair" (ou o número correspondente).

## 🗂️ Estrutura do Projeto (Sugestão)

```
conversor-moedas/
├── .gitignore
├── pom.xml                   # Se usar Maven
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── seupacote/  # Seu pacote (ex: meucaminho.conversor)
        │           ├── Main.java                 # Classe principal com o menu
        │           ├── ConversorMoeda.java       # Lógica de conversão
        │           ├── ClienteApi.java           # Lógica de consumo da API
        │           └── ModeloRespostaApi.java    # POJO/Record para mapear resposta JSON (opcional)
        └── resources/
            └── config.properties     # Opcional, para API Key ou outras configurações
```

## 📋 Gerenciamento de Tarefas (Trello)

O desenvolvimento deste projeto pode ser acompanhado utilizando o Trello, seguindo as colunas: "Pronto pra iniciar", "Desenvolvendo", "Pausado" e "Concluído", conforme sugerido no desafio. Esta é uma ferramenta de uso individual para controle e não será avaliada.

## 🔮 Possíveis Melhorias Futuras

*   Adicionar mais opções de moedas ou permitir que o usuário insira códigos de moeda arbitrários (com validação).
*   Implementar um cache local para as taxas de câmbio para reduzir o número de chamadas à API e melhorar o desempenho.
*   Adicionar tratamento de erros mais robusto (ex: falha na conexão com a internet, API indisponível, formato de entrada inválido).
*   Criar uma interface gráfica (GUI) utilizando JavaFX ou Swing.
*   Salvar histórico de conversões.

## 🧑‍💻 Autor

*   **ONE - ORACLE NEXT EDUCATION**
*   **Thiago Ueda**

---

Sinta-se à vontade para contribuir, reportar *issues* ou sugerir melhorias!
```

