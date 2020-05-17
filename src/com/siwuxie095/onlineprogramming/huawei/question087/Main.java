package com.siwuxie095.onlineprogramming.huawei.question087;

import java.util.Scanner;

/**
 * 密码强度等级
 *
 * 题目描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 全都是小（大）写字母
 * 20 分: 大小写混合字母
 *
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 *
 * 五、奖励:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱
 *
 *
 * 对应输出为：
 * VERY_SECURE
 * SECURE,
 * VERY_STRONG,
 * STRONG,
 * AVERAGE,
 * WEAK,
 * VERY_WEAK,
 *
 *
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 * 字母：a-z, A-Z
 * 数字：0-9
 *
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * [\]^_`              (ASCII码：x5B~0x60)
 * {|}~                (ASCII码：x7B~0x7E)
 *
 *
 * 输入描述:
 * 输入一个string的密码
 *
 * 输出描述:
 * 输出密码等级
 *
 *
 * 示例1
 *
 * 输入
 * 38$@NoNoNo
 *
 * 输出
 * VERY_SECURE
 *
 * @author Jiajing Li
 * @date 2020-05-17 19:57:18
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.next();
            int score = 0;
            int len = password.length();
            if (len <= 4) {
                score += 5;
            } else if (len >= 5 && len <= 7) {
                score += 10;
            } else {
                score += 25;
            }

            boolean hasLetter = true;
            boolean hasDigit = true;
            boolean hasSymbol = true;
            boolean hasMixtedLetter = false;

            if (nonLetter(password)) {
                score += 0;
                hasLetter = false;
            } else if (isAllUpperLetter(password) || isAllLowerLetter(password)) {
                score += 10;
            } else if (isMixedLetter(password)) {
                score += 20;
                hasMixtedLetter = true;
            }

            if (nonDigit(password)) {
                score += 0;
                hasDigit = false;
            } else if (onlyOneDigit(password)) {
                score += 10;
            } else if (greaterThanOneDigit(password)) {
                score += 20;
            }

            if (nonSymbol(password)) {
                score += 0;
                hasSymbol = false;
            } else if (onlyOneSymbol(password)) {
                score += 10;
            } else if (greaterThanOneSymbol(password)) {
                score += 25;
            }

            if (hasLetter && hasDigit && !hasSymbol) {
                score += 2;
            } else if (hasMixtedLetter && hasDigit && hasSymbol) {
                score += 5;
            } else if (hasLetter && hasDigit && hasSymbol) {
                score += 3;
            }

            if (score >= 90) {
                System.out.println("VERY_SECURE");
            } else if (score >= 80) {
                System.out.println("SECURE");
            } else if (score >= 70) {
                System.out.println("VERY_STRONG");
            } else if (score >= 60) {
                System.out.println("STRONG");
            } else if (score >= 50) {
                System.out.println("AVERAGE");
            } else if (score >= 25) {
                System.out.println("WEAK");
            } else if (score >= 0) {
                System.out.println("VERY_WEAK");
            }
        }
    }


    private static boolean nonLetter(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllUpperLetter(String password) {
        for (char ch : password.toCharArray()) {
            if (!Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllLowerLetter(String password) {
        for (char ch : password.toCharArray()) {
            if (!Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMixedLetter(String password) {
        boolean hasUpperLetter = false;
        boolean hasLowerLetter = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperLetter = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLowerLetter = true;
            }
            if (hasUpperLetter && hasLowerLetter) {
                break;
            }
        }
        return hasUpperLetter && hasLowerLetter;
    }


    private static boolean nonDigit(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean onlyOneDigit(String password) {
        int count = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count == 1;
    }

    private static boolean greaterThanOneDigit(String password) {
        int count = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count > 1;
    }

    private static boolean nonSymbol(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return false;
            }
            if (Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean onlyOneSymbol(String password) {
        int count = 0;
        for (char ch : password.toCharArray()) {
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                count++;
            }
        }
        return count == 1;
    }

    private static boolean greaterThanOneSymbol(String password) {
        int count = 0;
        for (char ch : password.toCharArray()) {
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                count++;
            }
        }
        return count > 1;
    }


}
