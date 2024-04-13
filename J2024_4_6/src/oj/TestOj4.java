package oj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestOj4 {

    public static void main6(String[] args) throws FileNotFoundException {
        byte[] buffer = new byte[10];//buffer是缓冲区的意思，就是把数据暂时存放到这
        try (InputStream inputStream = new FileInputStream("./aaa/bbb.txt")) {
            int ret = inputStream.read(buffer);//返回实际读到的字节数
            String s = new String(buffer, 0, ret);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main5(String[] args) {
        byte[] elem = new byte[10];
        try (InputStream inputStream = new FileInputStream("./aaa/bbb.txt")) {
            int read = inputStream.read(elem, 1, 9);
            System.out.println(read);
//            for (int i = 0; i < elem.length; i++) {
//                System.out.printf("%x ", elem[i]);
//            }
            String s = new String(elem,1,read);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main3(String[] args) {
        byte[] elem = new byte[4];
        try (InputStream inputStream = new FileInputStream("./aaa/bbb.txt")) {
           inputStream.read(elem);
//            System.out.println(Arrays.toString(elem));
            for (int i = 0; i < elem.length; i++) {
                System.out.printf("%x ", elem[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main2(String[] args) {
        try (InputStream inputStream = new FileInputStream("./aaa/bbb.txt")) {
            System.out.printf("%x " ,inputStream.read());
            System.out.printf("%x " ,inputStream.read());
            System.out.printf("%x " ,inputStream.read());
            System.out.printf("%x " ,inputStream.read());
//            System.out.println(inputStream.read());
//            System.out.println(inputStream.read());
//            System.out.println(inputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./aaa/bbb.txt");//打开文件
            // 其他逻辑
        } finally {
            inputStream.close();// 关闭文件
        }
    }
}
