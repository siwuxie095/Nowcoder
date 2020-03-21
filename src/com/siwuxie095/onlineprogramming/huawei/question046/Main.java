package com.siwuxie095.onlineprogramming.huawei.question046;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 按字节截取字符串
 *
 * 题目描述
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，
 * 应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * 输入描述:
 * 输入待截取的字符串及长度
 *
 * 输出描述:
 * 截取后的字符串
 *
 *
 * 示例1
 *
 * 输入
 * 我ABC汉DEF
 * 6
 *
 * 输出
 * 我ABC
 *
 * @author Jiajing Li
 * @date 2020-03-21 19:27:04
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int len = scanner.nextInt();

            char[] arr = str.toCharArray();

            StringBuilder res = new StringBuilder();
            for (char ch : arr) {
                int chLen = String.valueOf(ch).getBytes("GBK").length;
                if (len >= chLen) {
                    len -= chLen;
                    res.append(ch);
                } else {
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
