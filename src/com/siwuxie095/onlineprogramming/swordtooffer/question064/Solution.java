package com.siwuxie095.onlineprogramming.swordtooffer.question064;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * JZ64 滑动窗口的最大值
 *
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2,3,4,2,6,2,5,1} 及滑动窗口的大小 3，
 * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4,4,6,6,6,5}；
 * 针对数组 {2,3,4,2,6,2,5,1} 的滑动窗口有以下 6 个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 *
 * 示例1
 *
 * 输入
 * [2,3,4,2,6,2,5,1],3
 *
 * 返回值
 * [4,4,6,6,6,5]
 *
 * @author Jiajing Li
 * @date 2021-05-20 09:57:26
 */
@SuppressWarnings("all")
public class Solution {

    // 大顶堆
    private PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == num || num.length == 0 || size < 1 || size > num.length) {
            return res;
        }
        int count = 0;
        // 初始化：第一批
        for (; count < size; count++) {
            max.offer(num[count]);
        }
        // 处理中间批次
        while (count < num.length) {
            res.add(max.peek());
            // 向后滑动
            max.remove(num[count - size]);
            max.add(num[count]);
            count++;
        }
        // 补充：最后一批
        res.add(max.peek());
        return res;
    }

}
