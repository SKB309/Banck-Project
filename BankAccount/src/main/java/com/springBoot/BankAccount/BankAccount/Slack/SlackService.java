package com.springBoot.BankAccount.BankAccount.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackService {
    public String sendMessage(String text) {
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
