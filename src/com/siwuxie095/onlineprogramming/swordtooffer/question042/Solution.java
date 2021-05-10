package com.siwuxie095.onlineprogramming.swordtooffer.question042;

import java.util.ArrayList;

/**
 * JZ42 和为 S 的两个数字
 *
 * 题目描述
 * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S，
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,4,7,11,15],15
 *
 * 返回值
 * [4,11]
 *
 * @author Jiajing Li
 * @date 2021-05-10 15:16:03
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == array || array.length == 0) {
            return res;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp = Integer.MAX_VALUE;
        int first = 0;
        int seond = 0;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                if (array[i] * array[j] < tmp) {
                    tmp = array[i] * array[j];
                    first = i;
                    seond = j;
                }
                i++;
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        if (first == seond) {
            return res;
        }
        res.add(array[first]);
        res.add(array[seond]);
        return res;
    }

}
