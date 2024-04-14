package io;

import java.io.*;
import java.util.Scanner;

/**
 * 文件复制
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要复制的源文件");
        String src = sc.nextLine();
        System.out.println("请输入要复制的目标文件");
        String dest = sc.nextLine();

        // 合法性判断
        // 1)src对应的文件是否存在
        File src_file = new File(src);
        File dest_file = new File(dest);
        if (!src_file.isFile()) {
            System.out.println("源文件路径有误！");
            return;
        }
        // 2)destPath 不要求对应的文件存在，但是目录得存在
        if (!dest_file.getParentFile().isDirectory()) {
            System.out.println("目标路径有误！");
            return;
        }
        if (!dest_file.isFile()) {
            dest_file.createNewFile();
        }
        copy(src_file, dest_file);
    }
    public static void copy(File src, File dest) throws IOException {
        try (InputStream inputStream = new FileInputStream(src);
             OutputStream outputStream = new FileOutputStream(dest)) {
            while (true) {
                byte[] buffer = new byte[1024];
                int ret = inputStream.read(buffer);
                if (ret == -1) break;
                outputStream.write(buffer);
            }

        }
        System.out.println("复制结束！");
    }
}
