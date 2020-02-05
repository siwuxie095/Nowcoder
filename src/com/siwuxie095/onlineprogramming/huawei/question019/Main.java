package com.siwuxie095.onlineprogramming.huawei.question019;

import java.util.*;

/**
 * 简单错误记录
 *
 * 题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 *
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 *
 * 输出
 * fpgadrive.c 1325 1
 *
 * @author Jiajing Li
 * @date 2020-01-06 19:32:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (null == input || "".equals(input)) {
                break;
            }
            input = input.replaceAll(" +", " ");
            String first = input.split(" ")[0];
            String second = input.split(" ")[1];

            String[] arr = first.split("\\\\");
            first = arr[arr.length - 1];

            String key = first + "-" + second;
            list.add(key);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        List<String> subList = list.subList(list.size() - 8, list.size());
        for (String str : subList) {
            String first = str.split("-")[0];
            String second = str.split("-")[1];
            int third = map.get(str);
            if (first.length() > 16) {
                first = first.substring(first.length() - 16);
            }
            System.out.println(first + " " + second + "  " + third);
        }
    }

}
