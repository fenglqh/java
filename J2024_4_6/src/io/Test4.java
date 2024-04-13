package io;

import java.io.*;

public class Test4 {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("./aaa/bbb.txt") ) {
            writer.w
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
