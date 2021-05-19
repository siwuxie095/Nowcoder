package com.siwuxie095.onlineprogramming.swordtooffer.question063;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * JZ63 数据流中的中位数
 *
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用 Insert() 方法
 * 读取数据流，使用 GetMedian() 方法获取当前读取数据的中位数。
 *
 * @author Jiajing Li
 * @date 2021-05-19 18:02:04
 */
@SuppressWarnings("all")
public class Solution {

    private int count = 0;

    // 小顶堆存大数，即 存中位数右边的数
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    // 大顶堆存小数，即 存中位数左边的数
    private PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1) {
             // count 为奇数，存放到大顶堆
            if (!min.isEmpty() && num > min.peek()) {
                min.offer(num);
                // 拿出最小的数
                num = min.poll();
            }
            // 放到大顶堆
            max.offer(num);
        } else {
            // count 为偶数，存放到小顶堆
            if (!max.isEmpty() && num < max.peek()) {
                max.offer(num);
                // 拿出最大的数
                num = max.poll();
            }
            // 放到小顶堆
            min.offer(num);
        }
    }

    public Double GetMedian() {
        double res = 0;

        if ((count & 1) == 1) {
            // 奇数个
            res = max.peek();
        } else {
            // 偶数个
            res = (max.peek() + min.peek()) / 2.0;
        }
        return res;
    }

}
