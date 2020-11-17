package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-10-17:09
 */
public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = {26, 35, 7, 726, 305};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        selectSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));

        //测试时间复杂度
        int[] arrs = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arrs[i] = (int) (Math.random() * 80000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);
        System.out.println("排序前时间"+startDate);
        long start = System.currentTimeMillis();

        selectSort(arrs);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间"+endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 选择排序
     * 2529ms左右，比冒泡排序快
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "轮选择排序后结果");
//            System.out.println(Arrays.toString(arr));
        }
    }

}
