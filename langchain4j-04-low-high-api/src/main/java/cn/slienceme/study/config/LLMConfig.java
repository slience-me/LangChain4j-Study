package cn.slienceme.study.config;

import cn.slienceme.study.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a href="https://docs.langchain4j.dev/get-started">知识出处</a>
 */
@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwenApi"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    /**
     * <a href="https://api-docs.deepseek.com/zh-cn/">知识出处</a>
     */
    @Bean(name = "deepseek")
    public ChatModel chatModelDeepSeek() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("deepseekApi"))
                .modelName("deepseek-chat")
                //.modelName("deepseek-reasoner")
                .baseUrl("https://api.deepseek.com/v1")
                .build();
    }


    // High-Api https://docs.langchain4j.dev/tutorials/ai-services#simplest-ai-service
    @Bean
    public ChatAssistant chatAssistant(@Qualifier("qwen") ChatModel chatModelQwen) {
        return AiServices.create(ChatAssistant.class, chatModelQwen);
    }
}
