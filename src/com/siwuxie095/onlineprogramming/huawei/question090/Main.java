package com.siwuxie095.onlineprogramming.huawei.question090;

import java.util.Scanner;

/**
 * 合法IP
 *
 * 题目描述
 * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，
 * 表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址
 * 串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 *
 * 输入描述:
 * 输入一个ip地址
 *
 * 输出描述:
 * 返回判断的结果YES or NO
 *
 *
 * 示例1
 *
 * 输入
 * 10.138.15.1
 *
 * 输出
 * YES
 *
 * @author Jiajing Li
 * @date 2020-05-19 10:01:25
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] ip = null;
            try {
                ip = input.split("\\.");
            } catch (Exception e) {
                System.out.println("NO");
            }
            boolean flag = true;
            for (String segment : ip) {
                if (isIllegal(segment)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isIllegal(String segment) {
        for (char ch : segment.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return true;
            }
        }
        if (Integer.parseInt(segment) < 0 || Integer.parseInt(segment) > 255) {
            return true;
        }
        return false;
    }

}
