package cn.slienceme.study.controller;

import cn.slienceme.study.service.ChatAssistant;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HighApiController {
    @Resource
    private ChatAssistant chatAssistant;

    // http://localhost:9004/highapi/highapi
    @GetMapping(value = "/highapi/highapi")
    public String highApi(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt) {
        return chatAssistant.chat(prompt);
    }
}
