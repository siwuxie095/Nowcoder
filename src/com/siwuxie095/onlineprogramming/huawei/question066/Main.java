package com.siwuxie095.onlineprogramming.huawei.question066;

import java.util.*;

/**
 * 配置文件恢复
 *
 * 题目描述
 * 有6条配置命令，它们执行的结果分别是：
 *
 * 命   令	执   行
 * reset	            reset what
 * reset board	        board fault
 * board add	        where to add
 * board delet	        no board at all
 * reboot backplane	    impossible
 * backplane abort	    install first
 * he he	            unkown command
 * 注意：he he不是命令。
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：
 * reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，
 * 但是该命令有两个关键词，所有匹配失败，执行结果为：unkown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。
 * 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
 *
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如
 * 输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令
 * board add，匹配成功。
 * 6、若匹配失败，打印“unkown command”
 *
 *
 * 输入描述:
 * 多行字符串，每行字符串一条命令
 *
 * 输出描述:
 * 执行结果，每条命令输出一行
 *
 *
 * 示例1
 *
 * 输入
 * reset
 * reset board
 * board add
 * board delet
 * reboot backplane
 * backplane abort
 *
 * 输出
 * reset what
 * board fault
 * where to add
 * no board at all
 * impossible
 * install first
 *
 * @author Jiajing Li
 * @date 2020-04-12 18:57:06
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delet", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        List<String> list = new ArrayList<>(map.keySet());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String key = "";
            int count = 0;
            if (input.contains(" ")) {
                String first = input.split(" ")[0];
                String second = input.split(" ")[1];
                for (String str : list) {
                    if (str.contains(first) && str.contains(second)) {
                        count++;
                        key = str;
                    }
                }
            } else {
                for (String str : list) {
                    if (str.contains(input)) {
                        count++;
                        key = str;
                        break;
                    }
                }
            }

            if (count == 0 || count >= 2) {
                System.out.println("unkown command");
            } else {
                System.out.println(map.get(key));
            }
        }
    }

}
