package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}