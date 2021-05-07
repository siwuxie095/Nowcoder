package com.siwuxie095.onlineprogramming.swordtooffer.question033;

/**
 * JZ33 丑数
 *
 * 题目描述
 * 把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含质因子 7。习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 *
 *
 * 示例1
 *
 * 输入
 * 7
 *
 * 返回值
 * 8
 *
 * @author Jiajing Li
 * @date 2021-04-30 10:06:04
 */
@SuppressWarnings("all")
public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        // 初始化三个指向三个潜在成为最小丑数的位置
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] num = new int[index];
        num[0] = 1;
        for (int i = 1; i < index; i++) {
            num[i] = Math.min(num[p2] * 2, Math.min(num[p3] * 3, num[p5] * 5));
            // 为了防止重复需要三个 if 都能够走到
            if (num[i] == num[p2] * 2) {
                p2++;
            }
            if (num[i] == num[p3] * 3) {
                p3++;
            }
            if (num[i] == num[p5] * 5) {
                p5++;
            }
        }
        return num[index - 1];
    }

}
