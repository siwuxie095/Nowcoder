package com.siwuxie095.onlineprogramming.huawei.question042;

import java.util.Scanner;

/**
 * 学英语
 *
 * 题目描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * 如22：twenty two，123：one hundred and twenty three。
 *
 * 说明：
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 *
 * 输出格式为 twenty two；
 * 非法数据请返回 “error”；
 * 关键字提示：and，billion，million，thousand，hundred。
 * 方法原型：public static String parse(long num)
 *
 *
 * 输入描述:
 * 输入一个long型整数
 * 输出描述:
 * 输出相应的英文写法
 *
 *
 * 示例1
 *
 * 输入
 * 2356
 *
 * 输出
 * two thousand three hundred and fifty six
 *
 * @author Jiajing Li
 * @date 2020-03-15 21:36:05
 */
public class Main {

    private static final long ONE_BILLION = 10_0000_0000;
    private static final long ONE_MILLION = 100_0000;
    private static final long ONE_THOUSAND = 1000;
    private static final long ONE_HUNDRED = 100;
    private static final long TWENTY = 20;
    private static final long TEN = 10;
    private static final long ZERO = 0;
    private static final String[] FIRST_CONFIG = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] SECOND_CONFIG = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] THIRD_CONFIG = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            long num = scanner.nextLong();

            StringBuilder res = new StringBuilder();
            if (num < 0) {
                System.out.println("error");
            }
            if (num == 0) {
                System.out.println("zero");
            }

            if (num >= ONE_BILLION) {
                res.append(parse(num / ONE_BILLION));
                res.append(" billion ");
                num = num % ONE_BILLION;
            }
            if (num >= ONE_MILLION) {
                res.append(parse(num / ONE_MILLION));
                res.append(" million ");
                num = num % ONE_MILLION;
            }
            if (num >= ONE_THOUSAND) {
                res.append(parse(num / ONE_THOUSAND));
                res.append(" thousand ");
                num = num % ONE_THOUSAND;
            }
            if (num >= ONE_HUNDRED) {
                res.append(parse(num / ONE_HUNDRED));
                res.append(" hundred and ");
                num = num % ONE_HUNDRED;
            }
            if (num >= ZERO) {
                res.append(parse(num));
                System.out.println(res.toString().trim());
            }
        }
    }

    private static String parse(long num) {
        StringBuilder res = new StringBuilder();
        if (num >= ONE_HUNDRED) {
            res.append(FIRST_CONFIG[(int) (num / ONE_HUNDRED)]);
            res.append(" hundred and ");
            num = num % ONE_HUNDRED;
        }
        if (num >= TWENTY) {
            res.append(THIRD_CONFIG[(int) (num / TEN)]);
            res.append(" ");
            num = num % TEN;
            if (num > ZERO) {
                res.append(FIRST_CONFIG[(int) num]);
            }
        } else {
            if (num >= TEN) {
                res.append(SECOND_CONFIG[(int) (num % TEN)]);
            } else if (num > ZERO) {
                res.append(FIRST_CONFIG[(int) num]);
            }
        }
        return res.toString().trim();
    }

}
