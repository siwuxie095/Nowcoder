package com.siwuxie095.onlineprogramming.swordtooffer.question002;

/**
 * JZ2 替换空格
 *
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。例如，当字符串为 We Are Happy.则经过替换之后的
 * 字符串为 We%20Are%20Happy。
 *
 * 示例1
 *
 * 输入
 * "We Are Happy"
 *
 * 返回值
 * "We%20Are%20Happy"
 *
 * @author Jiajing Li
 * @date 2021-03-17 10:30:53
 */
@SuppressWarnings("all")
public class Solution {

    public String replaceSpace (String s) {
        if (null == s) {
            return null;
        }
        return s.replace(" ", "%20");
    }

}
