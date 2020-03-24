package com.siwuxie095.onlineprogramming.huawei.question057;

import java.util.Scanner;

/**
 * 无线OSS－高精度整数加法
 *
 * 题目描述
 * 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器
 * 计算机中，参与运算的操作数和结果必须在-2^31~2^31-1之间。如果需要进行更大范围的十进制
 * 整数加法，需要使用特殊的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。
 * 如下：
 * 9876543210 + 1234567890 = ?
 * 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result
 * = "11111111100"。-9876543210 + (-1234567890) = ?
 * 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result
 * = "-11111111100"。
 *
 * 要求编程实现上述高精度的十进制加法。
 * 要求实现方法：
 * public String add (String num1, String num2)
 * 【输入】num1：字符串形式操作数1，如果操作数为负，则num1的前缀为符号位'-'
 * num2：字符串形式操作数2，如果操作数为负，则num2的前缀为符号位'-'
 * 【返回】保存加法计算结果字符串，如果结果为负，则字符串的前缀为'-'
 * 注：
 * (1)当输入为正数时，'+'不会出现在输入字符串中；当输入为负数时，'-'会出现在输入字符串中，
 * 且一定在输入字符串最左边位置；
 * (2)输入字符串所有位均代表有效数字，即不存在由'0'开始的输入字符串，比如"0012", "-0012"
 * 不会出现；
 * (3)要求输出字符串所有位均为有效数字，结果为正或0时'+'不出现在输出字符串，结果为负时输出
 * 字符串最左边位置为'-'。
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出给求和后的结果
 *
 *
 * 示例1
 *
 * 输入
 * 9876543210
 * 1234567890
 *
 * 输出
 * 11111111100
 *
 * @author Jiajing Li
 * @date 2020-03-23 22:57:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String firstStr = scanner.next();
            String secondStr = scanner.next();
            // positive or negative
            boolean firstFlag = true;
            boolean secondFlag = true;

            if (firstStr.contains("-")) {
                firstFlag = false;
            }

            if (secondStr.contains("-")) {
                secondFlag = false;
            }

            String res = "";
            firstStr = firstStr.replace("-", "");
            secondStr = secondStr.replace("-", "");
            // digit length
            int firstLen = firstStr.length();
            int secondLen = secondStr.length();
            if (firstFlag && secondFlag) {
                res = firstLen >= secondLen ? add(firstStr, secondStr) : add(secondStr, firstStr);
            } else if (!firstFlag && !secondFlag) {
                res = "-" + (firstLen >= secondLen ? add(firstStr, secondStr) : add(secondStr, firstStr));
            } else {
                if (firstFlag) {
                    res = subtract(firstLen, secondLen, firstStr, secondStr);
                } else {
                    res = subtract(secondLen, firstLen, secondStr, firstStr);
                }
            }
            System.out.println(res);
        }
    }


    /**
     * default: first >= second.
     */
    private static String add(String firstStr, String secondStr) {
        StringBuilder res = new StringBuilder();
        char[] firstArr = firstStr.toCharArray();
        char[] secondArr = secondStr.toCharArray();
        int firstIndex = firstArr.length - 1;
        int secondIndex = secondArr.length - 1;
        int carry = 0;
        while (secondIndex >= 0) {
            int value = carry + getInt(firstArr[firstIndex]) + getInt(secondArr[secondIndex]);
            carry = value / 10;
            res.append(value % 10);
            firstIndex--;
            secondIndex--;
        }
        while (firstIndex >= 0) {
            int value = carry + getInt(firstArr[firstIndex]);
            carry = value / 10;
            res.append(value % 10);
            firstIndex--;
        }

        if (carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    private static int getInt(char ch) {
        return Integer.parseInt(String.valueOf(ch));
    }

    private static String subtract(int firstLen, int secondLen, String firstStr, String secondStr) {
        String res = "";
        if (firstLen > secondLen) {
            res = subtract(firstStr, secondStr);
        } else if (firstLen < secondLen) {
            res = "-" + subtract(secondStr, firstStr);
        } else {
            char[] firstArr = firstStr.toCharArray();
            char[] secondArr = secondStr.toCharArray();
            for (int i = 0; i < firstLen; i++) {
                if (firstArr[i] == secondArr[i]) {
                    continue;
                }
                if (firstArr[i] > secondArr[i]) {
                    res = subtract(firstStr, secondStr);
                } else {
                    res = "-" + subtract(secondStr, firstStr);
                }
                break;
            }
        }

        return res;
    }

    /**
     * default: first >= second.
     */
    private static String subtract(String firstStr, String secondStr) {
        StringBuilder res = new StringBuilder();
        char[] firstArr = firstStr.toCharArray();
        char[] secondArr = secondStr.toCharArray();
        int firstIndex = firstArr.length - 1;
        int secondIndex = secondArr.length - 1;
        int borrow = 0;
        while (secondIndex >= 0) {
            int value;
            if (getInt(firstArr[firstIndex]) - borrow >= getInt(secondArr[secondIndex])) {
                value = getInt(firstArr[firstIndex]) - borrow - getInt(secondArr[secondIndex]);
                res.append(value);
                firstIndex--;
                secondIndex--;
            } else {
                value = 10 + getInt(firstArr[firstIndex]) - borrow - getInt(secondArr[secondIndex]);
                borrow = 1;
                res.append(value);
                firstIndex--;
                secondIndex--;
            }
        }

        while (firstIndex >= 0) {
            int value;
            if (getInt(firstArr[firstIndex]) - borrow >= 0) {
                value = getInt(firstArr[firstIndex]) - borrow;
                res.append(value);
                firstIndex--;
            } else {
                value = 10 + getInt(firstArr[firstIndex]) - borrow;
                borrow = 1;
                res.append(value);
                firstIndex--;
            }
        }
        String str = res.reverse().toString();
        char[] arr = str.toCharArray();
        int index;
        for (index = 0; index < str.length(); index++) {
            if (arr[index] != '0') {
                break;
            }
        }
        return str.substring(index);
    }

}
