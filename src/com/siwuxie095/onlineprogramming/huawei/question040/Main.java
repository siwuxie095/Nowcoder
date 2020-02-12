package com.siwuxie095.onlineprogramming.huawei.question040;

import java.util.Scanner;

/**
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 *
 * 题目描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 *
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 *
 * 示例1
 * 输入
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 *
 * 输出
 * 26
 * 3
 * 10
 * 12
 *
 * @author Jiajing Li
 * @date 2020-02-12 23:00:49
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int letter = 0;
            int space = 0;
            int digit = 0;
            int other = 0;
            for (char ch : str.toCharArray()) {
                if (Character.isLetter(ch)) {
                    letter++;
                } else if (ch == ' ') {
                    space++;
                } else if (Character.isDigit(ch)) {
                    digit++;
                } else {
                    other++;
                }
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(digit);
            System.out.println(other);
        }
    }

}
