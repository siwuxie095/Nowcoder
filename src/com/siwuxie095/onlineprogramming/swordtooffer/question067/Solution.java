package com.siwuxie095.onlineprogramming.swordtooffer.question067;

/**
 * JZ67 剪绳子
 *
 * 题目描述
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（m、n都是整数，n>1 并且 m>1，m<=n），
 * 每段绳子的长度记为 k[1],...,k[m]。请问 k[1]x...xk[m] 可能的最大乘积是多少？例如，当
 * 绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18。
 *
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述:
 * 输出答案。
 *
 *
 * 示例1
 *
 * 输入
 * 8
 *
 * 返回值
 * 18
 *
 * @author Jiajing Li
 * @date 2021-05-20 19:02:49
 */
@SuppressWarnings("all")
public class Solution {

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }

        if (target == 3) {
            return 2;
        }

        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i/2 ; j++) {
                max = Math.max(max, dp[j] * dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[target];
    }

}
