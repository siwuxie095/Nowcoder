package com.siwuxie095.onlineprogramming.swordtooffer.question017;

/**
 * JZ17 树的子结构
 *
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 *
 * 示例1
 *
 * 输入
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-04-09 14:54:36
 */
@SuppressWarnings("all")
public class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        // 如果值相等，开始判断
        if (root1.val == root2.val && judge(root1, root2)) {
            return true;
        }
        // 遍历左子树和右子树
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean judge(TreeNode root1, TreeNode root2) {
        // root2 遍历完毕，代表全部匹配完成
        if (null == root2) {
            return true;
        }
        // root1 遍历完毕，并未匹配成功
        if (null == root1) {
            return false;
        }
        // 相等后，判断左右孩子
        if (root1.val == root2.val) {
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);
        }
        return false;
    }

}
