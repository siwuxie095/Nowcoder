package com.siwuxie095.onlineprogramming.swordtooffer.question044;

/**
 * JZ44 翻转单词序列
 *
 * 题目描述
 * 牛客最近来了一个新员工 Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事 Cat 对 Fish
 * 写的内容颇感兴趣，有一天他向 Fish 借来翻看，但却读不懂它的意思。例如，“nowcoder. a am I”。后
 * 来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是 “I am a nowcoder.”。Cat 对一一
 * 的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *
 * 示例1
 *
 * 输入
 * "nowcoder. a am I"
 *
 * 返回值
 * "I am a nowcoder."
 *
 * @author Jiajing Li
 * @date 2021-05-11 19:54:02
 */
@SuppressWarnings("all")
public class Solution {


    public String ReverseSentence(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        String[] arr = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(arr[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }

}
