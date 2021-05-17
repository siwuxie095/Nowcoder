package com.siwuxie095.onlineprogramming.swordtooffer.question057;

/**
 * JZ57 二叉树的下一个结点
 *
 * 题目描述
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的 next 指针。
 *
 * @author Jiajing Li
 * @date 2021-05-17 15:12:37
 */
@SuppressWarnings("all")
public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 2.
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 3.
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

}
