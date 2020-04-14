package com.siwuxie095.onlineprogramming.huawei.question069;

import java.util.Scanner;

/**
 * 矩阵乘法
 *
 * 题目描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。
 *
 *
 * 输入描述:
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 输出描述:
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 *
 *
 * 示例1
 *
 * 输入
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 *
 * 输出
 * 14 13
 * 10 11
 *
 * @author Jiajing Li
 * @date 2020-04-14 19:45:08
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] first = new int[x][y];
            int[][] second = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    first[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    second[i][j] = scanner.nextInt();
                }
            }
            int[][] target = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++) {
                        target[i][j] += first[i][k] * second[k][j];
                    }
                }
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    res.append(target[i][j]);
                    res.append(" ");
                }
                res = new StringBuilder(res.toString().trim());
                res.append("\n");
            }
            System.out.print(res);
        }
    }

}