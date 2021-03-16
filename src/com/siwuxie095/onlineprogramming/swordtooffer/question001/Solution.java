package com.siwuxie095.onlineprogramming.swordtooffer.question001;

/**
 * JZ1 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例1
 *
 * 输入
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 * 返回值
 * true
 *
 * @author Jiajing Li
 * @date 2021-03-16 17:03:44
 */
@SuppressWarnings("all")
public class Solution {

    public boolean Find(int target, int [][] array) {
        int rowLen = array.length;
        int colLen = array[0].length;
        if (rowLen == 0 || colLen == 0) {
            return false;
        }
        // 右上角
        int rowIdx = 0;
        int colIdx = colLen - 1;
        while (rowIdx < rowLen && colIdx >= 0) {
            if (target > array[rowIdx][colIdx]) {
                // 舍弃一行
                rowIdx++;
            } else if (target < array[rowIdx][colIdx]) {
                // 舍弃一列
                colIdx--;
            } else {
                return true;
            }
        }
        return false;
    }

}
