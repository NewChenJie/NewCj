package com.cj.InterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitHandler {

//    @RabbitListener(queues ={RabbitmqBaseConfig.QUEUE_NAME}
//    public void doCustomer(String str){
//        System.out.println(str+"1111");
//    }



//    @RabbitListener(queues = {RabbitmqConfig.REGISTER_QUEUE_NAME})
//    public void listenerDelayQueue(Book book, Message message, Channel channel) {
//        log.info("[listenerDelayQueue 监听的消息] - [消费时间] - [{}] - [{}]", LocalDateTime.now(), book.toString());
//        try {
//            // TODO 通知 MQ 消息已被成功消费,可以ACK了
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (IOException e) {
//            // TODO 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
//        }
//    }
}
