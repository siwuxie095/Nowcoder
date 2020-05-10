package com.siwuxie095.onlineprogramming.huawei.question075;

import java.util.Scanner;

/**
 * 公共子串计算
 *
 * 题目描述
 * 计算两个字符串的最大公共子串的长度，字符不区分大小写
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出一个整数
 *
 *
 * 示例1
 *
 * 输入
 * asdfas werasdfaswer
 *
 * 输出
 * 6
 *
 * 注意：最大公共子串和最大公共子序列的区别
 * （1）最大公共子串必须是连续的
 * （2）最大公共子序列可以是不连续的
 *
 * @author Jiajing Li
 * @date 2020-05-10 17:50:05
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next().toLowerCase();
            String str2 = scanner.next().toLowerCase();
            System.out.println(getLCS(str1, str2).length());
        }
    }

    public static String getLCS(String str1, String str2) {
        if (null == str1 || null == str2 || "".equals(str1) || "".equals(str2)) {
            return "";
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[][] dp = getDp(charArr1, charArr2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < charArr1.length; ++i) {
            for (int j = 0; j < charArr2.length; ++j) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    private static int[][] getDp(char[] charArr1, char[] charArr2) {
        int[][] dp = new int[charArr1.length][charArr2.length];
        for (int i = 0; i < charArr1.length; ++i) {
            if (charArr1[i] == charArr2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < charArr2.length; ++j) {
            if (charArr1[0] == charArr2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < charArr1.length; ++i) {
            for (int j = 1; j < charArr2.length; ++j) {
                if (charArr1[i] == charArr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

}
