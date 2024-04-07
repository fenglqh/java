package net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
   //进行网络编程，首先得搞个socket对象
    DatagramSocket socket = null;
    //构造方法，负责给这个服务指定端口号
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    //服务器启动逻辑
    //服务器启动后需要循环等待客户端发送的消息
    //等到就处理，等不到就阻塞
    public void start() throws IOException {
        System.out.println("服务器启动");
        //每次循环，就是一个处理请求-响应的过程
        while (true) {
            // 1.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            // 读到的字节数组，转成String方便后续的逻辑处理
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2.根据请求计算响应 (对于回显服务器来说，这一步什么也不用做)
            String response = process(request);
            // 3.把响应返回到客户端
            // 构造一个DatagramPacket 作为响应对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
//            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
//                    response.length(), requestPacket.getSocketAddress());
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
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
