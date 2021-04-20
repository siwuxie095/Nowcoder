package com.siwuxie095.onlineprogramming.swordtooffer.question025;

/**
 * @author Jiajing Li
 * @date 2021-04-20 16:12:31
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;
        node1.random = node3;

        Solution solution = new Solution();
        RandomListNode node = solution.Clone(node1);
        System.out.println(node);
    }

}
