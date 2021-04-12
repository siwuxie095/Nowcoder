package com.siwuxie095.onlineprogramming.swordtooffer.question019;

import java.util.ArrayList;

/**
 * JZ19 顺时针打印矩阵
 *
 * 题目描述
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下 4 X 4 矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 *
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *
 * 示例1
 *
 * 输入
 * [[1,2],[3,4]]
 *
 * 返回值
 * [1,2,4,3]
 *
 * @author Jiajing Li
 * @date 2021-04-12 10:05:58
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (null == matrix) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int row = 0;
        int col = 0;
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;
        while (true) {
            if (!right && !down && !left && !up) {
                break;
            }
            if (right) {
                if (col >= minCol && col <= maxCol) {
                    res.add(matrix[row][col]);
                    if (col == maxCol) {
                        minRow = row + 1;
                        row++;
                        right = false;
                        down = true;
                    } else {
                        col++;
                    }
                } else {
                    right = false;
                }
            }
            if (down) {
                if (row >= minRow && row <= maxRow) {
                    res.add(matrix[row][col]);
                    if (row == maxRow) {
                        maxCol = col - 1;
                        col--;
                        down = false;
                        left = true;
                    } else {
                        row++;
                    }
                } else {
                    down = false;
                }
            }
            if (left) {
                if (col >= minCol && col <= maxCol) {
                    res.add(matrix[row][col]);
                    if (col == minCol) {
                        maxRow = row - 1;
                        row--;
                        left = false;
                        up = true;
                    } else {
                        col--;
                    }
                } else {
                    left = false;
                }
            }
            if (up) {
                if (row >= minRow && row <= maxRow) {
                    res.add(matrix[row][col]);
                    if (row == minRow) {
                        minCol = col + 1;
                        col++;
                        up = false;
                        right = true;
                    } else {
                        row--;
                    }
                } else {
                    up = false;
                }
            }
        }
        return res;
    }

}
