package leetcodeblind75;

public class DeleteMiddleNodeOFList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        if (prev == null)
            head = head.next;
        else {
            prev.next = curr.next;
            curr.next = null;
        }
        return head;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // MAIN to test
    public static void main(String[] args) {
        DeleteMiddleNodeOFList obj = new DeleteMiddleNodeOFList();

        // Build sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head);

        head = obj.deleteMiddle(head);

        System.out.print("After deleting middle: ");
        printList(head);
    }
}
