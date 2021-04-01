package com.siwuxie095.onlineprogramming.swordtooffer.question009;

/**
 * JZ9 变态跳台阶（跳台阶扩展问题）
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *
 * 示例1
 *
 * 输入
 * 3
 *
 * 返回值
 * 4
 *
 * 推导：
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)
 * f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(1)
 *
 * 两式相减，得：
 * f(n) = 2 * f(n-1)
 *
 * 而：
 * f(1) = 1
 *
 * 所以：
 *
 * f(n) = 2 ^ (n - 1)
 *
 * @author Jiajing Li
 * @date 2021-04-01 10:07:53
 */
@SuppressWarnings("all")
public class Solution {

    public int jumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        return (int) Math.pow(2, target - 1);
    }

}
