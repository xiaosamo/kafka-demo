package com.yuanshijia.kafkademo;

/**
 * @author yuan
 * @date 2019/5/19
 * @description
 */
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {


//    @KafkaListener(topics = "${kafka.topic.default}")
//    @KafkaListener(topics = "${spring.kafka.template.default-topic}")

    /**
     * 消费者订阅消息
     * @param record
     */
    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("消费者：收到一条消息 -> topic = {}, offset = {}, key = {}, value = {}", record.topic(), record.offset(), record.key(), record.value());

    }
}