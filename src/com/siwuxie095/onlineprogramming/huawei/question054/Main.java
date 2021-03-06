package com.siwuxie095.onlineprogramming.huawei.question054;

import java.util.Scanner;
import java.util.Stack;


/**
 * 表达式求值
 *
 * 题目描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串
 * 内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 *
 * 输入描述:
 * 输入算术表达式
 *
 * 输出描述:
 * 计算出结果值
 *
 *
 * 示例1
 *
 * 输入
 * 400+5
 *
 * 输出
 * 405
 *
 * @author Jiajing Li
 * @date 2020-03-22 21:44:06
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            System.out.println(doCalculate(expression));
        }
    }

    private static String doCalculate(String expression) {
        char[] arr = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        parse(arr, stack);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return calculate(builder.reverse().toString());
    }

    private static void parse(char[] arr, Stack<Character> stack) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == ')' || arr[index] == ']' || arr[index] == '}') {
                StringBuilder tmp = new StringBuilder();
                char popCh;
                while ((popCh = stack.pop()) != '(' && popCh != '[' && popCh != '{') {
                    tmp.append(popCh);
                }
                String res = calculate(tmp.reverse().toString());
                for (char resCh : res.toCharArray()) {
                    stack.push(resCh);
                }
            } else {
                stack.push(arr[index]);
            }

        }
    }

    private static String calculate(String srcStr) {
        int index;
        String newStr;
        if ((index = srcStr.indexOf('*')) != -1) {
            newStr = partCalculate(srcStr, index, "*");
            return calculate(newStr);
        } else if ((index = srcStr.indexOf('/')) != -1) {
            newStr = partCalculate(srcStr, index, "/");
            return calculate(newStr);
        } else if ((index = srcStr.indexOf('+')) != -1) {
            newStr = partCalculate(srcStr, index, "+");
            return calculate(newStr);
        } else if ((index = srcStr.indexOf('-')) != -1) {
            newStr = partCalculate(srcStr, index, "-");
            return calculate(newStr);
        }
        return srcStr;
    }

    private static String partCalculate(String srcStr, int index, String operator) {
        int firstOperand = 0;
        int secondOperand = 0;
        StringBuilder firstBuilder = new StringBuilder();
        StringBuilder secondBuilder = new StringBuilder();
        StringBuilder frontBuilder = new StringBuilder();
        StringBuilder backBuilder = new StringBuilder();

        char[] arr = srcStr.toCharArray();
        int front;
        for (front = index - 1; front >= 0; front--) {
            // special: negative number
            if (!Character.isDigit(arr[front]) && arr[front] != '-') {
                break;
            }
            firstBuilder.append(arr[front]);
        }
        for (; front >= 0; front--) {
            frontBuilder.append(arr[front]);
        }

        int back;
        for (back = index + 1; back < arr.length; back++) {
            if (!Character.isDigit(arr[back])) {
                break;
            }
            secondBuilder.append(arr[back]);
        }
        for (; back < arr.length; back++) {
            backBuilder.append(arr[back]);
        }


        firstOperand = Integer.parseInt(firstBuilder.reverse().toString());
        secondOperand = Integer.parseInt(secondBuilder.toString());

        String res = "";
        if (operator.equals("*")) {
            res = String.valueOf(firstOperand * secondOperand);
        }
        if (operator.equals("/")) {
            res = String.valueOf(firstOperand / secondOperand);
        }
        if (operator.equals("+")) {
            res = String.valueOf(firstOperand + secondOperand);
        }
        if (operator.equals("-")) {
            res = String.valueOf(firstOperand - secondOperand);
        }
        return frontBuilder.reverse().toString() + res + backBuilder.toString();
    }

}

