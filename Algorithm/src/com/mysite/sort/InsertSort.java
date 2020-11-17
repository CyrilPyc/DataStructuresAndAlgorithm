package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-10-18:03
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] arr = {35, 3, 7, 26, 726, 305, -3526};

        /**
         * 测试插入排序时间复杂度  660ms左右，
         */
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);
        System.out.println("排序前时间"+startDate);
        long start = System.currentTimeMillis();

        insertSort(arr);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间"+endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            //arr[i]前面一个数的下标
            insertIndex = i - 1;
            /**给insertVal找到插入的位置
             * 说明：
             * 1、insertIndex >= 0保证在给 insertVal 找插入位置，不越界
             * 2、insertVal < arr[insertIndex] 插入的数小于前一个数，此时，待插入的数还没有找到插入的位置
             * 3、就需要就 arr[insertIndex] 后移
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                //继续跟前面的数比较大小
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，在 insertIndex + 1 处
            arr[insertIndex + 1] = insertVal;

//            System.out.println("第" + i + "轮插入排序后的结果：" + Arrays.toString(arr));
        }
    }

}
