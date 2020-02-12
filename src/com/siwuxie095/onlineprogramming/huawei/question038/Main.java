package com.siwuxie095.onlineprogramming.huawei.question038;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求小球落地 5 次后所经历的路程和第 5 次反弹的高度
 *
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下,
 * 求它在第 5 次落地时，共经历多少米?第 5 次反弹多高？
 *
 * 输入描述:
 * 输入起始高度，int 型
 *
 * 输出描述:
 * 分别输出第 5 次落地时，共经过多少米第 5 次反弹多高
 *
 *
 * 示例1
 *
 * 输入
 * 1
 *
 * 输出
 * 2.875
 * 0.03125
 *
 * @author Jiajing Li
 * @date 2020-02-12 15:13:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int initHeight = scanner.nextInt();
            System.out.println(getAllDistance(new BigDecimal(initHeight), 5));
            System.out.println(getReboundHeight(new BigDecimal(initHeight), 5));
        }
    }

    private static String getAllDistance(BigDecimal initHeight, int times) {
        if (times == 1) {
            return initHeight.toString();
        }
        if (times == 2) {
            return initHeight.multiply(new BigDecimal(2)).toString();
        }
        BigDecimal res = initHeight.multiply(new BigDecimal(2));
        for (int i = 3; i <= times; i++) {
            // res += initHeight / (2 ^ (i - 2))
            res = res.add(initHeight.divide(new BigDecimal((int) Math.pow(2, i - 2))));
        }
        return res.toString();
    }

    private static String getReboundHeight(BigDecimal initHeight, int times) {
        return initHeight.divide(new BigDecimal((int) Math.pow(2, times))).toString();
    }



}
