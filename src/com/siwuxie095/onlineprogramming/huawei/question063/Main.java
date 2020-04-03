package com.siwuxie095.onlineprogramming.huawei.question063;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * DNA序列
 *
 * 题目描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总
 * 的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio可能
 * 是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 *
 *
 * 示例1
 *
 * 输入
 * AACTGTGCACGACCTGA
 * 5
 *
 * 输出
 * GCACG
 *
 * @author Jiajing Li
 * @date 2020-04-01 15:30:39
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int len = str.length();
            int subLen = scanner.nextInt();
            Map<Double, String> map = new HashMap<>();
            for (int i = 0; i < len - subLen; i++) {
                String subStr = str.substring(i, i + subLen);
                int gcCount = 0;
                for (char ch : subStr.toCharArray()) {
                    if (ch == 'G' || ch == 'C') {
                        gcCount++;
                    }
                }
                map.putIfAbsent((double) gcCount / (double) len, subStr);
            }
            Double maxKey = Collections.max(map.keySet());
            System.out.println(map.get(maxKey));
        }
    }

}
