package com.siwuxie095.onlineprogramming.huawei.question045;

import java.util.*;

/**
 * 名字的漂亮度
 *
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”
 * 是其所有字母“漂亮度”的总和。每个字母都有一个“漂亮度”，范围在1
 * 到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * 输入描述:
 * 整数N，后续N个名字
 *
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 *
 *
 * 示例1
 *
 * 输入
 * 2
 * zhangsan
 * lisi
 *
 * 输出
 * 192
 * 101
 *
 * @author Jiajing Li
 * @date 2020-03-19 15:46:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            List<String> names = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                names.add(scanner.next());
            }
            for (String name : names) {
                System.out.println(calculateMaxPrettiness(name));
            }
        }
    }

    private static Integer calculateMaxPrettiness(String name) {
        char[] arr = name.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        int res = 0;
        int num = 0;
        for (int count : list) {
         res += count * (26 - num++);
        }
        return res;
    }

}
