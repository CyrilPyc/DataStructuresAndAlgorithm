package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-11-16:04
 */
public class QuickSort {

    public static void main(String[] args) {

        /**
         * 测试快速排序时间复杂度  20ms左右
         */
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);
        System.out.println("排序前时间" + startDate);
        long start = System.currentTimeMillis();

        quickSort2(arr, 0, arr.length - 1);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间" + endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        int[] arr = {35, 3, 7, 26, 726, 305, -3526, -35726};
//        int[] arr = {726, 726, 726, 26, 35, 35, 35};
//        int[] arr = {-9, 78, 3, 0, 23, 0, 70};
//        int[] arr = {15, 78, 3, 0, 15, 15, 23, 0, 70};
//        int[] arr = {0, 97, 9, 17, 1, 8};

//        quickSort2(arr, 0, arr.length - 1);

//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序法
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        /**
         * pivot 中间值
         */
        int pivot = arr[(left + right) / 2];
        int temp;
        //while 循环的目的是让 比 pivot 值小的值放到左边，比 pivot 值大的值放到右边
        while (l < r) {
            //在 pivot 的左边一直找，找到一个大于等于 pivot 值的值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在 pivot 的右边一直找，找到一个小于等于 pivot 值的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果 l > r 说明 pivot 的左右两边的值都按照左边全部小于 pivot 值，右边全部大于 pivot 值
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现 arr[l] == pivot，r--，前移
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现 arr[r] == pivot，l++，后移
            if (arr[r] == pivot) {
                l++;
            }
        }
        //如果 l == r，必须 l++，r--，否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
            }
            if (l == r) {
                arr[l] = pivot;
            }
        }
        if (left < r) {
            quickSort2(arr, left, r - 1);
        }
        if (right > r) {
            quickSort2(arr, r + 1, right);
        }
    }

}
