package com.siwuxie095.onlineprogramming.huawei.question18th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 识别有效的IP地址和掩码并进行分类统计
 *
 * 题目描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照 A/B/C/D/E 类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 *
 * A类地址 1.0.0.0~126.255.255.255;
 *
 * B类地址 128.0.0.0~191.255.255.255;
 *
 * C类地址 192.0.0.0~223.255.255.255;
 *
 * D类地址 224.0.0.0~239.255.255.255；
 *
 * E类地址 240.0.0.0~255.255.255.255
 *
 *
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 *
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 *
 * 示例1
 *
 * 输入
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 *
 * 输出
 * 1 0 1 0 0 2 1
 *
 * @author Jiajing Li
 * @date 2019-12-22 23:24:30
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int eCount = 0;
        int wrongCount = 0;
        int privateCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input = br.readLine()) != null){
            if ("".equals(input)) {
                break;
            }
            String ip = input.split("~")[0];
            String subnetMask = input.split("~")[1];

            if (isValidIp(ip) && isValidMask(subnetMask)) {
                String[] arr = ip.split("\\.");
                int first = Integer.parseInt(arr[0]);
                int second = Integer.parseInt(arr[1]);
                if (first >= 1 && first <= 126) {
                    aCount++;
                } else if (first >= 128 && first <= 191) {
                    bCount++;
                } else if (first >= 192 && first <= 223) {
                    cCount++;
                } else if (first >= 224 && first <= 239) {
                    dCount++;
                } else if (first >= 240 && first <= 255) {
                    eCount++;
                }

                if (first == 10
                        || first == 172 && second >= 16 && second <= 31 ||
                        first == 192 && second == 168) {
                    privateCount++;
                }
            } else {
                wrongCount++;
            }
        }

        System.out.println(aCount + " " + bCount + " " + cCount + " " + dCount + " " + eCount + " " + wrongCount + " " + privateCount);
    }

    private static boolean isValidIp(String ip) {
        String[] arr = ip.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (String val : arr) {
            if (nonDigit(val)) {
                return false;
            }
            int num = Integer.parseInt(val);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidMask(String subnetMask) {
        String[] arr = subnetMask.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        String binaryStr = "";
        for (String val : arr) {
            if (nonDigit(val)) {
                return false;
            }
            int num = Integer.parseInt(val);
            if (num < 0 || num > 255) {
                return false;
            }
            binaryStr += transferToBinary(num);
        }
        if (binaryStr.indexOf('0') != -1 && binaryStr.indexOf('0') < binaryStr.lastIndexOf('1')) {
            return false;
        }
        return true;
    }

    private static boolean nonDigit(String val) {
        try {
            new BigDecimal(val);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static String transferToBinary(int num) {
        String res = "";
        while (num != 0) {
            int remainder = num % 2;
            num = num / 2;
            res = remainder + res;
        }
        // just add one zero before the result
        if (res.length() < 8) {
            res = "0" + res;
        }
        return res;
    }




}
