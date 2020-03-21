package com.siwuxie095.onlineprogramming.huawei.question048;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * 从单向链表中删除指定值的节点
 *
 * 题目描述
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，
 * 删除后如果链表中无节点则返回空指针。
 *
 * 详细描述：
 *
 * 本题为考察链表的插入和删除知识。
 * 链表的值不能重复
 *
 * 构造过程，例如
 * 1 <- 2
 * 3 <- 2
 * 5 <- 1
 * 4 <- 5
 * 7 <- 2
 *
 * 最后的链表的顺序为 2 7 3 1 5 4
 * 删除 结点 2
 * 则结果为 7 3 1 5 4
 *
 * 输入描述:
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 *
 * 输出描述:
 * 输出删除结点后的序列，每个数后都要加空格
 *
 *
 * 示例1
 *
 * 输入
 * 5
 * 2
 * 3 2
 * 4 3
 * 5 2
 * 1 4
 * 3
 *
 * 输出
 * 2 5 4 1
 *
 * @author Jiajing Li
 * @date 2020-03-21 22:17:11
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int headKey = scanner.nextInt();
            Node headNode = new Node(headKey);
            Set<Integer> set = new HashSet<>();
            set.add(headKey);
            for (int i = 0; i < count; i++) {
                if (set.size() == count) {
                    break;
                }
                int secondKey = scanner.nextInt();
                int firstKey = scanner.nextInt();
                set.add(firstKey);
                set.add(secondKey);
                insert(headNode, firstKey, secondKey);
            }
            int deletedKey = scanner.nextInt();
            headNode = delete(headNode, deletedKey);
            Node currNode = headNode;
            StringBuilder res = new StringBuilder();
            while (null != currNode) {
                res.append(currNode.key);
                res.append(" ");
                currNode = currNode.next;
            }
            System.out.println(res.toString());
        }
    }

    private static void insert(Node headNode, int firstKey, int secondKey) {
        Node currNode = headNode;
        while (null != currNode) {
            if (firstKey == currNode.key) {
                Node nextNode = currNode.next;
                Node newNode = new Node(secondKey);
                if (Objects.isNull(nextNode)) {
                    currNode.next = newNode;
                } else {
                    currNode.next = newNode;
                    newNode.next = nextNode;
                }
                break;
            } else {
                currNode = currNode.next;
            }
        }
    }

    private static Node delete(Node headNode, int deletedKey) {
        if (deletedKey == headNode.key) {
            Node newHeadNode = headNode.next;
            headNode.next = null;
            return newHeadNode;
        }
        Node prevNode = headNode;
        Node currNode = prevNode.next;
        while (null != currNode) {
            if (deletedKey == currNode.key) {
                prevNode.next = currNode.next;
                currNode.next = null;
                return headNode;
            } else {
                prevNode = prevNode.next;
                currNode = prevNode.next;
            }
        }
        return headNode;
    }


}

class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
    }
}
