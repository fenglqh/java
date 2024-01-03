import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyBinaryTree {
    public static class TreeNode{
        private int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        public  TreeNode(){

        }
    }


    private TreeNode root;

    public void createTree(int val){

    }
    //方案一：遍历思维，不怎么好，因为没用到方法的返回值
    List<Integer> ret = new ArrayList<>();//关键点，必须是全局变量

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {

            return ret;
        }
        //System.out.print(root.val + " ");

        ret.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ret;
    }
    //方案二：
    public List<Integer> preorderTraversal2(TreeNode root) {
        return null;
    }


    //方案一：子问题思路， 左子树加右子树加1
    public int size(TreeNode root) {
//        int count = 0;
        if(root == null) {
//            return count;
            return 0;
        }

//        count++;
        int left = size(root.left);
//        count = count + left;

        int right = size(root.right);
//        count = count + right;

//        return count;
        return left + right + 1;
    }
    //方案二：遍历思路
    public int count = 0;
    public void size2(TreeNode root) {
        if (root == null) {
            return;
        }

        count++;
        size2(root.left);
        size2(root.left);

    }

    //获取叶子节点的个数
    //方案一，子问题思路  左子树叶子节点加右子树叶子节点
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }



        int left = getLeafNodeCount(root.left);
        int right = getLeafNodeCount(root.right);
        return left + right;
    }

    //方案二遍历
    public int count2;
    public void getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            count2++;
        }
        getLeafNodeCount2(root.left);
        getLeafNodeCount2(root.right);

    }


    //获取第k层节点的个数
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        int left = getKLevelNodeCount(root.left,k-1);
        int right = getKLevelNodeCount(root.right, k-1);
        return left + right;
    }

    //获取二叉树的高度 左子树的高度和右子树的高度的最大值+1
    public int getHeight(TreeNode root){
        if(root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int ret = left > right ? left : right;
        return ret + 1;

    }

    //判断二叉树中有没有val值   用前序遍历 根节点，左子树，右子树
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftTree = find(root.left,val);
        if (leftTree != null) {
            return leftTree;
        }
        TreeNode rightTree = find(root.right,val);
        if (rightTree != null) {
            return rightTree;
        }
        return null;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }


//        boolean ret1 = isSameTree(p.left,q.left);
//        if(!ret1) {
//            return false;
//        }
//        boolean ret2 = isSameTree(p.right, q.right);
//        if (!ret2) {
//            return false;
//        }
        return isSameTree(p.left,q.left) && isSameTree(p.right ,q.right);
    }

    //翻转二叉树 根节点不动，左右孩子交换，根节点为空终止
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return  null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    //辰序遍历
    public void levelOrder(TreeNode root) {
        ///

        if (root == null) {
            return;
        }

        Queue<TreeNode> ret = new LinkedList<>();
        TreeNode cur = root;
        ret.offer(cur);
        while (!ret.isEmpty()) {

            cur = ret.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) ret.add(cur.left);
            if(cur.right != null) ret.add(cur.right);

        }
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> list1 = new ArrayList<>();
        Queue<TreeNode> ret = new LinkedList<>();
        TreeNode cur = root;
        ret.offer(cur);
        int size = 1;
        while (!ret.isEmpty()) {
            int size2 = 0;
            List<Integer> list2 = new ArrayList<>();
            while (size > 0) {
                cur = ret.poll();
                list2.add(cur.val);
                size--;
                System.out.print(cur.val + " ");
                if (cur.left != null) {ret.offer(cur.left);
                size2++;}
                if (cur.right != null) ret.add(cur.right);
                size2++;
            }
            size = size2;
            list1.add(list2);
        }
        return list1;
    }

// 变种题，输出一棵树的左视图
}
