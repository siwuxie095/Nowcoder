package com.siwuxie095.onlineprogramming.swordtooffer.question039;

/**
 * JZ39 平衡二叉树
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。在这里，我们只需要考虑其平衡性，
 * 不需要考虑其是不是排序二叉树
 *
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右
 * 两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *
 *
 * 示例1
 *
 * 输入
 * {1,2,3,4,5,6,7}
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-05-08 16:19:57
 */
@SuppressWarnings("all")
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (null == node) {
            return true;
        }
        return Math.abs(getLevel(node.left, 1) - getLevel(node.right, 1)) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    private int getLevel(TreeNode node, int level) {
        if (null == node) {
            return level;
        }
        return Math.max(getLevel(node.left, level + 1), getLevel(node.right, level + 1));
    }

}
