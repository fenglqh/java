public class Main {

    public static void main(String[] args) {
        SingleLinkedList mySingleList  = new SingleLinkedList();
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(4);

        SingleLinkedList.ListNode ret = mySingleList.FindKthToTail(0);
        System.out.println(ret);
    }
    public SingleLinkedList.ListNode mergeTwoLists(SingleLinkedList.ListNode list1, SingleLinkedList.ListNode list2) {
        SingleLinkedList.ListNode newhead = new SingleLinkedList.ListNode(0);
        SingleLinkedList.ListNode cur = newhead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;

            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return newhead.next;
    }

    public static void main1(String[] args) {
        SingleLinkedList mySingleList  = new SingleLinkedList();
        mySingleList.addLast(2);
        mySingleList.addLast(2);

        mySingleList.display();




    }
}
