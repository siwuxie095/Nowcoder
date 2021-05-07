package com.siwuxie095.onlineprogramming.swordtooffer.question034;

import java.util.HashMap;
import java.util.Map;

/**
 * JZ34 第一个只出现一次的字符
 *
 * 题目描述
 * 在一个字符串(0 <= 字符串长度 <= 10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有
 * 则返回 -1（需要区分大小写）.（从 0 开始计数）
 *
 *
 * 示例1
 *
 * 输入
 * "google"
 *
 * 返回值
 * 4
 *
 * @author Jiajing Li
 * @date 2021-05-07 14:46:32
 */
@SuppressWarnings("all")
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        if (null == str || str.length() == 0) {
            return -1;
        }
        char[] arr = str.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : arr) {
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        }
        int index = 0;
        for (char ch : arr) {
            if (count.get(ch) == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }

}
