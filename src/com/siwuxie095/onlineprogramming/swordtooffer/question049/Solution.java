package com.siwuxie095.onlineprogramming.swordtooffer.question049;

import java.math.BigDecimal;

/**
 * JZ49 把字符串转换成整数
 *
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为 0 或者字符串不是一个合法的数值则返回 0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 返回值描述:
 * 如果是合法的数值表达则返回该数字，否则返回 0
 *
 *
 * 示例1
 *
 * 输入
 * "+2147483647"
 *
 * 返回值
 * 2147483647
 *
 *
 * 示例2
 *
 * 输入
 * "1a33"
 *
 * 返回值
 * 0
 *
 * @author Jiajing Li
 * @date 2021-05-13 19:44:17
 */
@SuppressWarnings("all")
public class Solution {

    public int StrToInt(String str) {
        BigDecimal val = null;
        try {
            val = new BigDecimal(str);
        } catch (Exception e) {}
        return null == val ? 0 : val.intValue();
    }

}
