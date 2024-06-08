package oj;

import javafx.util.Pair;

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
class TreeNode {
      int val;
      TreeNode left;
        TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Solution5 {
    public static void main(String[] args) {
////        new Map<>().put()
//        HashMap h = new HashMap();
//        Pair<Integer,Integer> pair = new Pair<>(0,0);
//        pair.getValue();
//        pair.getKey();
//        [1,3,2,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        System.out.println(widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(TreeNode root) {
        Pair<TreeNode, Integer>[] q = new Pair[3000];
        q[0] = new Pair<TreeNode, Integer>(root,1);
        int head = 0, tail = 1; // 标识数组的下标
        int ret = 1, c = 1;
        while (tail - head + 1 != 0) {
            int count = tail - head + 1;
            while (count-- > 0) {
                if (head > 3000) head = 0;
                TreeNode r = q[head++].getKey();
                c++;
                if (tail >= 3000) tail = 0;
                if (r.left != null) q[++tail] = new Pair<TreeNode, Integer>(r.left,c);
                if (r.right != null) q[++tail] = new Pair<TreeNode, Integer>(r.right,c);
            }
            ret = Math.max(ret, (Math.abs(q[tail].getValue() - q[head].getValue()) + 1));
        }
        return ret;
    }
    public static void main1(String[] args) {
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
