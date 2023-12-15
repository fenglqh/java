import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int count(SingleLinkedList.ListNode A) {
        int count = 0;
        SingleLinkedList.ListNode cur = A;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
//    判断两个链表是否相交
    public static SingleLinkedList.ListNode getIntersectionNode(SingleLinkedList.ListNode headA, SingleLinkedList.ListNode headB) {
        int lenl = count(headA);
        int lens = count(headB);
        if(lenl - lens < 0) {
            int temp = lenl;
            lenl = lens;
            lens = temp;

            SingleLinkedList.ListNode ret = null;
            ret = headA;
            headA = headB;
            headB = ret;
        }
        while(lenl - lens > 0) {
            headA = headA.next;
            lenl--;
        }
        while(headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        SingleLinkedList mySingleListA  = new SingleLinkedList();
        mySingleListA.addLast(2);
        mySingleListA.addLast(6);
        mySingleListA.addLast(4);
        SingleLinkedList mySingleListB  = new SingleLinkedList();
        mySingleListA.addLast(1);
        mySingleListA.addLast(5);
        getIntersectionNode(mySingleListA.head,mySingleListB.head);



    }

//现有一链表的头指针 ListNode* pHead，给一定值x，
// 编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    public static SingleLinkedList.ListNode partition(SingleLinkedList.ListNode pHead, int x) {
        // write code here
        SingleLinkedList.ListNode newNode1 = new SingleLinkedList.ListNode();
        SingleLinkedList.ListNode newNode2 = new SingleLinkedList.ListNode();

        SingleLinkedList.ListNode cur = pHead;
        SingleLinkedList.ListNode cur1 = newNode1;
        SingleLinkedList.ListNode cur2 = newNode2;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur2.next = null;
        cur1.next = newNode2.next;
        return newNode1.next;
    }









    public static void main6(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);


        myLinkedList.display();
        myLinkedList.removeAllKey(1);
        myLinkedList.display();
        boolean ret = myLinkedList.contains(1);
        System.out.println(ret);
    }
    public static void main5(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(0);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.display();
        myLinkedList.clear();
//        myLinkedList.add(3,5);
//        myLinkedList.add(1,6);
//        myLinkedList.add(2,7);
//        myLinkedList.add(3,8);
//        myLinkedList.add(4,9);

        myLinkedList.display();
        System.out.println(myLinkedList.size());
    }

    public static void main4(String[] args) {
        SingleLinkedList mySingleList  = new SingleLinkedList();
        mySingleList.addFirst(1);
        mySingleList.addFirst(2);
        mySingleList.addFirst(3);
        mySingleList.addFirst(4);

        mySingleList.addFirst(3);
        mySingleList.addFirst(2);
        mySingleList.addFirst(1);

        mySingleList.display();
        boolean t = mySingleList.chkPalindrome();
//        mySingleList.reverseList();
        System.out.println(t);

    }

    public static void main3(String[] args) {
        SingleLinkedList mySingleList  = new SingleLinkedList();
        mySingleList.addFirst(1);

        mySingleList.display();
        SingleLinkedList.ListNode ret = mySingleList.middleNode();
        System.out.println(ret.val);
    }

    public static void main2(String[] args) {
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
