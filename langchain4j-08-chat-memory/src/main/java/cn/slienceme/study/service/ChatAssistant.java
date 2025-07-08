package cn.slienceme.study.service;


public interface ChatAssistant {

    // 普通聊天对话，不带记忆缓存功能
    String chat(String prompt);
}
