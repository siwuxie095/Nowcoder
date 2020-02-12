package com.siwuxie095.onlineprogramming.huawei.question035;

import java.util.Scanner;

/**
 * 蛇形矩阵
 *
 * 题目描述
 * 题目说明
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 样例输入
 * 5
 *
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * 接口说明
 * 原型
 * void GetResult(int Num, char * pResult);
 * 输入参数：
 *         int Num：输入的正整数N
 * 输出参数：
 *         int * pResult：指向存放蛇形矩阵的字符串指针
 *         指针指向的内存区域保证有效
 * 返回值：
 *         void
 *
 *
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 *
 *
 * 示例1
 *
 * 输入
 * 4
 *
 * 输出
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @author Jiajing Li
 * @date 2020-02-10 12:18:37
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[][] snakeArr = new int[num][num];
            int min = 1;
            int row = 0;
            int col = 0;
            while (row < num) {
                snakeArr[row][col] = min++;
                if (row == 0) {
                    row = col + 1;
                    col = 0;
                } else {
                    row--;
                    col++;
                }
            }
            for (int i = 0; i < snakeArr.length; i++) {
                for (int j = 0; j < snakeArr[0].length; j++) {
                    if (snakeArr[i][j] == 0) {
                        continue;
                    }
                    System.out.print(snakeArr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
