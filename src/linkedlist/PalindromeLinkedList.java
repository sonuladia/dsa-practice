package linkedlist;

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while(p2 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();

        // Test case: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = pll.isPalindrome(head);
        System.out.println("Is Palindrome? " + result);  // Expected: true
    }
}
