package oj;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution5 {
    public static void main(String[] args) {
        List<Integer> r = new ArrayList<>();
        r.add(1);
        boolean f = true;
        f = !f;
        System.out.println(f);
        r.add(2);
        r.add(3);
        r.add(4);
        int i = 0, j = r.size()-1;
        while (i++ < j--) {
            Integer t = r.get(i);
            r.set(i,r.get(j));
            r.set(j,t);
        }
        System.out.println(r.toString());


    }
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 1;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = null;
        while (!queue.isEmpty()) {
            tmp = new ArrayList<>();
            int t = 0;
            while (count-- > 0) {
                Node d = queue.poll();
                tmp.add(d.val);
                t += d.children.size();
                for (Node x : d.children) {
                    queue.offer(x);
                }
            }
            ret.add(tmp);
            count = t;
        }
        return ret;
    }
}
