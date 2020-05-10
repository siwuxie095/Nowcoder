package com.siwuxie095.onlineprogramming.huawei.question073;

import java.util.Scanner;

/**
 * 计算日期到天数转换
 *
 * 题目描述
 * 根据输入的日期，计算是这一年的第几天。
 *
 * 详细描述：
 * 输入某年某月某日，判断这一天是这一年的第几天。
 *
 *
 * 输入描述:
 * 输入三行，分别是年，月，日
 *
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 * 失败:返回-1
 *
 *
 * 示例1
 *
 * 输入
 * 2012
 * 12
 * 31
 *
 * 输出
 * 366
 *
 * @author Jiajing Li
 * @date 2020-05-10 16:41:39
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            if (year < 0 || (month < 1 || month > 12) || (day < 1 || day > 31)) {
                System.out.println(-1);
            } else {
                calculate(year, day, month);
            }

        }

    }

    private static void calculate(int year, int day, int month) {
        boolean isLeapYear = year % 4 == 0;
        int count = 0;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                count += (isLeapYear ? 29 : 28);
            } else {
                boolean isThirtyOneDays = i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12;
                count += isThirtyOneDays ? 31 : 30;
            }
        }
        System.out.println(count + day);
    }

}

