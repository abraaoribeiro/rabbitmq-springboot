package com.example.demo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述：消息消费者
 * @RabbitListener注解定义该类对hello队列的监听，
 * 并用@RabbitHandler注解来指定对消息的处理方法。
 * 所以，该消费者实现了对hello队列的消费，消费操作为输出消息的字符串内容
 * Author: 赵新国
 * Date: 2017/11/3 15:42
 */
@Component
public class Receiver {
	 protected static final String QUEUE_KEY = "hello";
	 
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }

    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }

/*    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
*/
}