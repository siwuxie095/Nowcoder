package com.siwuxie095.onlineprogramming.huawei.question064;

import java.util.*;

/**
 * MP3光标位置
 *
 * 题目描述
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
 * 为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 *
 *
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 *
 * 1. 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * (1)光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * (2)其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 *
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 * (1)特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页
 * （即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按
 * Down键，屏幕要显示第一页，光标挪到第一首歌上。
 * (2)一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首
 * 开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 * (3)其他情况，不用翻页，只是挪动光标就行。
 *
 *
 * 输入描述:
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 输出描述:
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 *
 * 示例1
 *
 * 输入
 * 10
 * UUUU
 *
 * 输出
 * 7 8 9 10
 * 7
 *
 * @author Jiajing Li
 * @date 2020-04-09 13:35:11
 */
public class Main {

    private static int numStart;
    private static int numEnd;
    private static int first;
    private static int last;
    private static int selected;
    private static final int LIMIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String cmd = scanner.next();
            numStart = 1;
            numEnd = num;

            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <= LIMIT; i++) {
                if (i > num) {
                    continue;
                }
                deque.addLast(i);
            }
            first = deque.getFirst();
            last = deque.getLast();
            selected = first;

            for (char ch : cmd.toCharArray()) {
                if (ch == 'U') {
                   up(deque);
                }
                if (ch == 'D') {
                    down(deque);
                }
            }

            StringBuilder builder = new StringBuilder();
            while (!deque.isEmpty()) {
                builder.append(deque.pollFirst());
                builder.append(" ");
            }
            System.out.println(builder.toString().trim());
            System.out.println(selected);
        }
    }

    private static void up(Deque<Integer> deque) {
        if (selected - 1 >= first) {
            selected--;
            return;
        }

        if (numEnd <= LIMIT) {
            if (selected == numStart) {
                selected = last;
            }
        } else {
            if (selected == numStart) {
                reloadFromEnd(deque);
                first = deque.getFirst();
                last = deque.getLast();
                selected = last;
            } else {
                deque.pollLast();
                deque.addFirst(first - 1);
                first = first - 1;
                last = last - 1;
                selected = first;
            }
        }
    }

    private static void reloadFromEnd(Deque<Integer> deque) {
        while (!deque.isEmpty()) {
            deque.pollFirst();
        }
        for (int i = numEnd - 3; i <= numEnd; i++) {
            deque.addLast(i);
        }
    }

    private static void down(Deque<Integer> deque) {
        if (selected + 1 <= last) {
            selected++;
            return;
        }

        if (numEnd <= LIMIT) {
            if (selected == numEnd) {
                selected = first;
            }
        } else {
            if (selected == numEnd) {
                reloadFromStart(deque);
                first = deque.getFirst();
                last = deque.getLast();
                selected = first;
            } else {
                deque.pollFirst();
                deque.addLast(last + 1);
                first = first + 1;
                last = last + 1;
                selected = last;
            }
        }
    }

    private static void reloadFromStart(Deque<Integer> deque) {
        while (!deque.isEmpty()) {
            deque.pollFirst();
        }
        for (int i = numStart; i <= LIMIT; i++) {
            deque.addLast(i);
        }
     }


}
