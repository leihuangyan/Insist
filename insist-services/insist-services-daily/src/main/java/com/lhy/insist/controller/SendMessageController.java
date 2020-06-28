package com.lhy.insist.controller;

import com.lhy.insist.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @name: SendMessageController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.SendMessageController
 * @date: 2020/6/28 15:15
 * @Version: 1.0
 * @description: TODO
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
