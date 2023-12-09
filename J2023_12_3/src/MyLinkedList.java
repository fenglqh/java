import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    // 2、无头双向链表实现
    static class ListNode{
        private int val;
        private ListNode prev;//前驱
        private ListNode next;//后继
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode() {

        }
    }


    private ListNode head;
    private ListNode prev;
    private ListNode next;

    public MyLinkedList(int val){
        head = new ListNode(val);
    }

    public MyLinkedList() {

    }
    //头插法
    public void addFirst(int data){
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    };

    //找到尾巴节点
    private ListNode findLastNode() {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    //尾插法
    public void addLast(int data){
        ListNode newNode = new ListNode(data);
        ListNode lastNode = findLastNode();
        if (lastNode == null) {
            head = newNode;
            return;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    };



    //首先判断插入位置合法不合法
    public boolean addIndex(int index){
        if (index < 0 || index > size()) {
            return false;
        }
        return true;
    };

    //任意位置插入,第一个数据节点为0号下标
    public void add(int index , int data) {
        if (!addIndex(index)) {
            return;
        }

        ListNode newNode = new ListNode(data);
        ListNode cur = head;

        //从头插
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        //从中间插
        while (index> 0) {
            index--;
            cur = cur.next;
            //从尾插,关键点尾插怎么走
            if(cur.next == null && index>0) {
                cur.next = newNode;
                newNode.prev = cur;
                return;
            }
        }

        cur.prev.next = newNode;
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev = newNode;

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
    };

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (head == null) {
            return;
        }
        //删除头节点单独处理
        if (head.val == key) {
            if (head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
            return;
        }

        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                //尾结点单独处理
                if (cur.next == null) {
                    cur.prev.next = null;
                    return;
                }
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }

    };

    //删除所有值为key的节点
    public void removeAllKey(int key) {

        if (head == null) {
            return;
        }

        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                //尾结点单独处理
                if (cur.next == null) {
                    cur.prev.next = null;
                    break;
                }
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

            }
            cur = cur.next;
        }
        //删除头节点单独处理
        if (head.val == key) {
            if (head.next != null) {
                head.next.prev = null;
            }
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
    };

    //打印
    public void display(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    };

    //从指定位置打印
    public void display(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " " );
            cur = cur.next;
        }
        System.out.println();
    }


    //清空列表，当一个节点不被引用的时候就会自动被回收
    public void clear(){
        ListNode cur = head;
        ListNode curNode = cur;
        while (curNode != null) {
            curNode = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNode;
        }
        head = null;
    };

}
