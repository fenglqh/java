package io;

import java.io.*;

public class Test4 {
    public static void main(String[] args) {
        File rootfile = new File("D:/Program Files/Andriod Studio/build.txt");
        System.out.println(rootfile.getName());
    }
    public static void main2(String[] args) {
        try (Writer writer = new FileWriter("./aaa/bbb.txt", true) ) {
            writer.write("hhh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main1(String[] args) throws IOException {
        try (Reader reader = new FileReader("./aaa/bbb.txt") ) {
            System.out.println(reader.read());
            System.out.println(reader.read());
        }
    }
}
