package com.siwuxie095.onlineprogramming.swordtooffer.question022;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * JZ22 从上往下打印二叉树
 *
 * 题目描述
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 * 示例1
 *
 * 输入
 * {5,4,#,3,#,2,#,1}
 *
 * 返回值
 * [5,4,3,2,1]
 *
 * @author Jiajing Li
 * @date 2021-04-13 19:37:54
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (true) {
            if (deque.isEmpty()) {
                break;
            }
            TreeNode node = deque.pollFirst();
            res.add(node.val);
            if (null != node.left) {
                deque.add(node.left);
            }
            if (null != node.right) {
                deque.add(node.right);
            }
        }
        return res;
    }

}
