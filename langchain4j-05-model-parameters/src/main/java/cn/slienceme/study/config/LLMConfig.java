package cn.slienceme.study.config;

import cn.slienceme.study.listener.TestChatModelListener;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

/**
 * <a href="https://docs.langchain4j.dev/tutorials/model-parameters/">知识出处</a>
 */
@Configuration
public class LLMConfig {
    @Bean(name = "qwen")
    public ChatModel chatModelQwen() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwenApi"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .logRequests(true) // 日志级别设置为debug才有效
                .logResponses(true)// 日志级别设置为debug才有效
                .listeners(List.of(new TestChatModelListener()))// 监听器
                .maxRetries(2)
                .timeout(Duration.ofSeconds(10))//向大模型发送请求时，如在指定时间内没有收到响应，该请求将被中断并报request timed out
                .build();
    }
}
