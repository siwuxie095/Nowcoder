package com.siwuxie095.onlineprogramming.swordtooffer.question041;

import java.util.ArrayList;

/**
 * JZ41 和为 S 的连续正数序列
 *
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出 9~16 的和,他马上就写出了正确答案是 100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为 100 的序列:
 * 18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为 S 的连续正数序列? Good Luck!
 *
 * 返回值描述:
 * 输出所有和为 S 的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 *
 * 示例1
 *
 * 输入
 * 9
 *
 * 返回值
 * [[2,3,4],[4,5]]
 *
 * @author Jiajing Li
 * @date 2021-05-10 09:57:17
 */
@SuppressWarnings("all")
public class Solution {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        int tmp = 0;
        while (left <= sum / 2) {
            if (tmp < sum) {
                tmp += right;
                ++right;
            } else if (tmp > sum) {
                tmp -= left;
                ++left;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int val = left; val < right; ++val) {
                    list.add(val);
                }
                res.add(list);
                tmp -= left;
                ++left;
            }
        }
        return res;
    }

}
