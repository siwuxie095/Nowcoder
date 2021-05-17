package com.siwuxie095.onlineprogramming.swordtooffer.question055;

/**
 * @author Jiajing Li
 * @date 2021-05-17 10:26:15
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Solution solution = new Solution();
        ListNode node = solution.EntryNodeOfLoop(node1);
        System.out.println();
    }

}
