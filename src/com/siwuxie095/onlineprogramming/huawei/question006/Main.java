package com.siwuxie095.onlineprogramming.huawei.question006;

import java.util.Scanner;

/**
 * 质数因子
 *
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * 输入参数：
 * long ulDataInput：输入的正整数
 * 返回值：
 * String
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 *
 * 示例1
 *
 * 输入
 * 180
 *
 * 输出
 * 2 2 3 3 5
 *
 * @author Jiajing Li
 * @date 2019-11-30 17:46:49
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        while (val != 1) {
            for (int i = 2; i <= val; i++) {
                if (val % i == 0) {
                    val /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }

}
