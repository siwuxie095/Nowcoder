package com.siwuxie095.onlineprogramming.swordtooffer.question018;

/**
 * JZ18 二叉树的镜像
 *
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 比如：    源二叉树
 *             8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9 11
 *
 *         镜像二叉树
 *             8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7  5
 *
 *
 * 示例1
 *
 * 输入
 * {8,6,10,5,7,9,11}
 *
 * 返回值
 * {8,10,6,11,9,7,5}
 *
 * @author Jiajing Li
 * @date 2021-04-09 20:38:21
 */
@SuppressWarnings("all")
public class Solution {

    public TreeNode Mirror(TreeNode root) {
        if (null == root) {
            return null;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
