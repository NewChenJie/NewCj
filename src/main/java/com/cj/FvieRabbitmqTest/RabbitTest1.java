package com.cj.FvieRabbitmqTest;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Rabbitmq的简单模式
 * @author Administrator
 */
public class RabbitTest1 {
    //生产者
    @Test
    public void producer() throws IOException, TimeoutException {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        // 设置MabbitMQ所在主机ip或者主机名
        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个频道
        Channel channel = connection.createChannel();
        // 指定一个队列
        channel.queueDeclare("QUEUE_NAME", false, false, false, null);
        // 发送的消息
        String message = "hello world!110";
        // 往队列中发出一条消息
        channel.basicPublish("", "QUEUE_NAME", new AMQP.BasicProperties.Builder().expiration("10000").build(), message.getBytes());
        System.out.println(" 发送消息为：" + message + "'");
        // 关闭频道和连接
        channel.close();
        connection.close();
    }
    //消费
    @Test
    public void customer() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        // 打开连接和创建频道，与发送端一样
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare("QUEUE_NAME", false, false, false, null);
        // 创建队列消费者,是否自动应答false
        QueueingConsumer consumer = new QueueingConsumer(channel);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        // 指定消费队列
        channel.basicConsume("QUEUE_NAME", true, consumer);
        while (true) {
            // nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" 已经接收到：" + message + "'");
        }

//        String queue_name = channel.basicConsume("QUEUE_NAME", true, new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    try {
//                        System.out.println("----------roberto.order.add----------");
//                        System.out.println(new String(body, "UTF-8"));
//                        channel.basicAck(envelope.getDeliveryTag(), false);
//                    } catch (Exception e) {
//                        channel.basicNack(envelope.getDeliveryTag(), false, true);
//                    }
//                }
//
//        });
    }



}