package linkList;

// 1、无头单向非循环链表实现
public class MySingleLinkList {
    //链表的节点
    class Node {
        //放值
        private int var;
        //放下一个节点的引用
        private Node next;

        public Node(int data) {
            this.var = data;
        }
        public Node() {

        }
    }

    //标识链表的头
    Node head = null;
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        //头节点为空
        if (this.head == null) {
            this.head = node;
            return;
        }
        //头节点不为空
        node.next = this.head;
        this.head = node;

    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        //头节点为空
        if (this.head == null) {
            this.head = node;
            return;
        }
        //头节点不为空
        //遍历找到尾节点
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){

        return false;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){}

    //删除所有值为key的节点
    public void removeAllKey(int key){}

    //得到单链表的长度
    public int size(){
        return -1;
    }
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.var + " ");
            cur = cur.next;
        }
    }

    public void clear(){}

}
