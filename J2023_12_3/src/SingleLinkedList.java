import java.util.LinkedList;
import java.util.Queue;

// 1、无头单向非循环链表实现
public class SingleLinkedList {

    static  class  ListNode {
        public int val;//值域
        public ListNode next;//后继
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode() {

        }
    }

    public ListNode head;

    public SingleLinkedList() {

    }

    //头插法
    public void addFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }
    //尾插法
    public void addLast(int data){
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        //找到尾巴节点
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }
    //任意位置插入,第一个数据节点为0号下标,判断下标合不合法
    public boolean addIndex(int index){
        return index >= 0 && index <= size();
    }
    //任意位置插入,第一个数据节点为0号下标
    public void add(int index,int data){
        if (!addIndex(index)) {
            throw new IndexOutOfBoundException("下标非法！");
        }
        ListNode newNode = new ListNode(data);
        //从头插
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        //从中间插
        ListNode cur = head;
        while (index - 1 > 0){
            cur = cur.next;
            index--;
        }
//        if(cur.next == null) {
//            cur.next = newNode;
//        }
        if(cur.next != null) {
            newNode.next = cur.next;
        }
        //尾插法
        cur.next = newNode;

    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){

        if(head == null) {
            return;
        }

        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode cur = head;
        ListNode curNext = cur.next;
        while (curNext != null) {
            if (curNext.val == key) {
                cur.next = curNext.next;
                return;
            }
            cur = cur.next;
            curNext = curNext.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (head == null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        if (head.val == key) {
            head = head.next;
        }

    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "　");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){
        this.head = null;
    }

//    输出链表中的倒数第k个节点
    public ListNode FindKthToTail(int k) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode curNext = cur;
        if (k == 0) {
            return null;
        }

        while (k - 1 > 0) {
            if (curNext.next == null) {
                return null;
            }
            curNext = curNext.next;
            k--;
        }

        while (curNext.next != null) {
            curNext = curNext.next;
            cur = cur.next;
        }
        return cur;
    }

    //找链表的中间节点
    public ListNode middleNode() {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //反转链表
    public ListNode reverseList() {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode curNext = cur;
        while (curNext != null) {
            curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;

        }
        return head;
    }
    //判断是不是回文
//    public boolean chkPalindrome() {
//        if (head == null) {
//            return false;
//        }
//        // write code here
//        ListNode prev = head;
//        ListNode cur = head;
//
//        int len = size()/2;
//        //找中间节点
//        while (len > 0) {
//            cur = cur.next;
//            len--;
//        }
//        ListNode mid = cur;
//        ListNode curNext = cur.next;
//        //头插
//        while (curNext != null) {
//            cur = curNext;
//            curNext = curNext.next;
//            cur.next = mid;
//            mid = mid.next;
//        }
//        //
//        while (prev != cur && prev.next != cur) {
//            if (prev.val != cur.val) {
//                return false;
//            }
//            prev = prev.next;
//            cur = cur.next;
//        }
//        if (prev.val != cur.val) {
//            return false;
//        }
//        return true;
//
//
//
//    }

//判断是不是回文
    public boolean chkPalindrome() {
        if (head == null) {
            return false;
        }
    //找到要逆转的中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //挨个进行头插
        ListNode cur = slow.next;
        ListNode curNext = cur;
        while (curNext != null) {
            curNext = curNext.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;

        }
        //进行比较

        while (head != slow && head.next != slow ) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }




}