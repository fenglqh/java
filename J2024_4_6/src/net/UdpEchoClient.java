package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    // 客户端也是同样的首先搞个socket
    DatagramSocket socket = null;
    // UDP本身是不保存对方的信息的，所以得自己手动保存
    private String serverIp;
    private int serverPort;

    // 此处ip使用的字符串，是点分十进制风格 "192.168.2.100"
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }
    // 客户端的启动逻辑
    // 客户端启动后需要等待控制台用户输入请求，受到请求后再向服务器端发送，否则也要阻塞等待
    public void start() throws IOException {
        System.out.println("客户端启动！");
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 要做四个事情
            System.out.println("-> "); // 表示提示用户接下来要输入的内容
            // 2. 从控制台读取要发送的请求数据
            if (!sc.hasNext()) {
                break;
            }
            String request = sc.next();
            // 构造请求并发送
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
//            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
//                    request.length(), InetAddress.getByName(serverIp), serverPort);  使用length()行不通，发送中文会乱码
            socket.send(requestPacket);
            // 4. 读取服务器的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            // 5. 把响应显示到控制台上
            String response = new String(responsePacket.getData(), 0, requestPacket.getLength());
            System.out.println(response);

        }

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1" , 9090);
        client.start();
    }
}
