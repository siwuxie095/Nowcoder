package com.siwuxie095.onlineprogramming.huawei.question029;

import java.util.Scanner;

/**
 * 字符串加解密
 *
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,
 * 如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 *
 * 接口描述：
 * 实现接口，每个接口实现1个基本操作：
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 *
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 *
 *
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 *
 * 示例1
 *
 * 输入
 * abcdefg
 * BCDEFGH
 *
 * 输出
 * BCDEFGH
 * abcdefg
 *
 * @author Jiajing Li
 * @date 2020-02-06 11:11:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String pendingEncrypt = scanner.nextLine();
            String pendingDecrypt = scanner.nextLine();
            encrypt(pendingEncrypt.toCharArray());
            decrypt(pendingDecrypt.toCharArray());
        }
    }

    private static void encrypt(char[] arr) {
        StringBuilder res = new StringBuilder();
        for (char ch : arr) {
            if (Character.isLetter(ch)) {
                if (ch >= 'a' && ch <= 'z') {
                    res.append(ch == 'z' ? 'A' : Character.toUpperCase((char) (ch + 1)));
                } else {
                    res.append(ch == 'Z' ? 'a' : Character.toLowerCase((char) (ch + 1)));
                }
            } else {
                res.append(ch == '9' ? '0' : ch + 1);
            }
        }
        System.out.println(res.toString());
    }


    private static void decrypt(char[] arr) {
        StringBuilder res = new StringBuilder();
        for (char ch : arr) {
            if (Character.isLetter(ch)) {
                if (ch >= 'a' && ch <= 'z') {
                    res.append(ch == 'a' ? 'Z' : Character.toUpperCase((char) (ch - 1)));
                } else {
                    res.append(ch == 'A' ? 'z' : Character.toLowerCase((char) (ch - 1)));
                }
            } else {
                res.append(ch == '0' ? '9' : ch - 1);
            }
        }
        System.out.println(res.toString());
    }


}
