package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Tcp特点
 * 有连接，可靠传输，全双工
 */
public class TcpEchoServer {
    // 先搞个socket对象，因为网卡在操作系统中被抽象为socket文件
    private ServerSocket serverSocket = null;
    // 同样也要指定一下port的端口
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    // 服务器启动逻辑
    public void start() throws IOException {
        System.out.println("服务器启动！");
        ExecutorService pool = Executors.newCachedThreadPool();
        //因为是有连接通信，循环等待并且处理每一个连接

//        while (true) {
//            Socket clientSocket = serverSocket.accept();
//            processConnection(clientSocket);
//        }
//        为了能够接受多个连接，并且能对每个连接进行循环等待请求，我们使用多线程
//        while (true) {
//            Socket clientSocket = serverSocket.accept();
//            Thread t = new Thread(() -> {
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            t.start();//别忘记start哦，ლ(°◕‵ƹ′◕ლ)
//        }
        //为了应对高并发情况下频繁创建和删除线程，可以用线程池
        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.submit(() -> {
                try {
                    processConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // 通过这个方法来处理一次连接，连接建立的过程中就会涉及到多次请求响应交互
    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线！\n", clientSocket.getInetAddress(), clientSocket.getPort());
        // 循环等待控制台的请求,循环的读取客户端的请求并返回响应
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    // 读取完毕，客户端断开连接，就会产生读取完毕
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                // 1.读取客户端请求并解析,这里注意隐藏约定，next读的时候要读到空白符才会结束
                // 因此就要求客户端发送来的请求必须带有空白符结尾，比如\n或空格
                String request = scanner.next();
                // 2.根据请求计算响应
                String response = process(request);
                // 3.向客户端返回响应
                // 通过这种方式可以写回，但是这种方式不方便给返回的相应中添加\n
//                outputStream.write(response.getBytes(), 0, response.getBytes().length);
                // 也可以给outputStream套上一层， 完成更方便的写入
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();

                System.out.printf("[%s:%d] req: %s, resp: %s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);

            }
        } finally {
            clientSocket.close();
        }

    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(7777);
        tcpEchoServer.start();
    }

}
