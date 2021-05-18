package com.siwuxie095.onlineprogramming.swordtooffer.question061;

/**
 * JZ61 序列化二叉树
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来
 * 的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是
 * 一个字符串，序列化时通过某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果 str，重构二叉树。
 *
 * 例如，我们可以把一个只有根节点为 1 的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 *
 *
 * 示例1
 *
 * 输入
 * {8,6,10,5,7,9,11}
 *
 * 返回值
 * {8,6,10,5,7,9,11}
 *
 * @author Jiajing Li
 * @date 2021-05-18 16:28:37
 */
@SuppressWarnings("all")
public class Solution {

    int index = -1;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            return root.val + "!" + Serialize(root.left) + "!" + Serialize(root.right);
        }
    }

    TreeNode Deserialize(String str) {
        String[] arr = str.split("!");
        index++;
        int len = arr.length;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!arr[index].equals("#")) {
            treeNode = new TreeNode(Integer.parseInt(arr[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }

}
