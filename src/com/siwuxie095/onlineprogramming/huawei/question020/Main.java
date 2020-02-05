package com.siwuxie095.onlineprogramming.huawei.question020;

import java.util.Scanner;

/**
 * 密码验证合格程序
 *
 * 题目描述
 * 密码要求:

 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 *
 * 说明:长度超过2的子串
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 *
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 *
 * 输出
 * OK
 * NG
 * NG
 * OK
 *
 * @author Jiajing Li
 * @date 2020-01-07 09:40:40
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (checkLength(input) && checkSort(input) && checkRepeat(input)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean checkLength(String str) {
        return str.length() > 8;
    }

    private static boolean checkSort(String str) {
        int upper = 0;
        int lower = 0;
        int digit = 0;
        int other = 0;
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch >= 'A' && ch <= 'Z') {
                upper = 1;
            } else if (ch >= 'a' && ch <= 'z') {
                lower = 1;
            } else if (ch >= '0' && ch <= '9') {
                digit = 1;
            } else {
                other = 1;
            }
        }
        return upper + lower + digit + other >= 3;
    }

    private static boolean checkRepeat(String str) {
        for (int i = 0; i + 3 <= str.length(); i++) {
            String sub = str.substring(i, i + 3);
            if (str.substring(i + 1).contains(sub)) {
                return false;
            }
        }
        return true;
    }


}
