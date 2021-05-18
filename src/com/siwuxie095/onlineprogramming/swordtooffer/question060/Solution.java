package com.siwuxie095.onlineprogramming.swordtooffer.question060;

import java.util.ArrayList;

/**
 * JZ60 把二叉树打印成多行
 *
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 *
 * 示例1
 *
 * 输入
 * {8,6,10,5,7,9,11}
 *
 * 返回值
 * [[8],[6,10],[5,7,9,11]]
 *
 * @author Jiajing Li
 * @date 2021-05-18 16:10:42
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == pRoot) {
            return res;
        }
        level(pRoot, 1, res);
        return res;
    }

    private void level(TreeNode node, int level, ArrayList<ArrayList<Integer>> res) {
        if (null == node) {
            return;
        }
        ArrayList<Integer> list;
        if (res.size() >= level) {
            list = res.get(level - 1);
        } else {
            list = new ArrayList<>();
            res.add(list);
        }
        list.add(node.val);
        level(node.left, level + 1, res);
        level(node.right, level + 1, res);
    }

}
