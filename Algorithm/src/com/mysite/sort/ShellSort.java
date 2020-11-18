package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-11-10:32
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {35, 3, 7, 26, 726, 305, -3526, -35726};

        /**
         * 测试时间复杂度  7437ms左右
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

        /**
         * 交换法
         */
//        shellSort(arr);

        /**
         * 移位法
         */
        shellSort2(arr);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间" + endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        System.out.println(Arrays.toString(arr));
    }

    /**
     * Shell排序（交换法）
     * 7500ms左右
     */
    public static void shellSort(int[] arr) {
//        int count = 0;
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            count++;
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("第" + count + "轮希尔排序后的结果：" + Arrays.toString(arr));
        }
    }

    /**
     * 对交换法的Shell排序进行优化 -> 移位法
     * 18ms左右
     */
    public static void shellSort2(int[] arr) {
        //增量gap，并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int insertIndex = i;
                int insertVal = arr[i];
                if (arr[insertIndex] < arr[insertIndex-gap]){
                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]){
                        //移动
                        arr[insertIndex] = arr[insertIndex-gap];
                        insertIndex -= gap;
                    }
                    //当退出while后，就给temp找到了插入的位置
                    arr[insertIndex] = insertVal;
                }
            }
        }
    }

}
