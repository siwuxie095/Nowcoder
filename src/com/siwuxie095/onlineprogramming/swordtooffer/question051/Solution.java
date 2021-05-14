package com.siwuxie095.onlineprogramming.swordtooffer.question051;

/**
 * JZ51 构建乘积数组
 *
 *
 * 题目描述
 * 给定一个数组 A[0,1,...,n-1],请构建一个数组 B[0,1,...,n-1], 其中 B 中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定
 * B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于 A 长度为 1 的情况，B 无意义，故而无法构建，因此该情况不会存在。
 *
 *
 * 示例1
 *
 * 输入
 * [1,2,3,4,5]
 *
 * 返回值
 * [120,60,40,30,24]
 *
 * PS：即 计算 B[i] 是从 A[0] 乘到 A[n-1]，只有 A[i] 没有乘。
 *
 * @author Jiajing Li
 * @date 2021-05-14 15:20:46
 */
@SuppressWarnings("all")
public class Solution {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        // 边界
        if (null == A || A.length <= 1) {
            return null;
        }
        // 计算下三角
        // 初始化第一行
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        // 计算上三角
        // 初始化最后一行
        int temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            B[i] = temp * B[i];
            temp = A[i] * temp;
        }
        return B;
    }

}
