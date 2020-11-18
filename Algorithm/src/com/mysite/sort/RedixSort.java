package com.mysite.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-17-15:08
 */
public class RedixSort {
    public static void main(String[] args) {

        /**
         * 测试基数排序时间复杂度 550ms左右
         */
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = simpleDateFormat.format(date);
        System.out.println("排序前时间"+startDate);
        long start = System.currentTimeMillis();

        redixSort(arr);

        Date date1 = new Date();
        String endDate = simpleDateFormat.format(date1);
        System.out.println("排序后时间"+endDate);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        int arr[] = {53, 3, 542, 748, 14, 214};
//        RedixSort(arr);
    }

    //基数排序方法
    public static void redixSort(int[] arr) {

        //根据前面的推导过程
        //1、得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = ("" + max).length();

        /**
         * 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
         * 说明
         * 1、二维数组包含10个一维数组
         * 2、为了防止在放入数的时候出现数据溢出，需要把每个一维数组（桶）的大小定义为arr.length
         * 3、因此很明显，基数排序是用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入数据的个数
        //bucketElementCounts[0]：记录的就是 bucket[0] 桶放入数据的个数
        int[] bucketElementCounts = new int[10];

        //使用循环处理每一轮的代码
        for (int i = 0; i < maxLength; i++) {
            //第i轮（针对每个元素的个位进行排序处理），第一轮是个位，第二轮是十位，第三轮是百位...
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素个位的值
                int digitOfElement = arr[j] / (int) Math.pow(10, i) % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序（按照一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for (int j = 0; j < bucket.length; j++) {
                //如果桶中有数据，我们才放入到原数组中
                if (bucketElementCounts[j] > 0) {
                    //循环该桶，即第i个桶（第i个一维数组），放入
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[j][k];
                    }
                }
                //第一轮将桶中数据取出到arr处理后，要把桶中的元素清空，即需要将每个 bucketElementCount[j] = 0，把指针指向0！！！！！！
                bucketElementCounts[j] = 0;
            }
//            System.out.println("第" + i + 1 + "轮的排序结果：" + Arrays.toString(arr));
        }


//        //第1轮（针对每个元素的个位进行排序处理）
//        for (int i = 0; i < arr.length; i++) {
//            //取出每个元素个位的值
//            int digitOfElement = arr[i]%10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序（按照一维数组的下标依次取出数据，放入原来数组）
//        int index = 0;
//        //遍历每一个桶，并将桶中的数据，放入到原数组
//        for (int i = 0; i < bucket.length; i++) {
//            //如果桶中有数据，我们才放入到原数组中
//            if (bucketElementCounts[i]>0){
//                //循环该桶，即第i个桶（第i个一维数组），放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            //第一轮将桶中数据取出到arr处理后，要把桶中的元素清空，即需要将每个 bucketElementCount[i] = 0，把指针指向0！！！！！！
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第1轮的排序结果："+ Arrays.toString(arr));
//
//        //============================
//
//        //第2轮（针对每个元素的个位进行排序处理）
//        for (int i = 0; i < arr.length; i++) {
//            //取出每个元素个位的值
//            int digitOfElement = arr[i]/10%10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序（按照一维数组的下标依次取出数据，放入原来数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据，放入到原数组
//        for (int i = 0; i < bucket.length; i++) {
//            //如果桶中有数据，我们才放入到原数组中
//            if (bucketElementCounts[i]>0){
//                //循环该桶，即第i个桶（第i个一维数组），放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            //第一轮将桶中数据取出到arr处理后，要把桶中的元素清空，即需要将每个 bucketElementCount[i] = 0，把指针指向0！！！！！！
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第2轮的排序结果："+ Arrays.toString(arr));
//
//        //============================
//
//        //第3轮（针对每个元素的个位进行排序处理）
//        for (int i = 0; i < arr.length; i++) {
//            //取出每个元素个位的值
//            int digitOfElement = arr[i]/10/10%10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序（按照一维数组的下标依次取出数据，放入原来数组）
//        index = 0;
//        //遍历每一个桶，并将桶中的数据，放入到原数组
//        for (int i = 0; i < bucket.length; i++) {
//            //如果桶中有数据，我们才放入到原数组中
//            if (bucketElementCounts[i]>0){
//                //循环该桶，即第i个桶（第i个一维数组），放入
//                for (int j = 0; j < bucketElementCounts[i]; j++) {
//                    //取出元素放入到arr中
//                    arr[index++] = bucket[i][j];
//                }
//            }
//            //第一轮将桶中数据取出到arr处理后，要把桶中的元素清空，即需要将每个 bucketElementCount[i] = 0，把指针指向0！！！！！！
//            bucketElementCounts[i] = 0;
//        }
//        System.out.println("第3轮的排序结果："+ Arrays.toString(arr));

    }
}
