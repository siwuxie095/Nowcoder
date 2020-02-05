package com.siwuxie095.onlineprogramming.huawei.question027;

import java.util.*;

/**
 * 查找兄弟单词
 *
 * 题目描述
 * 实现一个可存储若干个单词的字典。用户可以：
 * （1）在字典中加入单词。
 * （2）查找指定单词在字典中的兄弟单词个数。
 * （3）查找指定单词的指定序号的兄弟单词，指定序号指字典中兄弟单词按照
 * 字典顺序排序后的序号。
 *
 * 定义，格式说明
 * 单词
 * 由小写英文字母组成，不含其他字符。
 * 兄弟单词
 * 给定一个单词 X，如果通过任意交换单词中的字母的位置得到不同的单词 Y，
 * 那么定义 Y 是 X 兄弟单词。
 * 字典顺序
 * 两个单词（字母按照自左向右顺序），先以第一个字母作为排序的基准，如果
 * 第一个字母相同，就用第二个字母为基准，如果第二个字母相同就以第三个字
 * 母为基准。依次类推，如果到某个字母不相同，字母顺序在前的那个单词顺序
 * 在前。如果短单词是长单词从首字母开始连续的一部分，短单词顺序在前。
 *
 * 规格：
 * （1）0 <= 字典中所含单词个数 <= 1000
 * （2）1 <= 单词所含字母数 <= 50
 * 测试用例保证，接口中输入不会超出如上约束。
 *
 *
 * 输入描述:
 * 先输入字典中单词的个数 n，再输入 n 个单词作为字典单词。
 * 输入一个单词，查找其在字典中兄弟单词的个数
 * 再输入数字 k，查找第 k 个兄弟单词
 *
 * 输出描述:
 * 根据输入，输出查找到的兄弟单词的个数和第 k 个兄弟单词
 *
 *
 * 示例1
 *
 * 输入
 * 3 abc bca cab abc 1
 *
 * 输出
 * 2
 * bca
 *
 * @author Jiajing Li
 * @date 2020-02-05 15:31:51
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            List<String> sourceList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                sourceList.add(scanner.next());
            }
            Collections.sort(sourceList);
            String target = scanner.next();
            int index = scanner.nextInt();

            List<String> brotherList = new ArrayList<>();
            for (String source : sourceList) {
                if (isBrother(source, target)) {
                    brotherList.add(source);
                }
            }
            System.out.println(brotherList.size());
            if (brotherList.size() >0 && index <= brotherList.size()) {
                System.out.println(brotherList.get(index - 1));
            }

        }
    }

    private static boolean isBrother(String source, String target) {
        if (source.equals(target)) {
            return false;
        }
        if (source.length() != target.length()) {
            return false;
        }
        char[] sArr = source.toCharArray();
        char[] tArr = target.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return new String(sArr).equals(new String(tArr));
    }

}
