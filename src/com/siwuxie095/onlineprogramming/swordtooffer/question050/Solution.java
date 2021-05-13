package com.siwuxie095.onlineprogramming.swordtooffer.question050;

import java.util.HashMap;
import java.util.Map;

/**
 * JZ50 数组中重复的数字
 *
 * 题目描述
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字
 * 是重复的。也不知道每个数字重复几次。请找出数组中任一一个重复的数字。例如，如果输入长度为 7 的数组
 * [2,3,1,0,2,5,3]，那么对应的输出是 2 或者 3。存在不合法的输入的话输出 -1
 *
 *
 * 示例1
 *
 * 输入
 * [2,3,1,0,2,5,3]
 *
 * 返回值
 * 2
 *
 * 说明
 * 2 或 3 都是对的
 *
 * @author Jiajing Li
 * @date 2021-05-13 20:11:16
 */
@SuppressWarnings("all")
public class Solution {

    public int duplicate(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return -1;
        }
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : numbers) {
            if (val < 0 || val >= len) {
                return -1;
            }
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
