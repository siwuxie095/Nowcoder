package com.siwuxie095.onlineprogramming.huawei.question026;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 字符串排序
 *
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 输入描述:
 * 输入字符串
 *
 * 输出描述:
 * 输出字符串
 *
 *
 * 示例1
 *
 * 输入
 * A Famous Saying: Much Ado About Nothing (2012/8).
 *
 * 输出
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 *
 * @author Jiajing Li
 * @date 2020-02-05 14:30:06
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] arr = input.toCharArray();
            char[] res = new char[arr.length];
            Map<Character, StringBuilder> map = new HashMap<>();
            int index = 0;
            for (char ch : arr) {
                if (Character.isLetter(ch)) {
                    char lowerCaseChar = Character.toLowerCase(ch);
                    if (map.containsKey(lowerCaseChar)) {
                        map.put(lowerCaseChar, map.get(lowerCaseChar).append(ch));
                    } else {
                        map.put(lowerCaseChar, new StringBuilder().append(ch));
                    }
                } else {
                    res[index] = ch;
                }
                index++;
            }

            index = 0;
            for (int i = 97; i < 97 + 26; i++) {
                char key = (char) i;
                StringBuilder value = map.get(key);
                if (null != value) {
                    char[] toCharArr = value.toString().toCharArray();
                    for (char ch : toCharArr) {
                        index = findFirstNonEmptyIndex(res, index);
                        res[index] = ch;
                    }
                }
            }

            System.out.println(new String(res));

        }

    }

    private static int findFirstNonEmptyIndex(char[] res, int fromIndex) {
        for (int i  = fromIndex; i < res.length; i++) {
            if (res[i] == '\u0000') {
                return i;
            }
        }
        return -1;
    }


}
