package com.cj.FvieRabbitmqTest;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq的工作模式
 * @author Administrator
 */
public class RabbitTest2 {
    /**
     * 队列的名称
     */
    private final static String QUEUE_NAME = "WORK_QUEUE";

    /**
     * 生产者
     */
    @Test
    public void producer() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送10条消息，依次在消息后面附加1-10个点
        for (int i = 0; i < 10; i++) {
            String dots = "";
            for (int j = 0; j <= i; j++) {
                dots += ".";
            }
            //拼数据
            String message = "rabbitmq" + dots + dots.length();
            //推送到rabbitmq中
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            //推送完成,打印结束语句
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭队列
        channel.close();
        //关闭消息
        connection.close();
    }

    /**
     * 消费者
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws TimeoutException
     */
@Test
    public void customer() throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        //区分不同工作进程的输出
        int hashCode = String.valueOf(System.currentTimeMillis()).hashCode();
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置ip
        factory.setHost("localhost");
        //创建连接
        Connection connection = factory.newConnection();
        //创建队列
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(hashCode+" [*] Waiting for messages. To exit press CTRL+C");
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //设置最大服务转发消息数量
        //int prefetchCount = 1;
        //channel.basicQos(prefetchCount);
       // 指定消费队列
        //关闭应答机制,会丢失消息,消息应答默认是打开的,ack = false
//        channel.basicConsume(QUEUE_NAME, true, consumer);
        //打开应答机制,不会丢失消息
        channel.basicConsume(QUEUE_NAME, false, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(hashCode + " [x] Received '" + message + "'");
//            doWork(message);
            System.out.println(hashCode + " [x] Done");
            //我们需要标识我们的信息为持久化的。通过设置MessageProperties（implements BasicProperties）值为PERSISTENT_TEXT_PLAIN。
            //channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            //发送应答消息ACK
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
