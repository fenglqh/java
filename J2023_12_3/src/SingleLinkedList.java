// 1、无头单向非循环链表实现
public class SingleLinkedList {

    static  class  ListNode {
        private int val;//值域
        private ListNode next;//后继
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode() {

        }
    }

    private ListNode head;

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
    public void addIndex(int index,int data){
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

}