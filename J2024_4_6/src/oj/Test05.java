package oj;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1. 读入数据
        int n = in.nextInt(), q = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n+1; i++) arr[i] = in.nextInt() + arr[i-1];
        // 2. 数组

        while(q > 0) {
            int left = in.nextInt();
            int right = in.nextInt();
            System.out.println(arr[right] - arr[left - 1]);
            q--;
        }

    }
}
