package com.siwuxie095.onlineprogramming.swordtooffer.question026;

import java.util.Deque;
import java.util.LinkedList;

/**
 * JZ26 二叉搜索树与双向链表
 *
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向。
 *
 * @author Jiajing Li
 * @date 2021-04-21 14:02:17
 */
@SuppressWarnings("all")
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        link(pRootOfTree, deque);
        TreeNode head = deque.pollFirst();
        TreeNode curr = head;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            curr.right = node;
            node.left = curr;
            curr = node;
        }
        return head;
    }

    private void link(TreeNode node, Deque<TreeNode> deque) {
        if (null == node) {
            return;
        }
        link(node.left, deque);
        deque.offerLast(node);
        link(node.right, deque);
    }

}
