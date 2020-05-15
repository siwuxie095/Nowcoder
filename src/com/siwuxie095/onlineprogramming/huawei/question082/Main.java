package com.siwuxie095.onlineprogramming.huawei.question082;

import java.util.Scanner;

/**
 * 将真分数分解为埃及分数
 *
 * 题目描述
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，
 * 请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 *
 *
 * 输入描述:
 * 输入一个真分数，String型
 *
 * 输出描述:
 * 输出分解后的string
 *
 *
 * 示例1
 *
 * 输入
 * 8/11
 *
 * 输出
 * 1/2+1/5+1/55+1/110
 *
 * @author Jiajing Li
 * @date 2020-05-15 10:55:33
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            int targetNumerator = Integer.parseInt(input.split("/")[0]);
            int targetDenominator = Integer.parseInt(input.split("/")[1]);
            StringBuilder res = new StringBuilder();
            int currentNumerator = 1;
            int currentDenominator = 2;

            while (true) {
                if (currentNumerator * targetDenominator <= targetNumerator * currentDenominator) {
                    res.append(currentNumerator);
                    res.append("/");
                    res.append(currentDenominator);
                    res.append("+");

                    if (currentNumerator * targetDenominator == targetNumerator * currentDenominator) {
                        break;
                    }

                    targetNumerator = targetNumerator * currentDenominator - currentNumerator * targetDenominator;
                    targetDenominator = targetDenominator * currentDenominator;
                }
                currentDenominator++;
            }
            String str = res.toString();
            System.out.println(str.substring(0, str.length() - 1));
        }

    }

}
