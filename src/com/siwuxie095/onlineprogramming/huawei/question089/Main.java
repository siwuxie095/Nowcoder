package com.siwuxie095.onlineprogramming.huawei.question089;

import java.util.Scanner;

/**
 * 24点运算
 *
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，
 * 扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 *
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 *
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 *
 * 详细说明：
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过 +-/* 四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 *
 * 输入描述:
 * 输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
 *
 * 输出描述:
 * 如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 *
 *
 * 示例1
 *
 * 输入
 * A A A A
 *
 * 输出
 * NONE
 *
 * @author Jiajing Li
 * @date 2020-05-18 16:16:44
 */
public class Main {

    private static final int LENGTH = 4;
    private static final int TARGET = 24;
    private static final String[] ALL_CARDS = new String[] {"-1", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public static void main(String[] args) {
        int[] allCards = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.contains("joker") || input.contains("JOKER")) {
                System.out.println("ERROR");
            } else {
                int[] arr = new int[LENGTH];
                arr[0] = getValue(input.split(" ")[0]);
                arr[1] = getValue(input.split(" ")[1]);
                arr[2] = getValue(input.split(" ")[2]);
                arr[3] = getValue(input.split(" ")[3]);

                boolean none = true;
                for (int i = 0; i < LENGTH; i++) {
                    if (!none) {
                        break;
                    }
                    for (int j = 0; j < LENGTH; j++) {
                        if (!none) {
                            break;
                        }
                        if (j == i) {
                            continue;
                        }
                        for (int k = 0; k < LENGTH; k++) {
                            if (!none) {
                                break;
                            }
                            if (k == i || k == j) {
                                continue;
                            }
                            for (int l = 0; l < LENGTH; l++) {
                                if (l == i || l == j || l == k) {
                                    continue;
                                }
                                int[] num = new int[LENGTH];
                                num[0] = arr[i];
                                num[1] = arr[j];
                                num[2] = arr[k];
                                num[3] = arr[l];
                                int[] used = new int[LENGTH];
                                double res = 0.0D;
                                // init
                                res = num[0];
                                used[0] = 1;
                                if (judge(num, used, res, "")) {
                                    none = false;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (none) {
                    System.out.println("NONE");
                }
            }
        }
    }

    private static int getValue(String card) {
        int count = 0;
        for (String card0 : ALL_CARDS) {
            if (card0.equals(card)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    private static boolean judge(int[] num, int[] used, double res, String expression) {
        for (int i = 1; i < num.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                //if (expression.contains("4+7*4")) {
                //    System.out.println();
                //}
                if (judge(num, used, res + num[i], buildExpression(expression, res, num[i], "+"))
                        || judge(num, used, res - num[i], buildExpression(expression, res, num[i], "-"))
                        || judge(num, used, res * num[i], buildExpression(expression, res, num[i], "*"))
                        || judge(num, used, res / num[i], buildExpression(expression, res, num[i], "/"))) {
                    return true;
                }
                used[i] = 0;
            }
        }
        if (res == TARGET  && checkUsed(used)) {
            System.out.println(expression);
        }
        return res == TARGET && checkUsed(used);
    }

    private static boolean checkUsed(int[] used) {
        for (int val : used) {
            if (val == 0) {
                return false;
            }
        }
        return true;
    }

    private static String buildExpression(String expression, double res, int num, String operation) {
        return "".equals(expression) ? (res == 0 ? ALL_CARDS[num] : ALL_CARDS[(int) res] + operation + ALL_CARDS[num]) : expression + operation + ALL_CARDS[num];
    }

}
