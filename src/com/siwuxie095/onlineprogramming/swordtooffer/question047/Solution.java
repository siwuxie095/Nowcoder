package com.siwuxie095.onlineprogramming.swordtooffer.question047;

/**
 * JZ47 求 1+2+3+...+n
 *
 * 题目描述
 * 求 1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字
 * 及条件判断语句（A?B:C）。
 *
 *
 * 示例1
 *
 * 输入
 * 5
 *
 * 返回值
 * 15
 *
 * @author Jiajing Li
 * @date 2021-05-12 19:47:58
 */
@SuppressWarnings("all")
public class Solution {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean x = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }

}
