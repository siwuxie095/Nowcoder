package com.siwuxie095.onlineprogramming.huawei.question072;

import java.util.Scanner;

/**
 * 百钱买百鸡问题
 *
 * 题目描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
 * 百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 *
 *
 * 输入描述:
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述:
 *
 *
 *
 * 示例1
 *
 * 输入
 * 1
 *
 * 输出
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 *
 * @author Jiajing Li
 * @date 2020-05-10 16:03:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int firstPrice = 5;
            int secondPrice = 3;
            int thirdPriceMultiplyThree = 1;

            int totalPrice = 100;
            int totalCount = 100;
            for (int firstCount = 0; firstCount <= totalPrice / firstPrice; firstCount++) {
                for (int secondCount = 0; secondCount <= totalPrice / secondPrice; secondCount++) {
                    for (int thirdCount = 0; thirdCount <= totalPrice / thirdPriceMultiplyThree * 3; thirdCount += 3) {
                        if (firstCount + secondCount + thirdCount == totalCount
                                && firstCount * firstPrice + secondCount * secondPrice + thirdCount * thirdPriceMultiplyThree / 3 == totalPrice) {
                            System.out.println(firstCount + " " + secondCount + " " + thirdCount);
                        }
                    }
                }
            }
        }
    }

}
