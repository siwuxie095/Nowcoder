package com.siwuxie095.onlineprogramming.swordtooffer.question053;

/**
 * JZ53 表示数值的字符串
 *
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串 "+100","5e2","-123","3.1416"
 * 和 "-1E-16" 都表示数值。但是 "12e","1a3.14","1.2.3","+-5" 和 "12e+4.3" 都不是。
 *
 *
 * 示例1
 *
 * 输入
 * "123.45e+6"
 *
 * 返回值
 * true
 *
 *
 * 示例2
 *
 * 输入
 * "1.2.3"
 *
 * 返回值
 * false
 *
 * @author Jiajing Li
 * @date 2021-05-14 17:42:47
 */
@SuppressWarnings("all")
public class Solution {

    public boolean isNumeric (String str) {
        boolean numflag = false;
        boolean eflag =  false;
        boolean symflag = false;
        boolean pflag = false;

        char[]chars = str.toCharArray();

        for (int i = 0; i<chars.length; i++) {
            if (chars[i] <= '9' && chars[i]>='0') {
                numflag = true;
                continue;
            }
            if ((chars[i] == 'e' || chars[i] == 'E') && !eflag && numflag) {
                eflag = true;
                numflag = false;
                continue;
            }
            if (chars[i] == '.' && !pflag && !eflag) {
                pflag = true;
                continue;
            }
            if ((chars[i] == '+' || chars[i] == '-') && (i == 0 || chars[i-1] == 'e' || chars[i-1] == 'E')) {
                continue;
            }
            return false;
        }
        return numflag;
    }

}
