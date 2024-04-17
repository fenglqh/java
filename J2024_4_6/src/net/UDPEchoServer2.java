package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;


/**
 * 第二次练习udp服务器端的步骤
 * udp 数据报，无连接，不可靠，全双工
 */
public class UDPEchoServer2 {
    // 进行网络通信，肯定得有socket
    private DatagramSocket socket = null;
    // 指定端口号,因为服务器的端口号是可控制的
    public UDPEchoServer2(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    // 连接建立好后的执行逻辑
    public void start() throws IOException {
        System.out.println("服务器启动！");
        // 循环接收来自客户端的请求
        while (true) {
            //设置一个接收缓冲区
            byte[] buffer = new byte[4048];
            // 设置一个接收客户端请求的数据报(二进制)
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(requestPacket);
            //将请求转换成字符串，方便后续的操作
//            String request = new String(requestPacket.getData(),0,requestPacket.getData().length);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 根据请求计算响应
            String response = process(request);
            // 将响应封装成数据报
            byte[] buffer2 = response.getBytes(StandardCharsets.UTF_8);
            DatagramPacket responsePacket = new DatagramPacket(buffer2, buffer2.length,
                    requestPacket.getSocketAddress());
            // 发送响应
            socket.send(responsePacket);
            // 打印日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(),
                    responsePacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UDPEchoServer2 udpEchoServer2 = new UDPEchoServer2(9995);
        udpEchoServer2.start();
    }
}
