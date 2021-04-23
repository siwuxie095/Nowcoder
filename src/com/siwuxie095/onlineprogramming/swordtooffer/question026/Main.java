package com.siwuxie095.onlineprogramming.swordtooffer.question026;

/**
 * @author Jiajing Li
 * @date 2021-04-21 14:02:24
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);

        node1.left = node2;
        node1.right = node3;

        Solution solution = new Solution();
        TreeNode node = solution.Convert(node1);
        System.out.println();
    }

}
