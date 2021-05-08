package com.siwuxie095.onlineprogramming.swordtooffer.question037;

/**
 * JZ37 数字在升序数组中出现的次数
 *
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,3,3,3,4,5],3
 *
 * 返回值
 * 4
 *
 * @author Jiajing Li
 * @date 2021-05-08 14:07:32
 */
@SuppressWarnings("all")
public class Solution {

    public int GetNumberOfK(int [] array , int k) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int leftIndex = getLeftIndex(array, k);
        int righIndex = getRightIndex(array, k);
        return righIndex - leftIndex;
    }

    /**
     * 左边界
     */
    private int getLeftIndex(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    /**
     * 右边界
     */
    private int getRightIndex(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
