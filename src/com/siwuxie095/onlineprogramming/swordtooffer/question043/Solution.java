package com.siwuxie095.onlineprogramming.swordtooffer.question043;

/**
 * JZ43 左旋字符串
 *
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出。例如，字符序列 S = ”abcXYZdef”,要求
 * 输出循环左移 3 位后的结果，即 “XYZdefabc”。是不是很简单？OK，搞定它！
 *
 *
 * 示例1
 *
 * 输入
 * "abcXYZdef",3
 *
 * 返回值
 * "XYZdefabc"
 *
 * @author Jiajing Li
 * @date 2021-05-11 19:06:04
 */
@SuppressWarnings("all")
public class Solution {

    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() == 0) {
            return str;
        }
        int len = str.length();
        n = n % len;
        return str.substring(n) + str.substring(0, n);
    }

}
