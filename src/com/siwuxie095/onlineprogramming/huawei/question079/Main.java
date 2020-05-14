package com.siwuxie095.onlineprogramming.huawei.question079;

import java.util.Scanner;

/**
 * 计算字符串的相似度
 *
 * 题目描述
 * 对于不同的字符串，我们希望能有办法判断相似程度，我们定义了一套操作方法来把两个不相同的字符串变得相同，
 * 具体的操作方法如下：
 *
 * 1 修改一个字符，如把“a”替换为“b”。
 *
 * 2 增加一个字符，如把“abdd”变为“aebdd”。
 *
 * 3 删除一个字符，如把“travelling”变为“traveling”。
 *
 * 比如，对于“abcdefg”和“abcdef”两个字符串来说，我们认为可以通过增加和减少一个“g”的方式来达到目的。
 * 上面的两种方案，都只需要一次操作。把这个操作所需要的次数定义为两个字符串的距离，而相似度等于“距离＋1”
 * 的倒数。也就是说，“abcdefg”和“abcdef”的距离为1，相似度为1/2=0.5.
 *
 * 给定任意两个字符串，你是否能写出一个算法来计算出它们的相似度呢？
 *
 *
 * 请实现如下接口
 *  功能：计算字符串的相似度
 *  输入：pucAExpression/ pucBExpression：字符串格式，如: "abcdef"
 *  返回：字符串的相似度,相似度等于“距离＋1”的倒数,结果请用1/字符串的形式,如1/2
 *
 * 约束：
 * 1、PucAExpression/ PucBExpression字符串中的有效字符包括26个小写字母。
 * 2、PucAExpression/ PucBExpression算术表达式的有效性由调用者保证;
 * 3、超过result范围导致信息无法正确表达的，返回null。
 *
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出相似度，string类型
 *
 *
 * 示例1
 *
 * 输入
 * abcdef
 * abcdefg
 *
 * 输出
 * 1/2
 *
 * @author Jiajing Li
 * @date 2020-05-14 10:30:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int cost = minCost(str1, str2,1,1,1);
            System.out.println("1/" + (1 + cost));
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
