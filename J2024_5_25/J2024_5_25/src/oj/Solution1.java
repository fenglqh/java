package oj;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
   int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution1 {
    public static void main(String[] args) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((ListNode o1, ListNode o2) -> {
            return (o1.val - o2.val);
        });
        
        ListNode[] c = new ListNode[10];
        pq.isEmpty();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);

    }
    public static void reorderList(ListNode ret1) {
        //  1. 找到链表的中间节点
        ListNode midNode = findMidListNode(ret1);
        // 2. 将链表的后面部分进行逆序
        ListNode tail = reverse(midNode);
        if (tail == midNode) return;
        // 3. 合并两个链表
        ListNode head = ret1.next, ret = ret1;
        while(head != null && tail != null) {
            ret.next = tail;
            tail = tail.next;
            ret = ret.next;

            ret.next = head;
            head = head.next;
            ret = ret.next;

//  处理两个指针指向同一个节点的情况
            if (head == tail) {
                tail = tail.next;
            }

        }
        while(head != null) {
            ret.next = head;
            head = head.next;
            ret = ret.next;
        }
//         while(tail != null) {
//             ret.next = tail;
//             tail = tail.next;
//             ret = ret.next;
//         }

    }
    private static ListNode findMidListNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode midNode) {
        ListNode prev = midNode, cur = prev.next, nnext = null;
        while(cur != null) {
            nnext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nnext;
        }
        midNode.next = null;

        return prev;
    }
}

