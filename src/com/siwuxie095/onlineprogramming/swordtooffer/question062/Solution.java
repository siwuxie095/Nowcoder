package com.siwuxie095.onlineprogramming.swordtooffer.question062;

import java.util.ArrayList;
import java.util.List;

/**
 * JZ62 二叉搜索树的第 K 个节点
 *
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第 k 小的 TreeNode 结点。
 *
 *
 * 示例1
 *
 * 输入
 * {5,3,7,2,4,6,8},3
 *
 * 返回值
 * {4}
 *
 * 说明
 * 按结点数值大小顺序第三小结点的值为 4
 *
 * @author Jiajing Li
 * @date 2021-05-18 19:14:01
 */
@SuppressWarnings("all")
public class Solution {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot || k < 1) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list);
        return k > list.size() ? null : list.get(k - 1);
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (null == node) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

}
