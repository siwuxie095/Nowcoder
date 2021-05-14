package com.siwuxie095.onlineprogramming.swordtooffer.question054;

import java.util.LinkedList;
import java.util.Queue;

/**
 * JZ54 字符流中第一个不重复的字符
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，
 * 第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符
 * 是 "l"。
 *
 * 后台会用以下方式调用 Insert 和 FirstAppearingOnce 函数
 *
 * string caseout = "";
 * 1.读入测试用例字符串 casein
 * 2.如果对应语言有 Init() 函数的话，执行 Init() 函数
 * 3.循环遍历字符串里的每一个字符 ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出 caseout，进行比较。
 *
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回 # 字符。
 *
 * @author Jiajing Li
 * @date 2021-05-14 18:42:41
 */
@SuppressWarnings("all")
public class Solution {

    private int[] charCnt = new int[128];
    private Queue<Character> queue = new LinkedList<Character>();

    public void Insert(char ch) {
        if (charCnt[ch]++ == 0) {
            // 第一次出现，入队
            queue.add(ch);
        }
    }
    public char FirstAppearingOnce() {
        Character tmp = null;
        char ch = 0;
        while ((tmp = queue.peek()) != null) {
            ch = tmp.charValue();
            if (charCnt[ch] == 1) {
                // 第一次出现，返回
                return ch;
            } else {
                // 不是第一次出现，出队
                queue.remove();
            }
        }
        // 队空，返回 #
        return '#';
    }

}
