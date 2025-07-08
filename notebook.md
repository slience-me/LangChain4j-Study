# 笔记

UserService UserServiceImpl

和LLM对接的程序员自己定义的业务接口

用底层api对话：ChatModel
用高阶api对话：
ChatAssistant

1. 自己封装一个业务接口：ChatAssistant --》实现类 ChatAssistantImpl 没有了
2. 交给高阶api

```java
public static <T> T create(Class<T> aiService, ChatModel chatModel) {
    return builder(aiService).chatModel(chatModel).build();
}
// AiServices.create(ChatAssistant.class, chatModelQwen);
```
