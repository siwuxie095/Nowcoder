package com.siwuxie095.onlineprogramming.swordtooffer.question038;

/**
 * @author Jiajing Li
 * @date 2021-05-08 15:50:01
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node5.left = node7;

        Solution solution = new Solution();
        System.out.println(solution.TreeDepth(node1));
    }

}
