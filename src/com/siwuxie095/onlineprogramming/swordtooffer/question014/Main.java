package com.siwuxie095.onlineprogramming.swordtooffer.question014;

/**
 * @author Jiajing Li
 * @date 2021-04-08 13:34:33
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution solution = new Solution();
        ListNode res = null;
        res = solution.FindKthToTail(node1, 1);
        res = solution.FindKthToTail(node1, 2);
        res = solution.FindKthToTail(node1, 3);
        res = solution.FindKthToTail(node1, 4);
        res = solution.FindKthToTail(node1, 5);
        res = solution.FindKthToTail(node1, 6);
    }

}
