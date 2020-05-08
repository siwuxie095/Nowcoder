package com.siwuxie095.onlineprogramming.huawei.question071;

import java.util.Scanner;

/**
 * 字符串通配符
 *
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现
 * 字符串通配符的算法。
 *
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 *
 * 输出：
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 *
 *
 * 示例1
 *
 * 输入
 * te?t*.*
 * txt12.xls
 *
 * 输出
 * false
 *
 * @author Jiajing Li
 * @date 2020-04-22 15:19:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String regex = scanner.next();
            String value = scanner.next();
            char[] regexArr = regex.toCharArray();
            char[] valueArr = value.toCharArray();
            boolean flag = isMatched(regexArr, valueArr, 0, 0);
            System.out.println(flag);
        }
    }

    private static boolean isMatched(char[] regexArr, char[] valueArr, int regexIndex, int valueIndex) {
        while (regexIndex < regexArr.length && valueIndex < valueArr.length) {
            char curRegex = regexArr[regexIndex];
            char curValue = valueArr[valueIndex];
            // force to match a char.
            if (isQuestion(curRegex)) {
                regexIndex++;
                valueIndex++;
                //
            } else if (isAsterisk(curRegex)) {
                if (regexIndex == regexArr.length - 1) {
                    return true;
                }
                char nextRegex = regexArr[regexIndex + 1];
                char nextValue = valueArr[valueIndex + 1];
                if (nonQuestion(nextRegex)) {
                    while (nextValue != nextRegex) {
                        valueIndex++;
                        nextValue = valueArr[valueIndex + 1];
                    }
                } else {
                    char nextNextRegex = regexArr[regexIndex + 2];
                    while (nextValue != nextNextRegex) {
                        valueIndex++;
                        nextValue = valueArr[valueIndex + 1];
                    }
                }
                if (regexIndex < regexArr.length - 1 && valueIndex == valueArr.length - 1) {
                    return false;
                }
                if (isQuestion(nextRegex)) {
                    regexIndex++;
                }
                regexIndex++;
                valueIndex++;
                // compare directly.
            } else {
                if (curRegex != curValue) {
                    return false;
                }
                regexIndex++;
                valueIndex++;
            }
        }
        return true;
    }

    private static boolean isLetterOrDigit(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private static boolean nonLetterOrDigit(char ch) {
        return !isLetterOrDigit(ch);
    }

    private static boolean isAsterisk(char ch) {
        return ch == '*';
    }

    private static boolean nonAsterisk(char ch) {
        return !isAsterisk(ch);
    }

    private static boolean isQuestion(char ch) {
        return ch == '?';
    }

    private static boolean nonQuestion(char ch) {
        return !isQuestion(ch);
    }
}
