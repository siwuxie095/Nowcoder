package com.siwuxie095.onlineprogramming.swordtooffer.question023;

/**
 * JZ23 二叉搜索树的后序遍历序列
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true,否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 *
 *
 * 示例1
 *
 * 输入
 * [4,8,6,12,16,14,10]
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-04-14 10:33:50
 */
@SuppressWarnings("all")
public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (null == sequence || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        return verify(sequence, 0, length - 1);
    }

    private boolean verify(int[] sequence, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0 || startIndex > endIndex || startIndex == endIndex) {
            return true;
        }
        int root = sequence[endIndex];
        int midIndex = findMiddleIndex(sequence, startIndex, endIndex - 1, root);
        if (midIndex == Integer.MIN_VALUE) {
            return verify(sequence, startIndex, endIndex - 1);
        } else {
            for (int i = midIndex + 1; i <= endIndex - 1; i++) {
                int value = sequence[i];
                if (value < root) {
                    return false;
                }
            }
            return verify(sequence, startIndex, midIndex) && verify(sequence, midIndex + 1, endIndex - 1);
        }
    }

    private int findMiddleIndex(int[] sequence, int startIndex, int endIndex, int root) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (sequence[i] > root) {
                return i - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

}
