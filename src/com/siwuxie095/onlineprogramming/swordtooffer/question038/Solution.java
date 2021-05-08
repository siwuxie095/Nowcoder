package com.siwuxie095.onlineprogramming.swordtooffer.question038;

/**
 * JZ38 二叉树的深度
 *
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树
 * 的一条路径，最长路径的长度为树的深度。
 *
 *
 * 示例1
 *
 * 输入
 * {1,2,3,4,5,#,6,#,#,7}
 *
 * 返回值
 * 4
 *
 * @author Jiajing Li
 * @date 2021-05-08 15:49:49
 */
@SuppressWarnings("all")
public class Solution {

    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(getDepth(root.left, 1), getDepth(root.right, 1));
    }

    private int getDepth(TreeNode node, int level) {
        if (null == node) {
            return level;
        }
        return Math.max(getDepth(node.left, level + 1), getDepth(node.right, level + 1));
    }

}
