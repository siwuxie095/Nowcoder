package com.siwuxie095.onlineprogramming.swordtooffer.question008;

/**
 * JZ8 跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 公式：f(n) = f(n-1) + f(n-2)
 *
 * @author Jiajing Li
 * @date 2021-03-31 19:22:26
 */
@SuppressWarnings("all")
public class Solution {

    public int JumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

}
