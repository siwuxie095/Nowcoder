package com.siwuxie095.onlineprogramming.swordtooffer.question059;

import java.util.ArrayList;

/**
 * JZ59 按之字形顺序打印二叉树
 *
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *
 * 示例1
 *
 * 输入
 * {8,6,10,5,7,9,11}
 *
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 *
 * @author Jiajing Li
 * @date 2021-05-17 18:02:32
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
        if (level % 2 == 1) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        level(node.left, level + 1, res);
        level(node.right, level + 1, res);
    }

}
