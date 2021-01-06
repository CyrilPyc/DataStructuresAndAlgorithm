package com.mysite.search;

import java.util.Arrays;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-23-9:51
 */
public class FibonacciSearch {
    static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 10));
    }

    /**
     * 因为后面 mid = low + F(k-1)-1，需要使用到斐波那契数列，因此需要先获取一个斐波那契数列
     */
    static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法，，使用非递归的方式编写
     *
     * @param a   数组
     * @param key 需要查找的关键码（值）
     * @return 返回对应下标，如没有找到，返回-1
     */
    static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        // k 表示斐波那契数值的下标
        int k = 0;
        // 存放 mid 值
        int mid = 0;
        // 获取斐波那契数列
        int f[] = fib();
        // 获取斐波那契数值的下标 k
        while (a.length > f[k] - 1) {
            k++;
        }
        // 因为 f[k] 的值可能大于 a 的长度，因此需要使用Arrays类构造一个新的数组，并指向 temp[]
        // 不足的地方会使用 0 填充
        int[] temp = Arrays.copyOf(a, f[k]);
        // 实际上需要使用 a 数组最后的数填充 temp
        // 举例： temp = {1, 8, 10, 89, 1000, 1234, 0, 0, 0} => {1, 8, 10, 89, 1000, 1234, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        // 使用 while 循环 来循环处理找到需要查找的数值 key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                // 继续向数组的前面（左边）查找
                high = mid - 1;
                // 为什么是 k--
                // 1、全部元素 = 前面的元素 + 后面的元素
                // 2、f[k] = f[k - 1] + f[k - 2]
                // 3、因为前面有 f[k - 1] 个元素，所以可以继续拆分 f[k - 1] = f[k - 2] + f[k - 3]
                // 4、即 在 f[k - 1] 的前面继续查找 k--
                // 5、即 下次循环 mid = f[k - 1 - 1] - 1
                k--;
            } else if (key > temp[mid]) {
                // 继续向数组的后面（右边）查找
                low = mid + 1;
                //为什么是 k -= 2
                // 1、全部元素 = 前面的元素 + 后面的元素
                // 2、f[k] = f[k - 1] + f[k - 2]
                // 3、因为后面有 f[k - 2] 个元素，所以可以继续拆分 f[k - 1] = f[k - 3] + f[k - 4]
                // 4、即 在 f[k - 2] 的前面进行查找  k -= 2
                // 5、即 下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {
                //找到了，需要确定返回的是哪个下标
                if (mid <= high){
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
