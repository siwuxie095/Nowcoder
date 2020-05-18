package com.siwuxie095.onlineprogramming.huawei.question088;

import java.util.Scanner;

/**
 * 扑克牌大小
 *
 * 题目描述
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和
 * 字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证
 * 两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟
 * 三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有
 * 的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 *
 *
 * 输入描述:
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如 4 4 4 4-joker JOKER。
 *
 * 输出描述:
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 *
 *
 * 示例1
 *
 * 输入
 * 4 4 4 4-joker JOKER
 *
 * 输出
 * joker JOKER
 *
 * @author Jiajing Li
 * @date 2020-05-18 14:32:05
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String allCards = "3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER";
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String first = input.split("-")[0];
            String second = input.split("-")[1];

            boolean error = true;

            if (isUnary(first) && isUnary(second)) {
                error = false;
                System.out.println(allCards.indexOf(first) < allCards.indexOf(second) ? second : first);
            } else if (isUnary(first) && isDoubleJoker(second)) {
                error = false;
                System.out.println(second);
            } else if (isDoubleJoker(first) && isUnary(second)) {
                error = false;
                System.out.println(first);
            } else if (isUnary(first) && isQuaternary(second)) {
                error = false;
                System.out.println(second);
            } else if (isQuaternary(first) && isUnary(second)) {
                error = false;
                System.out.println(first);
            }

            if (isBinary(first) && isBinary(second)) {
                error = false;
                System.out.println(allCards.indexOf(first.split(" ")[0]) < allCards.indexOf(second.split(" ")[0]) ? second : first);
            } else if (isBinary(first) && isDoubleJoker(second)) {
                error = false;
                System.out.println(second);
            } else if (isDoubleJoker(first) && isBinary(second)) {
                error = false;
                System.out.println(first);
            }  else if (isBinary(first) && isQuaternary(second)) {
                error = false;
                System.out.println(second);
            } else if (isQuaternary(first) && isBinary(second)) {
                error = false;
                System.out.println(first);
            }

            if (isTernary(first) && isTernary(second)) {
                error = false;
                System.out.println(allCards.indexOf(first.split(" ")[0]) < allCards.indexOf(second.split(" ")[0]) ? second : first);
            } else if (isTernary(first) && isDoubleJoker(second)) {
                error = false;
                System.out.println(second);
            } else if (isDoubleJoker(first) && isTernary(second)) {
                error = false;
                System.out.println(first);
            }  else if (isTernary(first) && isQuaternary(second)) {
                error = false;
                System.out.println(second);
            } else if (isQuaternary(first) && isTernary(second)) {
                error = false;
                System.out.println(first);
            }

            if (isQuaternary(first) && isQuaternary(second)) {
                error = false;
                System.out.println(allCards.indexOf(first.split(" ")[0]) < allCards.indexOf(second.split(" ")[0]) ? second : first);
            } else if (isQuaternary(first) && isDoubleJoker(second)) {
                error = false;
                System.out.println(second);
            } else if (isDoubleJoker(first) && isQuaternary(second)) {
                error = false;
                System.out.println(first);
            }

            if (isQuinary(first) && isQuinary(second)) {
                error = false;
                System.out.println(allCards.indexOf(first.split(" ")[0]) < allCards.indexOf(second.split(" ")[0]) ? second : first);
            } else if (isQuinary(first) && isDoubleJoker(second)) {
                error = false;
                System.out.println(second);
            } else if (isDoubleJoker(first) && isQuinary(second)) {
                error = false;
                System.out.println(first);
            }  else if (isQuinary(first) && isQuaternary(second)) {
                error = false;
                System.out.println(second);
            } else if (isQuaternary(first) && isQuinary(second)) {
                error = false;
                System.out.println(first);
            }

            if (error) {
                System.out.println("ERROR");
            }
        }
    }



    private static boolean isUnary(String card) {
        return card.split(" ").length == 1;
    }

    private static boolean isBinary(String card) {
        return card.split(" ").length == 2 && !card.contains("joker") && !card.contains("JOKER");
    }

    private static boolean isTernary(String card) {
        return card.split(" ").length == 3;
    }

    private static boolean isQuaternary(String card) {
        return card.split(" ").length == 4;
    }

    private static boolean isQuinary(String card) {
        return card.split(" ").length == 5;
    }

    private static boolean isSmallJoker(String card) {
        return card.contains("joker");
    }

    private static boolean isBigJoker(String card) {
        return card.contains("JOKER");
    }

    private static boolean isDoubleJoker(String card) {
        return card.contains("joker") && card.contains("JOKER");
    }

}
