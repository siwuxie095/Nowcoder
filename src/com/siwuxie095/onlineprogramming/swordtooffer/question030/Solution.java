package com.siwuxie095.onlineprogramming.swordtooffer.question030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * JZ30 连续子数组的最大和
 *
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
 *
 *
 * 示例1
 *
 * 输入
 * [1,-2,3,10,-4,7,2,-5]
 *
 * 返回值
 * 18
 *
 * 说明
 * 输入的数组为 {1,-2,3,10,-4,7,2,-5}，和最大的子数组为 {3,10,-4,7,2}，因此
 * 输出为该子数组的和 18。
 *
 * @author Jiajing Li
 * @date 2021-04-27 17:42:09
 */
@SuppressWarnings("all")
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        int count = 1;
        int length = array.length;
        for (; count <= length; count++) {
            next(array, 0, count, length, res);
        }
        return Collections.max(res);
    }

    private void next(int[] array, int index, int count, int length, List<Integer> res) {
        int startIndex = index;
        int endIndex = index + count - 1;
        if (endIndex > length - 1) {
            return;
        }
        int value = 0;
        for (; startIndex <= endIndex; startIndex++) {
            value += array[startIndex];
        }
        res.add(value);
        next(array, index + 1, count, length, res);
    }

}
