package com.siwuxie095.onlineprogramming.swordtooffer.question061;

/**
 * @author Jiajing Li
 * @date 2021-05-18 16:28:54
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Solution solution = new Solution();
        String str = solution.Serialize(node1);
        System.out.println(str);
        TreeNode node = solution.Deserialize(str);
        System.out.println();
    }

}
