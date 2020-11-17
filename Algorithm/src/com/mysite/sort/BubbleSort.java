package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-10-14:40
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};

        /**
         * 测试时间复杂度
         */
        //创建一个80000个数据的随机数组
        int[] arrs = new int[80000];
        for (int i = 0; i < 80000; i++) {
            //生成[0,80000)的数
            arrs[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);

        System.out.println("排序前的时间：" + startDate);
        long start = System.currentTimeMillis();

        //测试冒泡排序
        bubbleSort(arrs);

        Date date2 = new Date();
        String endDate = simpleDateFormat.format(date2);
        System.out.println("排序前的时间：" + endDate);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 冒泡排序
     * 13131ms左右
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        /**
         * temp 为临时变量
         */
        int temp;
        /**
         * flag 为标识变量，表示是否进行过交换
         */
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            /**
             * 在一趟排序中，如果一次交换都没有发生过
             */
            if (!flag) {
                break;
            } else {
                /**
                 * 重置flag，进行下一趟数据的排序
                 */
                flag = false;
            }
        }
    }
}
