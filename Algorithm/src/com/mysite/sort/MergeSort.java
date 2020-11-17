package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-11-19:55
 */
public class MergeSort {

    public static void main(String[] args) {

        /**
         * 测试归并排序时间复杂度 13ms左右
         */
        int[] arr = new int[80000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);
        System.out.println("排序前时间"+startDate);
        long start = System.currentTimeMillis();

        mergeSort(arr,0, arr.length-1,temp);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间"+endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        int[] arr = {35, 3, 7, 26, 726, 305};
//        //归并排序需要一个额外空间temp
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分解+合并的方法
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // mid 为中间索引
            int mid = (left + right) / 2;
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //每分解一次便合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转辅助数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //初始化 i ，左边有序序列的初始索引
        int i = left;
        //初始化 j ，右边有序序列的初始索引
        int j = mid + 1;
        // t 指向 temp 数组的当前索引
        int t = 0;

        //1、先把左右两边（有序）的数据按照规则填充到 temp 数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素小于等于右边有序序列的当前元素，就把左边的当前元素拷贝到 temp 数组，切记 t 和 i 要后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2、把有剩余数据的一边的数据依次全部填充到temp
        //左边有序序列还有剩余的元素，就全部填充到 temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3、将 temp 数组的元素拷贝到 arr
        //注意：并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
