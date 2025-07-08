package cn.slienceme.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 将客户和大模型的对话问答保存进Redis进行持久化记忆留存
 * <a href="https://docs.langchain4j.dev/tutorials/chat-memory#persistence">知识出处</a>
 */
@SpringBootApplication
public class ChatPersistenceLangChain4JApp {
    public static void main(String[] args) {
        SpringApplication.run(ChatPersistenceLangChain4JApp.class, args);
    }
}
