package com.lhy.insist.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @name: ReceiverMessageListenerController
 * @author： LHY
 * @classPath: com.lhy.insist.controller.ReceiverMessageListenerController
 * @date: 2020/6/28 15:14
 * @Version: 1.0
 * @description: TODO
 */
@Component
@EnableBinding(Sink.class)
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private  String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号， -----> 接受到的消息： " + message.getPayload()
                + "\t port: " + serverPort);
    }
}
