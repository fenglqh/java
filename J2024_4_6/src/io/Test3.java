package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("./aaa/txt/test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (OutputStream outputStream = new FileOutputStream(file.getName(), true);
        InputStream inputStream = new FileInputStream(file.getName())) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String s = sc.next();
                if (s.equals("exit")) break;
                byte[] b = s.getBytes(StandardCharsets.UTF_8);
                outputStream.write(b);
            }
            byte[] buffer = new byte[1024];
            int ret = inputStream.read(buffer);
            String s1 = new String(buffer, 0, ret);
            System.out.println(s1);
        }
    }
    public static void main1(String[] args) throws FileNotFoundException {
        try (OutputStream outputStream = new FileOutputStream("./aaa/bbb.txt")) {
            // 其他逻辑
            byte[] buffer = {'6','b','c','d'};
            outputStream.write(buffer,1,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
