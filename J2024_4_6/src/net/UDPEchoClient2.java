package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 回显服务器客户端练习2
 */
public class UDPEchoClient2 {
    // 同样的socket
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    public  UDPEchoClient2(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();//客户端的端口就由系统自由分配就好啦
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }
    // 执行逻辑
    public void start() throws IOException {
        System.out.println("客户端启动！");
        // 循环从console获取指令
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("->");
            if (!sc.hasNext()) break;
            String request = sc.next();
            // 封装成数据报
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            // 发送给服务器端
            socket.send(requestPacket);
            // 从服务器中接收响应
            byte[] buffer = new byte[4048];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            // 解析响应
            socket.receive(response);
//            String res= new String(response.getData(), response.getData().length);
            String res= new String(response.getData(), 0,response.getLength());
            System.out.println(res);
        }
        System.out.println("客户端下线");
    }

    public static void main(String[] args) throws IOException {
        UDPEchoClient2 udpEchoClient2 = new UDPEchoClient2("127.0.0.1",9995);
        udpEchoClient2.start();
    }
}
