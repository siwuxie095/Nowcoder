package com.siwuxie095.onlineprogramming.huawei.question030;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串合并处理
 *
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 * 将输入的两个字符串合并。
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
 * 这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所
 * 代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，
 * 则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，
 * 也就是e。转换后的字符为大写‘E’。
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，
 * 排序后为“abcedf”，转换后为“5D37BF”
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出转化后的结果
 *
 *
 * 示例1
 *
 * 输入
 * dec fab
 *
 * 输出
 * 5D37BF
 *
 * @author Jiajing Li
 * @date 2020-02-12 16:33:11
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();
            String sum = first + second;
            char[] oddArr;
            char[] evenArr;
            if (sum.length() % 2 == 0) {
                oddArr = new char[sum.length() / 2];
                evenArr = new char[sum.length() / 2];
            } else {
                oddArr = new char[sum.length() / 2];
                evenArr = new char[sum.length() / 2 + 1];
            }
            boolean isEven = true;
            int oddIndex = 0;
            int evenIndex = 0;
            for (char ch : sum.toCharArray()) {
                if (isEven) {
                    evenArr[evenIndex++] = ch;
                    isEven = false;
                } else {
                    oddArr[oddIndex++] = ch;
                    isEven = true;
                }
            }
            Arrays.sort(oddArr);
            Arrays.sort(evenArr);

            StringBuilder res = new StringBuilder();
            oddIndex = 0;
            evenIndex = 0;
            for (int i = 0; i < sum.length(); i++) {
                char ch = (i % 2 == 0) ? evenArr[evenIndex++] : oddArr[oddIndex++];
                if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F') {
                    res.append(Character.toUpperCase(reverse(ch)));
                } else {
                    res.append(ch);
                }
            }
            System.out.println(res);
        }
    }

    private static char reverse(char ch) {
        ch = Character.toLowerCase(ch);
        String template = "0123456789abcdef";
        // hexadecimal to decimal, decimal to binary
        String binary = Integer.toBinaryString(template.indexOf(ch));
        binary = replenish(binary, 4);
        // reverse
        char[] arr = new char[binary.length()];
        int index = arr.length - 1;
        for (char loopCh : binary.toCharArray()) {
            arr[index--] = loopCh;
        }
        // binary to decimal, decimal to hexadecimal
        return template.charAt(Integer.parseInt(toDecimalString(new String(arr))));
    }

    private static String replenish(String binary, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("0");
        }
        String total = builder.toString();
        if (binary.length() > length) {
            return total;
        }
        char[] totalChArr = total.toCharArray();
        int index = totalChArr.length - 1;
        char[] binaryChArr = binary.toCharArray();
        for (int i = binaryChArr.length - 1; i >= 0; i--) {
            totalChArr[index--] = binaryChArr[i];
        }
        return new String(totalChArr);
    }

    private static String toDecimalString(String binary) {
        char[] arr = binary.toCharArray();
        int res = 0;
        int base = 2;
        int raised = binary.length() - 1;
        for (char ch : arr) {
            int val = Integer.parseInt(new String(new char[] {ch}));
            res += ((int) Math.pow(base, raised)) * val;
            raised--;
        }
        return String.valueOf(res);
    }

}
