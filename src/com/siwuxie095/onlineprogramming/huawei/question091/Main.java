package com.siwuxie095.onlineprogramming.huawei.question091;

import java.util.Scanner;

/**
 * 201301 JAVA 题目2-3级
 *
 * 题目描述
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着
 * 各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往
 * 左和往上走。
 *
 * 输入描述:
 * 输入两个正整数
 *
 * 输出描述:
 * 返回结果
 *
 *
 * 示例1
 *
 * 输入
 * 2
 * 2
 *
 * 输出
 * 6
 *
 * @author Jiajing Li
 * @date 2020-05-19 10:28:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int col = scanner.nextInt();
            int row = scanner.nextInt();
            //// first method
            //int count = calculate(row, col);
            //System.out.println(count);
            // second method
            int count = dynamicProgramming(row, col);
            System.out.println(count);
        }
    }

    private static int dynamicProgramming(int row, int col) {
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= col; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[row][col];
    }

    private static int calculate(int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }
        return calculate(row - 1, col) + calculate(row, col - 1);
    }

}
