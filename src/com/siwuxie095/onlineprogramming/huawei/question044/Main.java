package com.siwuxie095.onlineprogramming.huawei.question044;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sudoku-Java
 *
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要
 * 根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一
 * 行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 *
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 *
 * 输入描述:
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 *
 * 输出描述:
 * 完整的9X9盘面数组
 *
 *
 * 示例1
 *
 * 输入
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 *
 * 输出
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 *
 * @author Jiajing Li
 * @date 2020-03-18 17:55:14
 */
public class Main {

    private static final int FULL_LEN = 9;

    private static final int PART_LEN = 3;

    private static final int ZERO_NUM = 0;

    private static final int MIN_NUM = 1;

    private static final int MAX_NUM = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[][] matrix = new int[FULL_LEN][FULL_LEN];
            for (int i = 0; i < FULL_LEN; i++) {
                for (int j = 0; j < FULL_LEN; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            restoreSudoku(matrix);
            printSudoku(matrix);
        }
    }

    private static boolean restoreSudoku(int[][] matrix) {
        for (int curRow = 0; curRow < FULL_LEN; curRow++) {
            for (int curCol = 0; curCol < FULL_LEN; curCol++) {
                if (matrix[curRow][curCol] == ZERO_NUM) {
                    for (int num = MIN_NUM; num <= MAX_NUM; num++) {
                        matrix[curRow][curCol] = num;
                        if (check(matrix, curRow, curCol) && restoreSudoku(matrix)) {
                            return true;
                        }
                        matrix[curRow][curCol] = ZERO_NUM;
                    }
                }
            }
        }
       return true;
    }

    private static boolean check(int[][] matrix, int row, int col) {
        // check in a row
        boolean rowCheck = checkRow(matrix, row, col);
        // check in a col
        boolean colCheck = checkCol(matrix, row, col);
        // check int a block: divided into nine blocks
        boolean blockCheck = checkBlock(matrix, row / 3 * 3, col / 3 * 3, row, col);

        return rowCheck && colCheck && blockCheck;
    }

    private static boolean checkRow(int[][] matrix, int row, int col) {
        for (int curCol = 0; curCol < FULL_LEN; curCol++) {
            if (curCol == col) {
                continue;
            }
            if (matrix[row][curCol] == matrix[row][col]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int[][] matrix, int row, int col) {
        for (int curRow = 0; curRow < FULL_LEN; curRow++) {
            if (curRow == row) {
                continue;
            }
            if (matrix[curRow][col] == matrix[row][col]) {
                return false;
            }
        }
        return true;
    }


    private static boolean checkBlock(int[][] matrix, int entryRow, int entryCol, int row, int col) {
        for (int curRow = entryRow; curRow < entryRow + PART_LEN; curRow++) {
            for (int curCol = entryCol; curCol < entryCol + PART_LEN; curCol++) {
                if (curRow == row && curCol == col) {
                    continue;
                }
                if (matrix[curRow][curCol] == matrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void printSudoku(int[][] matrix) {
        for (int i = 0; i < FULL_LEN; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[,\\[\\]]", ""));
        }
    }


}
