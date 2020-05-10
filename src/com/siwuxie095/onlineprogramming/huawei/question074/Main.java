package com.siwuxie095.onlineprogramming.huawei.question074;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 参数解析
 *
 * 题目描述
 * 在命令行输入如下命令：
 * xcopy /s c:\ d:\，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\
 * 参数4: 字符串d:\
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 * 解析规则：
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入
 * xcopy /s "C:\program files" "d:\" 时，参数仍然是4个，第3个参数应该是字符
 * 串 C:\program files，而不是 C:\program，注意输出参数时，需要将""去掉，引号
 * 不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 *
 *
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 输出参数个数，分解后的参数，每个参数都独占一行
 *
 *
 * 示例1
 *
 * 输入
 * xcopy /s c:\\ d:\\
 *
 * 输出
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 *
 * @author Jiajing Li
 * @date 2020-05-10 17:07:29
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] arr = input.toCharArray();
            boolean flag = false;
            StringBuilder builder = new StringBuilder();
            int count = 0;
            List<String> list = new ArrayList<>();
            int index = 0;
            int length = arr.length;
            for (char ch : arr) {
                if (ch == '"') {
                    if (flag) {
                        flag = false;
                        list.add(getFromBuilder(builder));
                        count++;
                    } else {
                        flag = true;
                    }
                }

                if (flag) {
                    builder.append(ch);
                } else {
                    if (ch != ' ') {
                        builder.append(ch);
                        if (index == length - 1) {
                            list.add(getFromBuilder(builder));
                            count++;
                        }
                    } else {
                        list.add(getFromBuilder(builder));
                        count++;
                    }
                }
                index++;
            }
            System.out.println(count);
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    private static String getFromBuilder(StringBuilder builder) {
        String str = builder.toString().replace("\"", "");
        builder.setLength(0);
        return str;
    }

}
