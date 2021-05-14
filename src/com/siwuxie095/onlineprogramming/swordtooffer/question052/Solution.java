package com.siwuxie095.onlineprogramming.swordtooffer.question052;

/**
 * JZ52 正则表达式匹配
 *
 * 题目描述
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，
 * 而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和
 * "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配
 *
 *
 * 示例1
 *
 * 输入
 * "aaa","a*a"
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-05-14 16:18:30
 */
@SuppressWarnings("all")
public class Solution {

    public boolean match (String str, String pattern) {
        int s = str.length();
        int p = pattern.length();
        // 00 用于存放两个空字符串的结果 dp[i][j] 表示模式串前 j 个是否与字符串前 i 个匹配
        boolean[][] dp = new boolean[s+1][p+1];
        // 实际上模式串和字符串的起点为 1 (所以后面的下标都是 i-1 j-1)
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= p; j++) {
                if (j == 0) {
                    // 只有字符串和模式串都为空的时候才匹配，当模式串为空，字符串不为空则返回 false
                    dp[i][j] = (i == 0);
                } else {
                    // 如果第 j-1 个字符不是 *
                    if (pattern.charAt(j - 1) != '*') {
                        if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                            // 正常匹配
                            dp[i][j] = dp[i-1][j-1];
                        }
                        //如果第 j 个是 * 那么分两种情况，有一种成立即可
                    } else {
                        /*
                         * case 1 可以直接忽略 * 前模式的那个元素（* 代表出现 0 次 比如 a* 这两个元素做空字符串）
                         * 那么 dp[i][j]==true 只需满足 dp[i][j-2]==true 即可
                         */
                        if (j >= 2) {
                            dp[i][j] = dp[i][j-2];
                        }
                        /*
                         * case 2 如果 dp[i][j-2] 不等于 true 那么要满足第 j-1 个字符(这个字符也可以为 ‘.’)与第 i 个字符匹配即可
                         * 下标多减 1 是因为 dp 是从 1 开始记录的
                         */
                        if (i > 0 && j >= 2 && (str.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.')) {
                            //使用或等于 两种情况有一种符合就行
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

}
