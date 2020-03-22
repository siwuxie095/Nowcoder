package com.siwuxie095.onlineprogramming.huawei.question051;

import java.util.Scanner;

/**
 * 输出单向链表中倒数第 k 个结点
 *
 * 题目描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 *
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int       m_nKey;
 * ListNode* m_pNext;
 * };
 *
 * 详细描述：
 * 接口说明
 * 原型：
 * ListNode* FindKthToTail(ListNode* pListHead, unsignedint k);
 * 输入参数：
 * ListNode* pListHead  单向链表
 * unsigned int k  倒数第k个结点
 *
 * 输出参数（指针指向的内存区域保证有效）：
 * 无
 *
 * 返回值：
 * 正常返回倒数第k个结点指针，异常返回空指针
 *
 * 输入描述:
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 *
 * 输出描述:
 * 输出一个整数
 *
 *
 * 示例1
 *
 * 输入
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 *
 * 输出
 * 5
 *
 * @author Jiajing Li
 * @date 2020-03-22 17:38:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            Node headNode = new Node(scanner.nextInt(), 1);
            Node tailNode = headNode;
            for (int i = 1; i < count; i++) {
                int key = scanner.nextInt();
                tailNode = insert(tailNode, key);
            }
            int kth = scanner.nextInt();
            if (kth == 0) {
                System.out.println(0);
            } else {
                Node kthNode = findKthFromHead(headNode, tailNode.seq - kth + 1);
                System.out.println(kthNode.key);
            }
        }
    }

    private static Node insert(Node tailNode, int key) {
        Node newNode = new Node(key, tailNode.seq + 1);
        tailNode.next = newNode;
        tailNode = newNode;
        return tailNode;
    }

    private static Node findKthFromHead(Node headNode, int kth) {
        Node currNode = headNode;
        kth--;
        while (kth > 0) {
            currNode = currNode.next;
            kth--;
        }
        return currNode;
    }

}

class Node {
    int key;
    int seq;
    Node next;

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, int seq) {
        this.key = key;
        this.seq = seq;
    }
}
