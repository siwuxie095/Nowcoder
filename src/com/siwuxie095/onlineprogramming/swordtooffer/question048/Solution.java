package com.siwuxie095.onlineprogramming.swordtooffer.question048;

/**
 * JZ48 不用加减乘法做加法
 *
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 +、-、*、/ 四则运算符号。
 *
 *
 * 示例1
 *
 * 输入
 * 1,2
 *
 * 返回值
 * 3
 *
 * @author Jiajing Li
 * @date 2021-05-13 19:28:44
 */
@SuppressWarnings("all")
public class Solution {

    public int Add(int num1, int num2) {
        int result = 0;
        int carry = 0;
        do {
            // 不带进位的加法
            result = num1 ^ num2;
            // 进位
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
            // 进位不为 0 则继续执行加法处理进位
        } while (carry != 0);
        return result;
    }

}
