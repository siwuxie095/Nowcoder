package com.siwuxie095.onlineprogramming.swordtooffer.question001;

/**
 * JZ1 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例1
 *
 * 输入
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-03-16 14:30:43
 */
@SuppressWarnings("all")
public class Other {

    public boolean Find(int target, int [][] array) {
        int rowLen = array.length;
        int colLen = array[0].length;
        boolean[][] visit = new boolean[rowLen][colLen];
        return find(target, array, visit, 0, colLen - 1, rowLen, colLen);
    }

    private boolean find(int target, int[][] array, boolean[][] visit, int rowIdx, int colIdx, int rowLen, int colLen) {
        if (rowIdx < 0 || rowIdx >= rowLen || colIdx < 0 || colIdx >= colLen) {
            return false;
        }
        if (visit[rowIdx][colIdx]) {
            return false;
        }
        if (target == array[rowIdx][colIdx]) {
            return true;
        } else if (target < array[rowIdx][colIdx]) {
            mark(visit, rowIdx, colIdx, rowLen, colLen, true);
            boolean res = find(target, array, visit, rowIdx - 1, colIdx, rowLen, colLen);
            if (res) {
                return true;
            } else {
                return find(target, array, visit, rowIdx, colIdx - 1, rowLen, colLen);
            }
        } else if (target > array[rowIdx][colIdx]) {
            mark(visit, rowIdx, colIdx, rowLen, colLen, false);
            boolean res = find(target, array, visit, rowIdx + 1, colIdx, rowLen, colLen);
            if (res) {
                return true;
            } else {
                return find(target, array, visit, rowIdx, colIdx + 1, rowLen, colLen);
            }
        }
        return false;
    }

    private static void mark(boolean[][] visit, int rowIdx, int colIdx, int rowLen, int colLen, boolean flag) {
        int i = rowIdx;
        int j = colIdx;
        if (flag) {
            while (i < rowLen) {
                visit[i][colIdx] = true;
                i++;
            }
            while (j < colLen) {
                visit[rowIdx][j] = true;
                j++;
            }
        } else {
            while (i >= 0) {
                visit[i][colIdx] = true;
                i--;
            }
            while (j >= 0) {
                visit[rowIdx][j] = true;
                j--;
            }
        }
    }

}
