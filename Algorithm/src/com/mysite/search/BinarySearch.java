package com.mysite.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意：使用二分查找的前提是 该数组是有序的
 *
 * @author Cyril.P
 * @description
 * @date 2020-11-19-14:09
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 305, 305, 305, 726, 726, 726, 89, 1000, 1234};
//        System.out.println(binarySearch(arr, 0, arr.length - 1, 124));
        List searchList = binarySearch2(arr, 0, arr.length - 1, 726);
        if (searchList == null) {
            System.out.println("找不到，别找了");
        } else {
            System.out.println("找到了，在"+searchList+"这几个位置");
        }
    }

    /**
     * 二分查找算法
     *
     * @param arr     查找的数组
     * @param left    数组左边的索引
     * @param right   数组右边的索引
     * @param findVal 要查找的数
     * @return 如果找到就返回对应下标，如果没有找到，就返回 -1
     */
    static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当 left > right 时，说明递归整个数组之后 还是没有找到要查找的数
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * 优化：当有多个相同的数值时，将所有的数值都查找到
     * 思路：
     * 1、在最终找到 mid 的时候，先不要直接返回
     * 2、向 mid 索引值的左边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
     * 3、向 mid 索引值的右边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
     * 4、将 ArrayList 返回
     */
    static List binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            /**思路：
             * 1、在最终找到 mid 的时候，先不要直接返回
             * 2、向 mid 索引值的左边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
             * 3、向 mid 索引值的右边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
             * 4、将 ArrayList 返回
             */
            List<Integer> resIndexList = new ArrayList<>();
            //向 mid 索引值的左边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就把 temp 放入 resIndexList 中
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            //向 mid 索引值的右边扫描，将所有满足 查找值 的元素的下标加入到集合ArrayList中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就把 temp 放入 resIndexList 中
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
