package com.siwuxie095.onlineprogramming.huawei.question031;

import java.util.Scanner;

/**
 * 单词倒排
 *
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 * 1、每个单词是以26个大写或小写英文字母构成；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，
 * 倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 * 输入描述:
 * 输入一行以空格来分隔的句子
 *
 * 输出描述:
 * 输出句子的逆序
 *
 *
 * 示例1
 *
 * 输入
 * I am a student
 *
 * 输出
 * student a am I
 *
 * @author Jiajing Li
 * @date 2020-02-09 10:33:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chArr = input.toCharArray();
            int index = -1;
            for (char ch : chArr) {
                index++;
                if (Character.isLetter(ch)) {
                    continue;
                }
                chArr[index] = ' ';
            }
            String[] strArr = new String(chArr).trim().split(" ");
            StringBuilder res = new StringBuilder();
            for (int i = strArr.length - 1; i >= 0; i--) {
                if (null == strArr[i] || "".equals(strArr[i])) {
                    continue;
                }
                res.append(strArr[i]);
                if (i != 0) {
                    res.append(" ");
                }
            }
            System.out.println(res);
        }
    }

}
