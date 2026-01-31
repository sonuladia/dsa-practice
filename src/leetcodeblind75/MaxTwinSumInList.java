package leetcodeblind75;

public class MaxTwinSumInList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        int maxTwinSum = Integer.MIN_VALUE;

        while (p2 != null) {
            int sum = p1.val + p2.val;
            maxTwinSum = Math.max(maxTwinSum, sum);
            p1 = p1.next;
            p2 = p2.next;
        }
        return maxTwinSum;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        MaxTwinSumInList solution = new MaxTwinSumInList();

        // Test 1: [1, 2, 3, 4]
        // Twin pairs: (1,4) = 5, (2,3) = 5 → answer = 5
        ListNode head = buildList(new int[]{1, 2, 3, 4});

        System.out.print("Input list: ");
        printList(head);

        int result = solution.pairSum(head);
        System.out.println("Max Twin Sum = " + result);

        // Test 2: [4, 2, 2, 3]
        // Twin pairs: (4,3)=7, (2,2)=4 → answer = 7
        ListNode head2 = buildList(new int[]{4, 2, 2, 3});
        System.out.print("\nInput list: ");
        printList(head2);

        System.out.println("Max Twin Sum = " + solution.pairSum(head2));
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
