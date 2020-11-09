package com.mysite.recursion;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-06-17:56
 */
public class EightQueens {

    /**
     * 定义一个max表示共有多少个皇后
     */
    int max = 8;
    /**
     * 定义数组array，保存皇后放置位置的结果，比如 arr = {0,4,7,5,2,6,1,3}
     */
    int[] array = new int[max];

    static int count = 0;

    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(count);
        System.out.println(judgeCount);
    }

    /**
     * 编写一个方法，放置第 n 个皇后
     * 特别注意：checkshi每一次递归时，进入到check中都有for(int i = 0; i < max; i++)，因此会有回溯
     *
     * @param n
     */
    private void check(int n) {
        //n = 8时，8个皇后已然放好，n 是从 0 开始的，第一个皇后 n 为 0
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后 n 放到该行的第1列
            array[n] = i;
            //判断当放置第 n 个皇后到i列时，是否冲突
            if (judge(n)) {
                //如果不冲突。接着放第 n+1 个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i，将第 n 个皇后，放置在本行接下来一列的位置
        }
    }

    /**
     * 查看当我们放置第 n 个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第 n 个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            /**
             * 1、array[i] == array[n]   表示判断第 n 个皇后是否和前面的 n-1 个皇后在同一列
             * 2、Math.abs(n-i) == Math.abs(array[i]-array[n]    表示判断第 n 个皇后是否和第 i 个皇后是否在同一斜线
             * n = 1; array[1] = 1; i = 0; array[0] = 0
             * Math.abs(1-0) = 1; Math.abs(array[1]-array[0]) = Math.abs(1-0) = 1
             * 3、判断是否在同一行，没有必要，因为行就是 n，每次都在递增，是不一样的
             */
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 写一个方法，可以将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
