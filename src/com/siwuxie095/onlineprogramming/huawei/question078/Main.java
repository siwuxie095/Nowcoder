package com.siwuxie095.onlineprogramming.huawei.question078;

import java.util.Scanner;

/**
 * 超长正整数相加
 *
 * 题目描述
 * 请设计一个算法完成两个超长正整数的加法。
 *
 * 输入描述:
 * 输入两个字符串数字
 *
 * 输出描述:
 * 输出相加后的结果，string型
 *
 *
 * 示例1
 *
 * 输入
 * 99999999999999999999999999999999999999999999999999
 * 1
 *
 * 输出
 * 100000000000000000000000000000000000000000000000000
 *
 * @author Jiajing Li
 * @date 2020-05-14 09:38:17
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
