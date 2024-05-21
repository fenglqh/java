package oj;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Test1 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = head.next, slow = head, fast = null,prev = new ListNode();
        while(slow != null) {
            fast = slow.next;
            if (fast ==  null) break;
            prev.next = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            prev = fast;
        }
        return ret;
    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // 定义一个虚拟头节点
        ListNode ret = new ListNode(0);
        ListNode ret1 = ret;
        // 1. 反转链表

        ListNode tail1 = head1.next;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        ListNode prev1 = head1, cur1 = prev1.next, nnext1 = null;
        prev1.next = null;
        while (cur1 != null) {
            nnext1 = cur1.next;
            cur1.next = prev1;
            prev1 = cur1;
            cur1 = nnext1;
        }

        ListNode tail2 = head2.next;
        while (tail2.next != null) {
            tail1 = tail2.next;
        }
        ListNode prev2 = head2, cur2 = prev2.next, nnext2 = null;
        prev2.next = null;
        while (cur2 != null) {
            nnext2 = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = nnext2;
        }
        // 2. 进行计算和
        int carray = 0, sum = 0;
        while (tail1 != null && tail2 != null) {
            sum = tail1.val + tail2.val + carray;
            carray = 0;
            if (sum > 9) {
                carray = sum / 10;
            }
            tail1 = tail1.next;
            tail2 = tail2.next;
            ret.next = new ListNode(sum % 10);
            ret = ret.next;
        }
        while (tail1 != null) {
            sum = tail1.val + carray;
            tail1 = tail1.next;
            carray = 0;
            if (sum > 9) {
                carray = sum / 10;
            }
            ret.next = new ListNode(sum % 10);
            ret = ret.next;

        }
        while (tail2 != null) {
            sum = tail2.val + carray;
            tail2 = tail2.next;
            carray = 0;
            if (sum > 9) {
                carray = sum / 10;
            }
            ret.next = new ListNode(sum % 10);
            ret = ret.next;

        }
        if (carray != 0) {
            ret.next = new ListNode(carray);
        }

        ListNode tail3 = ret;
        ret1 = null;


        ListNode prev3 = ret.next, cur3 = prev3.next, nnext3 = null;
        prev3.next = null;
        while (cur3 != null) {
            nnext3 = cur3.next;
            cur3.next = prev3;
            prev3 = cur3;
            cur3 = nnext3;
        }

        return tail3;
    }
    public static void main(String[] args) {

    }
}
