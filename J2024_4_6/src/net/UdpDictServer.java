package net;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer{
    private HashMap<String,String> dict = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("moon","不要忘记月亮");
        dict.put("star","星辰大海");
        dict.put("sun","希望之光");
    }
    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"输入的单词有误");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
