package com.mysite.sparsearray;

/**
 * @author Cyril.P
 * @date 2020-08-06-14:07
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11,0：表示没有棋子，1表示黑子，2表示白子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        int total = 0;
        //输出原始的二位数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArray1) {
            for (int data : row) {
                if (data != 0) {
                    total++;
                }
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
//        System.out.println(total);

        //将二维数组 转 稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
//        System.out.println(sum);

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 1;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                    count++;
                }
            }
        }
        //输出稀疏数组
        System.out.println("这是稀疏数组");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 将稀疏数组 --> 恢复成原始的二维数组
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
         * 2.再读取稀疏数组后几行的数据，并赋给原始的二维数组即可
         */
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int count1 = 0;
        int[][] chessArray2 = new int[row][col];
        for (int i = 1; i < sparseArr.length; i++) {
            count1++;
            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("这是稀疏数组转二维数组的数组");
        for (int[] row1 : chessArray2) {
            for (int data : row1) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
