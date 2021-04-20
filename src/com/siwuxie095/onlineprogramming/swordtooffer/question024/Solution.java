package com.siwuxie095.onlineprogramming.swordtooffer.question024;

import java.util.ArrayList;

/**
 * JZ24 二叉树中和为某一值的路径
 *
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 *
 * 示例1
 *
 * 输入
 * {10,5,12,4,7},22
 *
 * 返回值
 * [[10,5,7],[10,12]]
 *
 *
 * 示例2
 *
 * 输入
 * {10,5,12,4,7},15
 *
 * 返回值
 * []
 *
 * @author Jiajing Li
 * @date 2021-04-19 15:51:46
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        find(root, 0, target, null, res);
        return res;
    }

    private void find(TreeNode node, int acc, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (null == node) {
            return;
        }
        if (null == path) {
            path = new ArrayList<>();
        } else {
            path = copy(path);
        }
        acc += node.val;
        path.add(node.val);
        if (acc < target) {
            if (null != node.left) {
                find(node.left, acc, target, path, res);
            }
            if (null != node.right) {
                find(node.right, acc, target, path, res);
            }
        }
        if (acc == target && null == node.left && null == node.right) {
            res.add(path);
            path = null;
            return;
        }
        path.remove(path.size() - 1);
    }

    private ArrayList<Integer> copy(ArrayList<Integer> path) {
        return new ArrayList<>(path);
    }

}
