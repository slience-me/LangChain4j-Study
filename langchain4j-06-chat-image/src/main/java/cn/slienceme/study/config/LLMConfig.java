package cn.slienceme.study.config;

import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a href="https://docs.langchain4j.dev/tutorials/chat-and-language-models/#image-content">知识出处</a>
 */
@Configuration
public class LLMConfig {
    @Bean
    public ChatModel ImageModel() {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwenApi"))
                //qwen-vl-max 是一个多模态大模型，支持图片和文本的结合输入，适用于视觉-语言任务。
                .modelName("qwen-vl-max")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }


    /**
     * 测试通义万象来实现图片生成 <a href="https://help.aliyun.com/zh/model-studio/text-to-image">知识出处</a>
     */
    @Bean
    public WanxImageModel wanxImageModel() {
        return WanxImageModel.builder()
                .apiKey(System.getenv("aliQwenApi"))
                .modelName("wanx2.1-t2i-turbo") // 图片生成 https://help.aliyun.com/zh/model-studio/text-to-image
                .build();
    }
}
