package io;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        //传入文件的绝对路径，Windows中以硬盘的盘符为根节点,分割符用反斜杠，因为反斜杠表示转义字符，所以使用的时候
        //需要将转义字符转义为反斜杠，表示一个反斜杠就需要连续写两个反斜杠
        File f = new File("G:\\java\\J2024_3_30FileIO\\aaa.txt");
        //传入文件的绝对路径，分隔符用正斜杠
        File f1 = new File("G:/java/J2024_3_30FileIO/aaa.txt");
        //传入文件的相对路径
        File f2 = new File("9iuyfd/aaa.txt");
        //判断文件是否存在
        boolean f_exist = f.exists();
        System.out.println("f_exist" + "    :" + f_exist );
        boolean f1_exist = f1.exists();
        System.out.println("f1_exist" + "    :" + f1_exist );
        boolean f2_exist = f2.exists();
        System.out.println("f2_exist" + "    :" + f2_exist );
        System.out.println("f1.getParent()" + "    :" + f1.getParent());
        System.out.println("f2.getParent()" + "    :" + f2.getParent());
        //获取文件名
        System.out.println("f1.getName()" + "    :" + f1.getName());
        System.out.println("f2.getName()" + "    :" + f2.getName());
        //获取打开文件的相对路径
        System.out.println("f1.getPath()" + "    :" + f1.getPath());
        System.out.println("f2.getPath()" + "    :" + f2.getPath());
        //获取打开文件的绝对路径
        System.out.println("f1.getAbsolutePath()" + "    :" + f1.getAbsolutePath());
        System.out.println("f2.getAbsolutePath()" + "    :" + f2.getAbsolutePath());
        //获取打开文件的绝对路径
        System.out.println("f1.getCanonicalPath()" + "    :" + f1.getCanonicalPath());
        System.out.println("f2.getCanonicalPath()" + "    :" + f2.getCanonicalPath());
    }
}