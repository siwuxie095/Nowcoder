package com.siwuxie095.onlineprogramming.swordtooffer.question028;

/**
 * JZ28 数组中出现次数超过一半的数字
 *
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组 {1,2,3,2,2,2,5,4,2}。
 * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。如果不存在则输出 0。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,2,2,2,5,4,2]
 *
 * 返回值
 * 2
 *
 * PS：超过一半的数字只会有一个。
 *
 * @author Jiajing Li
 * @date 2021-04-26 19:44:29
 */
@SuppressWarnings("all")
public class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int val = array[0];
        int count = 1;
        // 找众数
        for (int i = 1; i < array.length; i++) {
            if (val == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    val = array[i];
                    count = 1;
                }
            }
        }
        // 判断是否超过一半
        if (count == 0) {
            return 0;
        } else {
            int num = 0;
            for (int i = 0; i < array.length; i++) {
                if (val == array[i]) {
                    num++;
                }
            }
            return num > array.length / 2 ? val : 0;
        }
    }

}
