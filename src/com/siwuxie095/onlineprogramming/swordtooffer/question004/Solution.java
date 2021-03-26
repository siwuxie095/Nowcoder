package com.siwuxie095.onlineprogramming.swordtooffer.question004;

/**
 * JZ4 重建二叉树
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 *
 * 返回值
 * {1,2,5,3,4,6,7}
 *
 * 说明：本题目包含复杂数据结构 TreeNode，参考：https://blog.nowcoder.net/n/954373f213e14eeab0a69ed0e9ef1b6e
 *
 * @author Jiajing Li
 * @date 2021-03-19 17:47:17
 */
public class Solution {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStartIndex, int preEndIndex, int[] in, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
        }
        int rootValue = pre[preStartIndex];
        TreeNode rootNode = new TreeNode(rootValue);
        if (preEndIndex - preStartIndex == 0 || inEndIndex - inStartIndex == 0) {
            return rootNode;
        }
        int inSplitIndex = findIndex(in, rootValue);
        rootNode.left = reConstructBinaryTree(
                pre, preStartIndex + 1, preStartIndex + inSplitIndex - inStartIndex,
                in, inStartIndex, inSplitIndex - 1);
        rootNode.right = reConstructBinaryTree(
                pre, (preStartIndex + inSplitIndex - inStartIndex) + 1, preEndIndex,
                in, inSplitIndex + 1, inEndIndex);
        return rootNode;
    }

    private int findIndex(int[] in, int rootValue) {
        int i = 0;
        while (i < in.length) {
            if (in[i] == rootValue) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pre = new int[] {1,2,4,3,5,6};
        int[] in = new int[] {4,2,1,5,3,6};
        solution.reConstructBinaryTree(pre, in);
    }

}
