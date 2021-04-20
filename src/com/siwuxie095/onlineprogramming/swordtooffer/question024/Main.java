package com.siwuxie095.onlineprogramming.swordtooffer.question024;

/**
 * @author Jiajing Li
 * @date 2021-04-19 15:51:53
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        Solution solution = new Solution();
        System.out.println(solution.FindPath(node1, 22));
        System.out.println(solution.FindPath(node1, 15));
    }

}
