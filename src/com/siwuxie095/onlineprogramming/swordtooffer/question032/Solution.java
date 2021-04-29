package com.siwuxie095.onlineprogramming.swordtooffer.question032;

import java.util.ArrayList;
import java.util.Collections;

/**
 * JZ32 把数组排成最小的数
 *
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 *
 *
 * 示例1
 *
 * 输入
 * [3,32,321]
 *
 * 返回值
 * "321323"
 *
 * @author Jiajing Li
 * @date 2021-04-29 13:49:41
 */
@SuppressWarnings("all")
public class Solution {

    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }

        Collections.sort(list, (o1, o2) -> {
            int i = 0;
            int j = 0;
            while (i < o1.length() || j < o2.length()) {
                if (j == o2.length()) {
                    j -= o2.length();
                }
                if (i == o1.length()) {
                    i -= o1.length();
                }
                if (o1.charAt(i) < o2.charAt(j)) {
                    return -1;
                } else if (o1.charAt(i) > o2.charAt(j)) {
                    return 1;
                }
                i++;
                j++;
            }
            return 0;
        });

        StringBuilder res = new StringBuilder();
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }

}
