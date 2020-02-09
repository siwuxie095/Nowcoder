package com.siwuxie095.onlineprogramming.huawei.question032;

import java.util.Scanner;

/**
 * 整数与IP地址间的转换
 *
 * 题目描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，
 * 然后把这个二进制数转变成一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，
 * 即该IP地址转换后的数字就是它了。
 *
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 *
 * 示例1
 *
 * 输入
 * 10.0.3.193
 * 167969729
 *
 * 输出
 * 167773121
 * 10.3.3.193
 *
 * @author Jiajing Li
 * @date 2020-02-09 12:08:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String decimal = scanner.nextLine();
            System.out.println(convertIpToDecimal(ip));
            System.out.println(convertDecimalToIp(decimal));
        }
    }


    private static String convertIpToDecimal(String ip) {
        String[] arr = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String val : arr) {
            String binary = Integer.toBinaryString(Integer.parseInt(val));
            builder.append(replenish(binary, 8));
        }
        return toDecimalString(builder.toString());
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

    private static String convertDecimalToIp(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        binary = replenish(binary, 32);

        StringBuilder builder = new StringBuilder();
        builder.append(toDecimalString(binary.substring(0, 8)));
        builder.append(".");
        builder.append(toDecimalString(binary.substring(8, 16)));
        builder.append(".");
        builder.append(toDecimalString(binary.substring(16, 24)));
        builder.append(".");
        builder.append(toDecimalString(binary.substring(24, 32)));
        return builder.toString();
    }

}
