package com.cj.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * rabbit基本配置的实现
 */
@Configuration
@Slf4j
public class RabbitmqBaseConfig {
    public static final String EXCHANGE_NAME="base.exchange";
    public static final String QUEUE_NAME="base.queue";
    public static final String ROUTING_KEY="base.routing.key";
    public static final String DEAD_QUEUE="dead.queue";
    public static final String DEAD_EXCHANGE="dead.exchange";
    public static final String DEAD_KEY="dead.key";
    @Bean
    public RabbitTemplate baseRabbitTemplate(CachingConnectionFactory connectionFactory) {
        //消息失败发送的回调状态开启，调用returnCallback在没有对应的队列
        connectionFactory.setPublisherReturns(true);
        //确认消息发送到交换器
        connectionFactory.setPublisherConfirms(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置必须要有对应的队列否则消息将丢弃
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause)
                -> log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause));
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey)
                -> log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        return rabbitTemplate;
    }
    @Bean
    public DirectExchange baseExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange(DEAD_EXCHANGE);
    }

    //exclusive排他性，对于connection而言，断开后就自动的删除该队列

    @Bean
    public Queue baseQueue() {
        Map<String, Object> arguments = new HashMap<String, Object>();
        // 统一设置队列中的所有消息的过期时间
        arguments.put("x-message-ttl", 30000);
        // 设置超过多少毫秒没有消费者来访问队列，就删除队列的时间
        arguments.put("x-expires", 20000);
        // 设置队列的最新的N条消息，如果超过N条，前面的消息将从队列中移除掉 队列的长度
        arguments.put("x-max-length", 4);
        // 设置队列的内容的最大空间，超过该阈值就删除之前的消息
        arguments.put("x-max-length-bytes", 1024);
        // 将删除的消息推送到指定的交换机，一般x-dead-letter-exchange和x-dead-letter-routing-key需要同时设置
        arguments.put("x-dead-letter-exchange", "exchange.dead");
        // 将删除的消息推送到指定的交换机对应的路由键
        arguments.put("x-dead-letter-routing-key", "routingkey.dead");
        // 设置消息的优先级，优先级大的优先被消费
        arguments.put("x-max-priority", 10);
        Map<String,Object> param = new HashMap<>(16);
        param.put("x-message-ttl",10000);
        param.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        param.put("x-dead-letter-routing-key",DEAD_KEY);
        return new Queue(QUEUE_NAME, true,false,false,param);
    }

    @Bean
    public Queue deadQueue(){
        return new Queue(DEAD_QUEUE,true);
    }
    @Bean
    public Binding baseBinding() {
        return BindingBuilder.bind(baseQueue()).to(baseExchange()).with(ROUTING_KEY);
    }
    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with(DEAD_KEY);
    }



}
