package com.siwuxie095.onlineprogramming.swordtooffer.question045;

import java.util.HashSet;
import java.util.Set;

/**
 * JZ45 扑克牌顺子
 *
 * 题目描述
 * 现在有五张扑克牌，我们需要来判断一下是不是顺子。
 *
 * 有如下规则：
 * A 为 1, J 为 11, Q 为 12, K 为 13
 *
 * 数据中的 0 可以看作任意牌
 * 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出 true，否则就输出 false。
 *
 * 例如：给出数据[6,0,2,0,4]
 *
 * 中间的两个 0 一个看作 3，一个看作 5 。即：[6,3,2,5,4]
 * 这样这五张牌在 [2,6] 区间连续，输出 true
 * 数据保证每组 5 个数字，每组最多含有 4 个零
 *
 *
 * 示例1
 *
 * 输入
 * [0,3,2,6,4]
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-05-11 20:01:25
 */
@SuppressWarnings("all")
public class Solution {

    public boolean IsContinuous(int [] numbers) {
        if (null == numbers || numbers.length == 0) {
            return false;
        }

        int max = -1;
        int min = Integer.MAX_VALUE;
        boolean repeat = false;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (isIllegal(val)) {
                return false;
            }
            if (isLegal(val)) {
                set.add(val);
                if (val > max) {
                    max = val;
                }
                if (val < min) {
                    min = val;
                }
            }
            if (val == 0) {
                count++;
            }
        }
        if (count > 4) {
            return false;
        }
        if (count + set.size() < numbers.length) {
            return false;
        }
        return max == min || max - min <= 4;
    }

    private boolean isIllegal(int number) {
        return number < 0 || number > 13;
    }

    private boolean isLegal(int number) {
        return number >= 1 && number <= 13;
    }

}
