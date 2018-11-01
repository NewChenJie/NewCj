package com.cj.controller;

import com.cj.config.RabbitmqBaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/rabbit")
public class RabbitmqController {
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    public RabbitmqController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book);
     */
 /*   @GetMapping("/delay")
    public void defaultMessage() {
        Book book = new Book();
        book.setId("1");
        book.setName("一起来学Spring Boot");
        // 添加延时队列
        this.rabbitTemplate.convertAndSend(RabbitmqConfig.REGISTER_DELAY_EXCHANGE, RabbitmqConfig.DELAY_ROUTING_KEY, book, message -> {
            // TODO 第一句是可要可不要,根据自己需要自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
            // TODO 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明
            // Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(5 * 1000 + "");
            return message;
        });
        log.info("[发送时间] - [{}]", LocalDateTime.now());
    }
*/

 //message.getMessageProperties()用来设置消息的基本属性

    @GetMapping("/base")
    public void baseMessage(){
        for (int i=0;i<3;i++) {
            log.info("发送{}次",i);
            String baseMessage="what the fuck!";
            rabbitTemplate.convertAndSend(RabbitmqBaseConfig.EXCHANGE_NAME,RabbitmqBaseConfig.ROUTING_KEY,baseMessage,message
                    -> message);
        }


    }
}
