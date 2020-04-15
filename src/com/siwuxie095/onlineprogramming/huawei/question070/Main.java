package com.siwuxie095.onlineprogramming.huawei.question070;

import java.util.Scanner;
import java.util.Stack;

/**
 * 矩阵乘法计算量估算
 *
 * 题目描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 *
 * 例如：
 *     A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 *
 * 计算A*B*C有两种顺序：((AB)C) 或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 *
 * 编写程序计算不同的计算顺序需要进行的乘法次数
 *
 * 输入描述:
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 *
 * 输出描述:
 * 输出需要进行的乘法次数
 *
 *
 * 示例1
 *
 * 输入
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 *
 * 输出
 * 3500
 *
 *
 * @author Jiajing Li
 * @date 2020-04-15 09:22:18
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int[][] arr = new int[count][2];
            for (int i = 0; i < count; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            String law = scanner.next();
            Stack<Character> lawStack = new Stack<>();
            Stack<int[]> matrixStack = new Stack<>();
            int index = 0;
            int res = 0;
            for (char ch : law.toCharArray()) {
                if (isRightBracket(ch)) {
                    res += calculate(lawStack, matrixStack);
                } else {
                    if (isLetter(ch)) {
                        lawStack.push(ch);
                        matrixStack.push(arr[index]);
                        index++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static int calculate(Stack<Character> lawStack, Stack<int[]> matrixStack) {
        /*
         * test data exists this situation: right bracket count is more than left bracket count, so add the judgement.
         *
         * example:
         *
         * 8
         * 61 4
         * 4 43
         * 43 52
         * 52 24
         * 24 29
         * 29 37
         * 37 23
         * 23 16
         * (A(B(C(D(E(F(GH))))))))
         */
        if (lawStack.size() == 1) {
            return 0;
        }
        lawStack.pop();
        Character ch = lawStack.pop();
        lawStack.push(ch);
        int[] second = matrixStack.pop();
        int[] first = matrixStack.pop();
        int[] arr = new int[2];
        arr[0] = first[0];
        arr[1] = second[1];
        matrixStack.push(arr);
        return first[0] * first[1] * second[1];
    }

    private static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    private static boolean isLeftBracket(char ch) {
        return ch == '(';
    }

    private static boolean isRightBracket(char ch) {
        return ch == ')';
    }


}
