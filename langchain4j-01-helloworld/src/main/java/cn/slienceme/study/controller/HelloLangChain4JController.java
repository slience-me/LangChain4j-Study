package cn.slienceme.study.controller;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloLangChain4JController {
    // http://localhost:9001/langchain4j/hello?question=如何学习java

    @Resource
    private ChatModel chatModel;

    @GetMapping(value = "/langchain4j/hello")
    public String hello(@RequestParam(value = "question", defaultValue = "你是谁") String question) {
        String result = chatModel.chat(question);
        System.out.println("调用大模型回复: " + result);
        return result;
    }

    public void test1(String question) {
    }
}
