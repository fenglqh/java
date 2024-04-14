package io;

import java.io.*;
import java.util.Scanner;

public class FileContentSearcher {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要搜索的内容: ");
        String dest = sc.nextLine();
        System.out.println("请输入要搜索的目录: ");
        String dest_dir = sc.nextLine();
        File destFile = new File(dest_dir);
        if (!destFile.isDirectory()) {
            System.out.println("文件目录有误！");
            return;
        }
        scanDir(dest,destFile);
    }

    private static void scanDir(String dest, File destFile) throws IOException {
        // 列出所有子文件目录
        File[] files = destFile.listFiles();
        if (files == null) return;
        for (File f : files) {
//            System.out.println("当前遍历到：" + f.getCanonicalPath());
            if (f.isFile()) {
                scanInFile(dest,f);
            } else if (f.isDirectory()) {
                scanDir(dest, f);
            }
        }
    }

    private static void scanInFile(String dest, File file) throws FileNotFoundException {
        try (InputStream inputStream = new FileInputStream(file)) {
            StringBuilder ss = new StringBuilder();
            while (true) {
                byte[] buffer = new byte[1024];
                int ret = inputStream.read(buffer);
                if (ret == -1) break;
                String s = new String(buffer, 0, ret);
                ss.append(s);
            }
            // 加了打印之后, 可以看到, 文件内容是对的. 说明后面的匹配有问题.
            System.out.println("[debug] 文件内容: " + ss);
            if (ss.indexOf(dest) == -1) {
                return;
            }
            System.out.println("找到了，有" + dest + "的路径是" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
