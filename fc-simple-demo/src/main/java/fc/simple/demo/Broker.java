package fc.simple.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Broker {
    /**
     * 队列存储消息的最大数量。
     */
    private static final int MAX_SIZE = 3;
    private static BlockingQueue<String> queue = new ArrayBlockingQueue(MAX_SIZE);

    /**
     * 生产消息。
     */
    public static void produce(String msg) {
        if (queue.offer(msg)) {
            System.out.printf("成功向消息处理中心投递消息：" + msg + ",当前暂存的消息数量：" + queue.size());
        } else {
            System.out.printf("消息处理中心暂存的消息达到最大负荷，不能解析放入消息");
        }
    }

    /**
     * 消费消息。
     */
    public static String consume() {
        String msg = queue.poll();
        if (msg != null) {
            System.out.printf("已经消费消息：" + msg + ",当前暂存的消息数量：" + queue.size());
        } else {
            System.out.println("消息中心已经没有可供消费的消息");
        }
        return msg;
    }

}
