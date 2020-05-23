package com.siwuxie095.onlineprogramming.huawei.question102;

import java.util.*;

/**
 * 字符统计
 *
 * 题目描述
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符
 * 不用进行统计。
 *
 * 实现以下接口：
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出
 * 清空目前的统计结果，重新统计
 * 调用者会保证：
 * 输入的字符串以‘\0’结尾。
 *
 *
 * 输入描述:
 * 输入一串字符。
 *
 * 输出描述:
 * 对字符中的各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多
 * 到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对
 * 这些字符不用进行统计。
 *
 *
 * 示例1
 *
 * 输入
 * aadddccddc
 *
 * 输出
 * dca
 *
 * @author Jiajing Li
 * @date 2020-05-23 11:36:51
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            char[] arr = input.toCharArray();
            Map<Character, Integer> map = new TreeMap<>();
            for (char ch : arr) {
                if (unmatched(ch)) {
                    continue;
                }
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            List<Integer> list = new ArrayList<>(map.values());
            list.sort(Comparator.reverseOrder());
            for (int count : list) {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == count) {
                        System.out.print(entry.getKey());
                        map.remove(entry.getKey());
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    private static boolean unmatched(char ch) {
        return ch != ' ' && !Character.isDigit(ch) && !Character.isLetter(ch);
    }

}
