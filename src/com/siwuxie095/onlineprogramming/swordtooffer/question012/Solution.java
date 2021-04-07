package com.siwuxie095.onlineprogramming.swordtooffer.question012;

/**
 * JZ12 数值的整数次方
 *
 * 题目描述
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。求 base 的 exponent 次方。
 *
 * 保证 base 和 exponent 不同时为 0
 *
 *
 * 示例1
 *
 * 输入
 * 2,3
 *
 * 返回值
 * 8.00000
 *
 * @author Jiajing Li
 * @date 2021-04-07 13:49:36
 */
@SuppressWarnings("all")
public class Solution {

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return calculate(base, exponent);
    }

    private double calculate(double base, int exponent) {
        if (exponent == 0) {
            return 1D;
        }
        double res = calculate(base, exponent / 2);
        // 奇数次幂，多乘一个 base
        if (exponent % 2 == 1) {
            return res * res * base;
        } else {
            return res * res;
        }
    }

}
