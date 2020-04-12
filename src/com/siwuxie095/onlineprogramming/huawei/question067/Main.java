package com.siwuxie095.onlineprogramming.huawei.question067;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 24点游戏算法
 *
 * 题目描述
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字]
 * 输出：
 * true or false
 *
 * 输入描述:
 * 输入4个int整数
 *
 * 输出描述:
 * 返回能否得到24点，能输出true，不能输出false
 *
 *
 * 示例1
 *
 * 输入
 * 7 2 1 10
 *
 * 输出
 * true
 *
 * @author Jiajing Li
 * @date 2020-04-12 19:44:45
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int third = scanner.nextInt();
            int fourth = scanner.nextInt();

            boolean flag = false;
            for (String pos1 : list) {
                for (String pos2 : list) {
                    for (String pos3 : list) {
                        String expression = first + pos1 + second + pos2 + third + pos3 + fourth;
                        if (judge(expression)) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(flag);
        }
    }

    private static boolean judge(String expr) {
        // only one negative number.
        if (expr.contains("-")) {
            if (!expr.contains("*") && !expr.contains("/") && !expr.contains("+")) {
                if (expr.indexOf("-") == expr.lastIndexOf("-")) {
                    return false;
                }
            }
        }
        int index;
        if ((index = expr.indexOf("*")) != -1) {
            expr = calculate(expr, index, "*");
            return judge(expr);
        } else if ((index = expr.indexOf("/")) != -1) {
            expr = calculate(expr, index, "/");
            return judge(expr);
        } else if ((index = expr.indexOf("+")) != -1) {
            expr = calculate(expr, index, "+");
            return judge(expr);
        } else if ((index = expr.indexOf("-")) != -1) {
            expr = calculate(expr, index, "-");
            return judge(expr);
        }
        return Integer.parseInt(expr) == 24;
    }

    private static String calculate(String expr, int index, String operator) {
        char[] arr = expr.toCharArray();
        boolean flag = true;

        StringBuilder firstBuilder = new StringBuilder();
        int first;
        StringBuilder before = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            if (Character.isDigit(arr[i]) && flag) {
                firstBuilder.append(arr[i]);
            } else {
                flag = false;
                before.append(arr[i]);
            }
        }
        first = Integer.parseInt(firstBuilder.reverse().toString());

        flag = true;
        StringBuilder secondBuilder = new StringBuilder();
        int second;
        StringBuilder after = new StringBuilder();
        for (int i = index + 1; i < arr.length; i++) {
            if (Character.isDigit(arr[i]) && flag) {
                secondBuilder.append(arr[i]);
            } else {
                flag = false;
                after.append(arr[i]);
            }
        }
        second = Integer.parseInt(secondBuilder.toString());

        int res = 0;
        if ("*".equals(operator)) {
            res = first * second;
        } else if ("/".equals(operator)) {
            res = first / second;
        } else if ("+".equals(operator)) {
            res = first + second;
        } else if ("-".equals(operator)) {
            res = first - second;
        }


        return before.reverse().toString() + String.valueOf(res) + after.toString();
    }

}
