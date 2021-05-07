package com.siwuxie095.onlineprogramming.swordtooffer.question035;

/**
 * JZ35 数组中的逆序对
 *
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数 P。并将 P对 1000000007 取模的结果
 * 输出。即输出 P%1000000007
 *
 * 对于 50% 的数据, size ≤ 10^4
 * 对于 75% 的数据, size ≤ 10^5
 * 对于 100% 的数据, size ≤ 2*10^5
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,4,5,6,7,0]
 *
 * 返回值
 * 7
 *
 * @author Jiajing Li
 * @date 2021-05-07 15:08:32
 */
@SuppressWarnings("all")
public class Solution {

    private static final int MOD = (int) 1e9 + 7;
    private int count = 0;


    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        mergeSort(0, array.length - 1, array);
        return count;
    }

    public void mergeSort(int left, int right, int[] array) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(left, mid, array);
            mergeSort(mid + 1, right, array);
            merge(left, mid, right, array);
        }
    }

    public void merge(int left, int mid, int right, int[] array) {
        int[] aux = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                aux[k++] = array[i++];
            } else {
                // 关键点
                count = (count + mid - i + 1) % MOD;
                aux[k++] = array[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = array[i++];
        }
        while (j <= right) {
            aux[k++] = array[j++];
        }
        for (i = left; i <= right; i++) {
            array[i] = aux[i - left];
        }
    }

}
