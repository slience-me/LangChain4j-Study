package cn.slienceme.study.service;

import reactor.core.publisher.Flux;

public interface ChatAssistant {
    String chat(String prompt);

    Flux<String> chatFlux(String prompt);
}
