package com.siwuxie095.onlineprogramming.swordtooffer.question029;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * JZ29 最小的 K 个数
 *
 * 题目描述
 *
 * 给定一个数组，找出其中最小的 K 个数。例如数组元素是 4,5,1,6,2,7,3,8 这 8 个数字，则最小的 4 个数字是 1,2,3,4。
 * 如果 K > 数组的长度，那么返回一个空的数组
 *
 *
 * 示例1
 *
 * 输入
 * [4,5,1,6,2,7,3,8],4
 *
 * 返回值
 * [1,2,3,4]
 *
 * @author Jiajing Li
 * @date 2021-04-27 15:28:01
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == input || input.length == 0) {
            return res;
        }
        if (k <= 0 || k > input.length) {
            return res;
        }
        int count = 0;
        for (int val : input) {
            if (count < k) {
                res.add(val);
                count++;
            } else {
                int max = Collections.max(res);
                if (val < max) {
                    res.remove(res.indexOf(max));
                    res.add(val);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
