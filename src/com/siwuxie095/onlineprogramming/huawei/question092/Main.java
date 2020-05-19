package com.siwuxie095.onlineprogramming.huawei.question092;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在字符串中找出连续最长的数字串
 *
 * 题目描述
 *
 * 样例输出
 * 输出123058789，函数返回值9
 * 输出54761，函数返回值5
 *
 *
 * 接口说明
 * 函数原型：
 *    unsignedint Continumax(char** pOutputstr,  char* intputstr)
 * 输入参数：
 *    char* intputstr  输入字符串；
 * 输出参数：
 *    char** pOutputstr: 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；
 *    如果输入字符串是空，也应该返回空字符串；
 * 返回值：
 *   连续最长的数字串的长度
 *
 *
 * 输入描述:
 * 输入一个字符串。
 *
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
 *
 *
 * 示例1
 *
 * 输入
 * abcd12345ed125ss123058789
 *
 * 输出
 * 123058789,9
 *
 * @author Jiajing Li
 * @date 2020-05-19 14:55:09
 */
public class Main {

    public static void main(String[] args) {
        //firstMethod();
        //secondMethod();
        thirdMethod();
    }


    private static void firstMethod() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] arr = input.toCharArray();
            List<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            boolean flag = false;
            int count = 0;
            for (char ch : arr) {
                count++;
                if (Character.isDigit(ch)) {
                    if (!flag) {
                        flag = true;
                    }
                    builder.append(ch);
                    if (count == arr.length) {
                        list.add(builder.toString());
                        builder.setLength(0);
                    }
                } else {
                    flag = false;
                    list.add(builder.toString());
                    builder.setLength(0);
                }
            }
            list.sort(Comparator.comparingInt(String::length).reversed());
            printResult(list);
        }
    }

    private static void secondMethod() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chArr = input.toCharArray();
            for (int i = 0; i < chArr.length; i++) {
                if (!Character.isDigit(chArr[i])) {
                    chArr[i] = 'a';
                }
            }
            String[] strArr = new String(chArr).split("a");
            List<String> list = Arrays.stream(strArr)
                    .distinct()
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .collect(Collectors.toList());
            printResult(list);
        }
    }


    private static void thirdMethod() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] strArr = input.split("[^0-9]");
            List<String> list = Arrays.stream(strArr)
                    .distinct()
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .collect(Collectors.toList());
            printResult(list);
        }
    }

    private static void printResult(List<String> list) {
        int len = 0;
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            if (str.length() >= len) {
                len = str.length();
                res.append(str);
            } else {
                break;
            }
        }
        res.append(",");
        res.append(len);
        System.out.println(res);
    }


}
