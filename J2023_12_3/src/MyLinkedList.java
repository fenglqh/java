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
        return true;
    };
    //删除第一次出现关键字为key的节点
    public void remove(int key){

    };
    //删除所有值为key的节点
    public void removeAllKey(int key){

    };
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
    public void display(){
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    };
    public void clear(){

    };

}
