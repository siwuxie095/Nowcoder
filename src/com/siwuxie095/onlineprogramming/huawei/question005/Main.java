package com.siwuxie095.onlineprogramming.huawei.question005;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 进制转换
 *
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 *
 * 示例1
 *
 * 输入
 * 0xA
 *
 * 输出
 * 10
 *
 * @author Jiajing Li
 * @date 2019-11-30 17:04:22
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // note that there is multi-group of data, so here needs a while loop.
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            // transform str into upper case.
            str = str.toUpperCase();
            // get the char array.
            char[] arr = str.toCharArray();

            int res = 0;
            int power = 0;
            int len = arr.length;
            // traverse from back to front and ignore the first and second char: '0' and 'X'.
            for (int i = len - 1; i > 1; i--) {
                int digit = getDigit(arr[i]);
                res += digit * ((int) Math.pow(16, power));
                power++;
            }
            System.out.println(res);
        }
    }

    private static int getDigit(char ch) {
        String str = new String(new char[] {ch});
        if (isDigit(str)) {
            return Integer.valueOf(str);
        } else {
            // in ascii, char 'A' equals 65, and in hex, A represents 10.
            return ch - 55;
        }
    }

    private static boolean isDigit(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
