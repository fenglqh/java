package io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        File file = new File("./aaa/txt/bbb.txt");
        File dest = new File("./aaa/bbb.txt");
        boolean b = file.renameTo(dest);
        System.out.println(b);
    }
    public static void main3(String[] args) {
        File file = new File("./");
        String[] files = file.list();
        System.out.println(Arrays.toString(files));
    }
    public static void main2(String[] args) throws IOException {
        File f = new File("./aaa/txt");
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.mkdirs());
        File f1 = new File("./aaa/txt/bbb.txt");
        System.out.println(f1.createNewFile());
        f1.createNewFile();
    }
    public static void main1(String[] args) {
        System.out.println("G"+File.pathSeparator+"ccc");
    }
}
