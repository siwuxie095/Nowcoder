package com.siwuxie095.onlineprogramming.swordtooffer.question040;

/**
 * JZ40 数组中只出现一次的两个数字
 *
 * 题目描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 示例1
 *
 * 输入
 * [1,4,1,6]
 *
 * 返回值
 * [4,6]
 *
 * 说明
 * 返回的结果中较小的数排在前面
 *
 * @author Jiajing Li
 * @date 2021-05-08 16:54:48
 */
@SuppressWarnings("all")
public class Solution {

    public int[] FindNumsAppearOnce(int[] array) {
        int[] res = new int[2];
        int x = array[0];
        // 将数组中所有数字做异或处理
        // 由于相同数字异或结果为 0，0 与数字 x 异或的结果为 x
        // 所以最终的结果为单独出现的数字的异或结果
        for (int i = 1; i < array.length; i++) {
            x ^= array[i];
        }
        int m = 1;
        // 两个单独出现的数字若在 m 位相异，则在 x 中第 m 位为 1
        // 找到这样的 m 位
        while ((m & x) == 0) {
            m = m << 1 ;
        }
        // 根据第 m 位的值将原数组分为两组，单独出现的两个数字分在不同的组
        for (int val : array) {
            if ((m & val) == 0) {
                res[0] ^= val;
            } else {
                res[1] ^= val;
            }
        }
        if (res[0] > res[1]) {
            swap(res,0,1);
        }
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
