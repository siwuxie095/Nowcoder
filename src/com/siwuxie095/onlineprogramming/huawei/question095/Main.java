package com.siwuxie095.onlineprogramming.huawei.question095;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 人民币转换
 *
 * 题目描述
 * 考试题目和要点：
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、
 * 拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。
 * 在”角“和”分“后面不写”整字。（30分）
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只
 * 写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 *
 *
 * 输入描述:
 * 输入一个double数
 *
 * 输出描述:
 * 输出人民币格式
 *
 *
 * 示例1
 *
 * 输入
 * 151121.15
 *
 * 输出
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 *
 * @author Jiajing Li
 * @date 2020-05-20 10:54:27
 */
public class Main {

    private static final String PREFIX = "人民币";

    private static final String SUFFIX = "整";

    private static final String[] FIRST_CONFIG = new String[] {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", };

    private static final String[] SECOND_CONFIG = new String[] {"零", "拾", "贰拾", "叁拾", "肆拾", "伍拾", "陆拾", "柒拾", "捌拾", "玖拾"};

    private static final int ONE_HUNDRED_MILLION = 100_000_000;

    private static final int TEN_THOUSAND = 10_000;

    private static final int ONE_THOUSAND = 1_000;

    private static final int ONE_HUNDRED = 1_00;

    private static final int TEN = 10;

    private static final int ONE = 1;

    private static final int ZERO = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String value = scanner.next();
            boolean hasSuffix = hasSuffix(value);
            int integerPart = Integer.parseInt(value.split("\\.")[0]);
            String decimalPart = value.split("\\.")[1];
            StringBuilder builder = new StringBuilder();
            if (integerPart >= ONE_HUNDRED_MILLION) {
                parseIntegerPart(integerPart / ONE_HUNDRED_MILLION, builder);
                builder.append("亿");
                integerPart = integerPart % ONE_HUNDRED_MILLION;
            }
            if (integerPart >= TEN_THOUSAND) {
                parseIntegerPart(integerPart / TEN_THOUSAND, builder);
                builder.append("万");
                integerPart = integerPart % TEN_THOUSAND;
            }
            if (integerPart > ZERO) {
                parseIntegerPart(integerPart, builder);
                builder.append("元");
            }
            if (hasSuffix) {
                parseDecimalPart(decimalPart, builder);
            }
            postDeal(builder);
            String res = PREFIX + builder.toString() + (hasSuffix ? "" : SUFFIX);
            System.out.println(res);

        }
    }


    private static boolean hasSuffix(String value) {
        return new BigDecimal(value.split("\\.")[1]).compareTo(BigDecimal.ZERO) != 0;
    }

    private static void parseIntegerPart(int integerPart, StringBuilder builder) {
        boolean nonExistedOneThousand = true;
        boolean nonExistedOneHundred = true;
        boolean nonExistedTen = true;
        if (integerPart >= ONE_THOUSAND) {
            append(FIRST_CONFIG[integerPart / ONE_THOUSAND], builder);
            builder.append("仟");
            integerPart = integerPart % ONE_THOUSAND;
            nonExistedOneThousand = false;
        }
        if (nonExistedOneThousand) {
            append(FIRST_CONFIG[0], builder);
        }
        if (integerPart >= ONE_HUNDRED) {
            append(FIRST_CONFIG[integerPart / ONE_HUNDRED], builder);
            builder.append("佰");
            integerPart = integerPart % ONE_HUNDRED;
            nonExistedOneHundred = false;
        }
        if (nonExistedOneHundred) {
            append(FIRST_CONFIG[0], builder);
        }

        if (integerPart >= TEN) {
            append(SECOND_CONFIG[integerPart / TEN], builder);
            integerPart = integerPart % TEN;
            nonExistedTen = false;
        }
        if (nonExistedTen) {
            append(FIRST_CONFIG[0], builder);
        }
        if (integerPart >= ONE) {
            append(FIRST_CONFIG[integerPart], builder);
        }
    }

    private static void append(String str, StringBuilder builder) {
        builder.append(str);
    }

    private static void parseDecimalPart(String decimalPart, StringBuilder builder) {
        char[] arr = decimalPart.toCharArray();
        int firstIndex = Integer.parseInt(String.valueOf(arr[0]));
        if (firstIndex > 0) {
            builder.append(FIRST_CONFIG[firstIndex]);
            builder.append("角");
        }
        int secondIndex = Integer.parseInt(String.valueOf(arr[1]));
        if (secondIndex > 0) {
            builder.append(FIRST_CONFIG[secondIndex]);
            builder.append("分");
        }
    }

    private static void postDeal(StringBuilder builder) {
        dealFirstZero(builder);
        dealSerialZero(builder, 0, 1);
        dealZeroBeforeUnit(builder, "亿");
        dealZeroBeforeUnit(builder, "万");
        dealZeroBeforeUnit(builder, "元");
    }


    private static void dealFirstZero(StringBuilder builder) {
        if (builder.indexOf(FIRST_CONFIG[0]) == 0) {
            builder.deleteCharAt(0);
            dealFirstZero(builder);
        }
    }

    private static void dealSerialZero(StringBuilder builder, int index1, int index2) {
        if (Math.abs(builder.indexOf(FIRST_CONFIG[0], index1) - builder.indexOf(FIRST_CONFIG[0], index2)) == 1) {
            builder.deleteCharAt(index1);
            dealSerialZero(builder, index1, index2);
        } else {
            if (builder.indexOf(FIRST_CONFIG[0], index1) == -1 || builder.indexOf(FIRST_CONFIG[0], index2) == -1) {
                return;
            }
            index1++;
            index2++;
            dealSerialZero(builder, index1, index2);
        }
    }


    private static void dealZeroBeforeUnit(StringBuilder builder, String unit) {
        int index = builder.indexOf(unit);
        if (index != -1) {
            if (builder.charAt(index - 1) == '零') {
                builder.deleteCharAt(index - 1);
            }
        }
    }

}
