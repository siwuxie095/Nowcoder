package com.siwuxie095.onlineprogramming.swordtooffer.question007;

/**
 * JZ7 斐波那契数列
 *
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数 n，请你输出斐波那契数列的第 n 项（从 0 开始，第 0 项为 0，第 1 项是 1）。
 * n ≤ 39
 *
 *
 * 示例1
 *
 * 输入
 * 4
 *
 * 返回值
 * 3
 *
 * 公式：f(n) = f(n-1) + f(n-2)
 *
 * @author Jiajing Li
 * @date 2021-03-31 15:17:38
 */
@SuppressWarnings("all")
public class Solution {

    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

}
