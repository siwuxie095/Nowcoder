package com.siwuxie095.onlineprogramming.swordtooffer.question006;

/**
 * JZ6 旋转数组中的最小数字
 *
 * 题目描述
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 *
 *
 * 示例1
 *
 * 输入
 * [3,4,5,1,2]
 *
 * 返回值
 * 1
 *
 * @author Jiajing Li
 * @date 2021-03-31 09:53:04
 */
@SuppressWarnings("all")
public class Solution {

    public int minNumberInRotateArray(int [] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (true) {
            mid = start + (end - start) / 2;
            if (end == mid) {
                break;
            }
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            } else if (array[mid] <= array[mid + 1]) {
                if (array[mid] <= array[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return array[mid];
    }

}
