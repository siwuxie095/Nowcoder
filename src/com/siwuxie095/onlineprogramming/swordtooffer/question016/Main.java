package com.siwuxie095.onlineprogramming.swordtooffer.question016;

/**
 * @author Jiajing Li
 * @date 2021-04-08 17:48:46
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

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node55 = new ListNode(5);

        node11.next = node22;
        node22.next = node33;
        node33.next = node44;
        node44.next = node55;

        Solution solution = new Solution();
        ListNode res = solution.Merge(node1, node11);
        System.out.println(res);
    }

}
