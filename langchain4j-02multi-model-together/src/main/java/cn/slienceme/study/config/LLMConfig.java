package cn.slienceme.study.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        System.out.println("qwen model init: " + System.getenv("aliQwenApi"));
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwenApi"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * <a href="https://api-docs.deepseek.com/zh-cn/">deepseek接口文档</a>
     */
    @Bean(name = "deepseek")
    public ChatModel chatModelDeepSeek() {
        System.out.println("deepseek model init: " + System.getenv("deepseekApi"));
        return OpenAiChatModel.builder()
                        .apiKey(System.getenv("deepseekApi"))
                        .modelName("deepseek-chat")
                        //.modelName("deepseek-reasoner")
                        .baseUrl("https://api.deepseek.com/v1")
                        .build();
    }

}
