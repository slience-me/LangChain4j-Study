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

    @Resource(name = "qwen")
    private ChatModel chatModelQwen;

    @Resource(name = "deepseek")
    private ChatModel chatModelDeepSeek;

    // http://localhost:9002/multimodel/qwen
    @GetMapping(value = "/multimodel/qwen")
    public String qwenCall(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        String result = chatModelQwen.chat(prompt);
        System.out.println("通过langchain4j调用模型返回结果：\n" + result);
        return result;
    }

    // http://localhost:9002/multimodel/deepseek
    @GetMapping(value = "/multimodel/deepseek")
    public String deepseekCall(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        String result = chatModelDeepSeek.chat(prompt);
        System.out.println("通过langchain4j调用模型返回结果：\n" + result);
        return result;
    }
}
