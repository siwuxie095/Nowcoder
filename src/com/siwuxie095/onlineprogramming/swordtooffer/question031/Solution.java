package com.siwuxie095.onlineprogramming.swordtooffer.question031;

/**
 * JZ31 整数中 1 出现的次数（从 1 到 n 整数中 1 出现的次数）
 *
 * 题目描述
 * 输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数
 * 例如，1~13 中包含 1 的数字有 1、10、11、12、13 因此共出现 6 次
 *
 *
 * 示例1
 *
 * 输入
 * 13
 *
 * 返回值
 * 6
 *
 * @author Jiajing Li
 * @date 2021-04-27 18:48:46
 */
@SuppressWarnings("all")
public class Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        // i 代表位数
        for(int i = 1; i <= n; i *= 10) {
            // 更高位数字
            int high = n / (i * 10);
            // 更低位数字
            int low = ( n % i);
            // 当前位数字
            int cur= (n / i) % 10;
            if (cur == 0) {
                count += high * i;
            } else if ( cur == 1) {
                count += high * i + (low + 1);
            } else {
                count += (high + 1) * i;
            }
        }
        return count;
    }

}
