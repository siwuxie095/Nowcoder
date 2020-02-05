package com.siwuxie095.onlineprogramming.huawei.question023;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 删除字符串中出现次数最少的字符
 *
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 *
 * 输入
 * abcdd
 *
 * 输出
 * dd
 *
 * @author Jiajing Li
 * @date 2020-01-14 09:49:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] arr = str.toCharArray();

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : arr) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            int minCount = Collections.min(map.values());
            StringBuilder builder = new StringBuilder();
            for (char ch : arr) {
                if (map.get(ch) != minCount) {
                    builder.append(ch);
                }
            }
            System.out.println(builder.toString());
        }

    }

}
