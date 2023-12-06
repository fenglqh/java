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
    public int countNode = 0;
    public MySingelList(int val) {
        this.head = new ListNode();
        this.head.val = val;
        this.head.next = null;
        countNode++;
    }
    public MySingelList() {

    }

    //头插法
    public void addFirst(int data) {
        ListNode cur = new ListNode();
        cur.val = data;
        cur.next = head;
        head = cur;
        countNode++;
    }

    //尾插法
    public void addLast(int data) {
        ListNode cur = LastIndex();
        if (cur == null) {
            head = new ListNode();
            head.val = data;
            head.next = null;
            countNode++;
            return;
        }
        cur.next = new ListNode();
        cur.next.val = data;
        cur.next.next = null;
        countNode++;
    }

    //找到尾节点的地址
    private ListNode LastIndex() {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


    //找到任意位置的节点，第一个数据节点为0号下标
    private ListNode anyIndex(int index) throws IndexOfListOutException {
        if(index < 0 || index > countNode-1) {
            throw new IndexOfListOutException("索引非法！");
        };
        if (index == 0) {
            return head;
        }
        ListNode cur = head;
        while (index > 0 && cur.next != null) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(index < 0 || index > countNode - 1) {
            throw new IndexOfListOutException("索引非法！");
        };
        if (index == 0) {
            addFirst(data);
            return;
        }
        if(index == countNode - 1) {
            addLast(data);
            return;
        }
        ListNode cur = anyIndex(index - 1);
        ListNode curNext = cur.next;
        ListNode newNode = new ListNode();
        cur.next = newNode;
        newNode.next = curNext;
        newNode.val = data;

    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
       ListNode cur = head;
       while (cur != null) {
           if (cur.val == key ) {
               return true;
           }
           cur = cur.next;
       }
       return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
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
            curNext = curNext.next;
            cur = cur.next;
        }

    }

    //删除所有值为key的节点
    public void removeAllkey(int key) {
        if (head == null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
//                cur = cur.next;
            }else {
                prev = prev.next;
//                cur = cur.next;
            }
            cur = cur.next;
        }
        if (head.val == key) {
            head = head.next;
        }
    }

    //得到单链表的长度
    public int size() {

        return -1;
    }

    public void clear() {
        head = null;
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
//从指定位置打印单链表
    public void display(ListNode node) {
        ListNode cur = node;
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
//    用链表实现冒泡排序
    public void buddle_soft(ListNode node) {

    }

//
}
