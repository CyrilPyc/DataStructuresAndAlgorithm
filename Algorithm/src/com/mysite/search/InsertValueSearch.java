package com.mysite.search;

/**
 * 注意：使用二分查找的前提是 该数组是有序的
 *
 * @author Cyril.P
 * @description
 * @date 2020-11-19-16:54
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int valIndex = insertValueSearch(arr, 0, arr.length - 1, 35);
        System.out.println(valIndex);
    }

    /**
     * 插值查找算法
     *
     * @param arr     查找的数组
     * @param left    数组左边的索引
     * @param right   数组右边的索引
     * @param findVal 要查找的数
     * @return 如果找到就返回对应下标，如果没有找到，就返回 -1
     */
    static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("我这是一次");
        //注意： findVal < arr[0] || findVal > arr[arr.length - 1] 这个条件必须需要
        //否则求出的 mid 可能会造成越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
