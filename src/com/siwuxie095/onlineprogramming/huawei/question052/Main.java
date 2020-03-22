package com.siwuxie095.onlineprogramming.huawei.question052;

import java.util.Scanner;

/**
 * 计算字符串的距离
 *
 * 题目描述
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由
 * 俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
 * Ex：
 * 字符串A:abcdefg
 * 字符串B: abcdef
 * 通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个
 * 字符串的距离。
 *
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 得到计算结果
 *
 *
 * 示例1
 * 输入
 * abcdefg
 * abcdef
 *
 * 输出
 * 1
 *
 * @author Jiajing Li
 * @date 2020-03-22 18:15:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            System.out.println(minCost(str1, str2,1,1,1));
        }
    }

    /**
     * @param str1 first string
     * @param str2 second string
     * @param ic insert-cost
     * @param dc delete-cost
     * @param rc replace-cost
     * @return min-cost
     */
    private static int minCost(String str1, String str2, int ic, int dc, int rc) {
        if (null == str1 || null == str2) {
            return 0;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int row = charArr1.length + 1;
        int col = charArr2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; ++i) {
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < col; ++j) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }

}
