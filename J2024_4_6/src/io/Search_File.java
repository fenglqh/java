package io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 在文件系统中查找文件
 */
public class Search_File {
    public static void main(String[] args) throws IOException {
        // 1. 输入必要的信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要搜索的文件名:");
        String fileName = sc.nextLine();//以空白符为分割
        System.out.println("请输入要搜索的目录:");
        String rootPath = sc.nextLine();
        File rootfile = new File(rootPath);
        System.out.println(rootfile.isDirectory());
        if (!rootfile.isDirectory()) {
            System.out.println("输入的路径有误！");
            return;
        }
        // 2. 有了要搜索的路径之后，就可以安装递归的方式来搜
        // 索，知道递归的终点，还需要知道要查询的文件名
        scanDir(fileName,rootfile);
    }

    private static void scanDir(String fileName, File rootfile) throws IOException {
        // 1,把当前目录下的文件都列出来
        File[] files = rootfile.listFiles();
        if (files == null) { // 空目录直接返回
            return;
        }
         // 2.循环遍历查找，判断每一个file是目录还是文件
        for (File f: files) {
//            System.out.println("当前遍历到：" + f.getCanonicalPath());
            if (f.isFile()) { // 普通文件就判断是不是要查找的文件
                if (f.getName().equals(fileName)) {
                    System.out.println("找到了！" + fileName + "的路径是" + f.getCanonicalPath());
                }
            } else if (f.isDirectory()) {// 如果是文件夹则需要递归
                scanDir(fileName, f);
            }

        }
    }
}
