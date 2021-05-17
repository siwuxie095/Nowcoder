package com.siwuxie095.onlineprogramming.swordtooffer.question056;

/**
 * @author Jiajing Li
 * @date 2021-05-17 13:53:34
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3_1 = new ListNode(3);
        ListNode node3_2 = new ListNode(3);
        ListNode node4_1 = new ListNode(4);
        ListNode node4_2 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3_1;
        node3_1.next = node3_2;
        node3_2.next = node4_1;
        node4_1.next = node4_2;
        node4_2.next = node5;

        Solution solution = new Solution();
        ListNode node = solution.deleteDuplication(node1);
        System.out.println();

        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(1);
        ListNode node1_3 = new ListNode(1);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node = solution.deleteDuplication(node1_1);
        System.out.println();
    }

}
