package com.siwuxie095.onlineprogramming.swordtooffer.question010;

/**
 * JZ10 矩形覆盖
 *
 * 题目描述
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *
 * 比如 n=3 时，2*3 的矩形块有 3 种覆盖方法
 *
 *
 * 示例1
 *
 * 输入
 * 4
 *
 * 返回值
 * 5
 *
 * 公式：f(n) = f(n-1) + f(n-2)
 *
 * @author Jiajing Li
 * @date 2021-04-02 09:45:22
 */
@SuppressWarnings("all")
public class Solution {

    public int rectCover(int target) {
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
