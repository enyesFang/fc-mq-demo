package fc.simple.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MqClient {

    /**
     * 生产消息
     */
    public static void produce(String message) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            writer.println(message);
            writer.flush();
        }
    }

    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream())) {
            // 向消息队列发送"consume"消费标识
            writer.println("consume");
            writer.flush();
            // 再从消息队列获取一条消息
            return reader.readLine();
        }
    }


    public static void main(String[] args) throws Exception {
        MqClient.produce("Hello World!");
        String consume = MqClient.consume();
        System.out.println("获取的消息为：" + consume);
    }


}
