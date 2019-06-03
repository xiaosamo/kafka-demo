package com.yuanshijia.kafkademo.controller;

import com.yuanshijia.kafkademo.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author yuan
 * @date 2019/5/19
 * @description
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/send")
    public Response sendKafka(String msg) {
        Random random = new Random();
        try {
            // 作为生产者生产一条消息
            log.info("生产者：生产一条消息 -> {}", msg);
            kafkaTemplate.send("test", "random-key-" + random.nextInt(100), msg);
            return Response.success("消息：[" + msg + "]发送成功", null);
        } catch (Exception e) {
            log.error("发送kafka失败", e);
            return Response.error("消息：[" + msg + "]发送成功", null);
        }

    }
}
