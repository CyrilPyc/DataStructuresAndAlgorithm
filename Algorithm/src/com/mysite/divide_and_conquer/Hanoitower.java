package com.mysite.divide_and_conquer;

/**
 * @author Cyril.P
 * @date 2020-09-15-16:48
 */
public class Hanoitower {

    public static void main(String[] args) {

        hanoitower(5,'A','B','C');

    }

    /**
     * 汉诺塔的移动的方法
     * 使用分治算法
     */
    public static void hanoitower(int num, char a, char b, char c) {
        //如果只有一个盘，直接把盘 A -> C
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果有n >= 2 个圆盘的情况，我们总是可以看作是两个盘 1.最下面的那一个盘 2.上面的所有盘
            //1.先把最上面的所有盘 A -> B，移动过程会使用到 C
            hanoitower(num - 1, a, c, b);
            //2.把最下面的盘 A -> C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3.把柱B的所有盘 柱B -> 柱C
            hanoitower(num - 1,b,a,c);
        }

    }

}
