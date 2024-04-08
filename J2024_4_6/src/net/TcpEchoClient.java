package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket,SetverSocket
 */
public class TcpEchoClient {
    // 先搞个socket对象，因为网卡在操作系统中被抽象为socket文件
    private Socket socket = null;
    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        // 此处可以把这里的ip和port直接传给socket对象
        // 由于tcp是有连接的，所以此处的socket里面就会保存好这两信息
        // 因此此处TcpEchoClient类就不必保存
        socket = new Socket(serverIp, serverPort);
    }

    public void  start() {
        System.out.println("客户端启动！");
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()
        ) {
            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while (true) {
                // 这里的流程和UDP的客户端类似
                // 1.从控制台读取输入的字符串
                System.out.print("-> ");
                if (!scannerConsole.hasNext()) {
                    break;
                }
                String request = scannerConsole.next();
                // 2.把请求发给服务器，这里需要使用println来发送， 为了让发送的请求末端带有\n
                // 这里是和服务器的scanner.next呼应的
                writer.println(request);
                // 通过这个flush 主动刷新缓冲区，却保数据真的发出去了
                writer.flush();
                // 3. 从服务器读取响应，这里也是和服务器返回响应的逻辑对应
                String response = scannerNetwork.next();
                // 4.把响应显示出来
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 7777);
        client.start();
    }
}
