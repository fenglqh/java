/**
 * 根据单链表的思想简单模拟实现一下单向非循环有头链表
 */

public class MySingelList {

    //链表是由一个个节点组成的
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode() {
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //头节点
    public ListNode head;

    public MySingelList(int val) {
        this.head = new ListNode();
        this.head.val = val;
        this.head.next = null;
    }
    public MySingelList() {

    }

    //头插法
    public void addFirst(int data) {
        ListNode cur = new ListNode();
        cur.val = data;
        cur.next = head;
        head = cur;
    }

    //尾插法
    public void addLast(int data) {

    }
    //任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index, int data) {

    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
        return true;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {

    }
    //删除所有值为key的节点
    public void removeAllkey(int key) {

    }

    //得到单链表的长度
    public int size() {
        return -1;
    }

    public void clear() {

    }



    //打印单链表
    public void display() {
        ListNode cur = head;
        if(cur == null) {
            System.out.println("null");
            return;
        }
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

}
