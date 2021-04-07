package com.siwuxie095.onlineprogramming.swordtooffer.question013;

import java.util.ArrayList;
import java.util.List;

/**
 * JZ13 调整数组顺序使奇数位于偶数前面
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,4]
 *
 * 返回值
 * [1,3,2,4]
 *
 * @author Jiajing Li
 * @date 2021-04-07 14:50:54
 */
@SuppressWarnings("all")
public class Solution {

    public int[] reOrderArray(int[] array) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int val : array) {
            if (val % 2 == 1) {
                odd.add(val);
            } else {
                even.add(val);
            }
        }
        int[] res = new int[array.length];
        int idx = 0;
        for (int val : odd) {
            res[idx++] = val;
        }
        for (int val : even) {
            res[idx++] = val;
        }
        return res;
    }

}
