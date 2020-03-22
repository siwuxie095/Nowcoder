package com.siwuxie095.onlineprogramming.huawei.question049;

import java.util.Scanner;


/**
 * 多线程
 *
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，
 * 线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能
 * 就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由
 * 线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]

 * 输入描述:
 * 输入一个 int 整数
 *
 * 输出描述:
 * 输出多个 ABCD
 *
 *
 * 示例1
 *
 * 输入
 * 10
 *
 * 输出
 * ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
 *
 * @author Jiajing Li
 * @date 2020-03-22 10:07:10
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();

            Thread a = new PrintThread("A", "B", count);
            Thread b = new PrintThread("B", "C", count);
            Thread c = new PrintThread("C", "D", count);
            Thread d = new PrintThread("D", "A", count);

            a.start();
            b.start();
            c.start();
            d.start();
            a.join();
            b.join();
            c.join();
            d.join();

            System.out.println(PrintThread.res);
            // reset
            PrintThread.res = new StringBuilder();
        }
    }



}

class PrintThread extends Thread {
    /**
     * global lock
     */
    private static final Object GLOBAL_LOCK = new Object();
    /**
     * start from A
     */
    private static String flagLetter = "A";

    protected static StringBuilder res = new StringBuilder();

    private String currLetter;

    private String nextLetter;

    private int count;

    public PrintThread(String currLetter, String nextLetter, int count) {
        this.currLetter = currLetter;
        this.nextLetter = nextLetter;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            print(currLetter, nextLetter, count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print(String currLetter, String nextLetter, int count) throws InterruptedException {
        while (count > 0) {
            synchronized (GLOBAL_LOCK) {
                while (!currLetter.equals(flagLetter)) {
                    GLOBAL_LOCK.wait();
                }
                res.append(flagLetter);
                flagLetter = nextLetter;
                count--;
                GLOBAL_LOCK.notifyAll();
            }
        }

    }

}