import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class OJTest {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue b = new MyBlockingQueue();
        Thread t2 = new Thread(() -> {
            b.offer(1);
            b.offer(2);
            b.offer(3);
            b.offer(4);
            b.offer(5);
            b.offer(6);
        });
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("te");
            b.poll();
        });
        t.start();
        t2.start();
        System.out.println("test");



        t.join();
        t2.join();
//        b.offer(1);
//        b.offer(2);
//        b.offer(3);
//        b.offer(4);
//        b.poll();
        System.out.println("-----");

    }
    public static void main4(String[] args) {
        String s = "abc";
        List<String> strings = Arrays.asList(s);
        System.out.println(strings.get(0));
    }
    public static void main3(String[] args) {
//       int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
       int[] arr = {0,1,1,4,3};
        System.out.println(totalFruit(arr));
    }
    public static int totalFruit(int[] fruits) {
        // 思想不难，就是细节有点多
        HashMap<Integer,Integer> hp = new HashMap<>();
        int ret = 0;
        for(int left = 0, right = 0; left < fruits.length; left++) {
            // 1.进窗口
            while(hp.size() <= 2 && right < fruits.length) {
                if (hp.size() < 2 && !hp.containsKey(fruits[right])) {
                    hp.put(fruits[right],1);
                } else {
                    if(hp.containsKey(fruits[right])) {
                        hp.put(fruits[right], hp.get(fruits[right])+1);
                    } else {
                        break;
                    }
                }
                right++;
            }
            // 4.更新结果
            ret = Math.max(ret, right - left);
            if(right >= fruits.length) {
                break;
            }
            // 2.判断
            if(hp.get(fruits[left]) == 1) {
                hp.remove(fruits[left]);
//                right++;
            } else {
                hp.put(fruits[left], hp.get(fruits[left]) - 1);
            }

        }

        return ret;

    }
    public static void main2(String[] args) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        hp.put(1,2);
        hp.replace(1, hp.get(1)+1);
        System.out.println(hp);
        System.out.println(hp.containsKey(8));
//        hp.remove()

//        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
//        System.out.println(totalFruit(arr));
    }
    // 暴力枚举+hash表 会超时
    public static int totalFruit1(int[] fruits) {
        int len = 0;
        // 暴力枚举+hash表
        for(int left = 0; left < fruits.length; left++) {
            // 创建一个HashMap来放篮子的种类
            HashSet<Integer> h = new HashSet<>(3);
            int right = left;
            while(h.size() <= 2 && right < fruits.length) {
                if (!(h.contains(fruits[right]))) {
                    h.add(fruits[right]);
                } else {
                    right++;
                }
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
    public static void main1(String[] args) {
        HashMap h = new HashMap(2);
        h.put(1,3);
        h.put(2,3);
        System.out.println(h.size());
        HashSet h1 = new HashSet<>();
    }
}
