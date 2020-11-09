package com.mysite.recursion;

import java.util.Scanner;

/**
 * @author Cyril.P
 * @description
 * @date 2020-11-06-9:49
 */
public class Maze {

    public static void main(String[] args) {
        //先创建一个二位数组，模拟迷宫
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] maze = new int[row][col];
        //使用1表示墙
        for (int i = 0; i < col; i++) {
            maze[0][i] = 1;
            maze[row - 1][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            maze[i][0] = 1;
            maze[i][col - 1] = 1;
        }
        //设置挡板，1表示
        maze[scanner.nextInt()][scanner.nextInt()] = 1;
        maze[scanner.nextInt()][scanner.nextInt()] = 1;
        maze[scanner.nextInt()][scanner.nextInt()] = 1;
//        maze[scanner.nextInt()][scanner.nextInt()] = 1;
//        maze[scanner.nextInt()][scanner.nextInt()] = 1;
//        maze[scanner.nextInt()][scanner.nextInt()] = 1;
        //输出迷宫地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("走出来了！");
        //使用递归回溯给小球找路
        setWay(maze, 1, 1);
        //输出新的迷宫地图，走过后带有标记的地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 1、maze 表示迷宫给地图
     * 2、i, j 表示从迷宫地图的哪个位置开始出发
     * 3、如果小球能到 maze[row-1][col-1] 位置，则说明通路找到
     * 4、约定：当 maze[i][j] 为 0 表示该点没有走过； 1 表示墙； 2 表示通路可以走； 3 表示该点已经走过，但是走不通
     * 5、在走迷宫时，需要确定一个策略（方法） 下 -> 右 -> 上 -> 左，如果该点走不通，再回溯
     *
     * @param maze 表示地图
     * @param i    从哪个位置开始找
     * @param j    从哪个位置开始找
     * @return 如果找到通路，就返回true；否则返回false
     */
    public static boolean setWay(int[][] maze, int i, int j) {
        //通路已经找到
        if (maze[maze.length - 2][maze[0].length - 2] == 2) {
            return true;
        } else {
            //如果当前这个点还没有走过
            if (maze[i][j] == 0) {
                //按照策略 右 -> 下 -> 左 -> 上
                //先假定该点是可以走通的
                maze[i][j] = 2;
                if (setWay(maze, i, j + 1)) {
                    return true;
                } else if (setWay(maze, i + 1, j)) {
                    return true;
                } else if (setWay(maze, i, j - 1)) {
                    return true;
                } else if (setWay(maze, i - 1, j)) {
                    return true;
                } else {
                    //如果上下左右都不能走，那就说明是死路
                    maze[i][j] = 3;
                    return false;
                }
//                //按照策略 下 -> 右 -> 上 -> 左
//                //先假定该点是可以走通的
//                maze[i][j] = 2;
//                if (setWay(maze, i + 1, j)) {
//                    return true;
//                } else if (setWay(maze, i, j + 1)) {
//                    return true;
//                } else if (setWay(maze, i - 1, j)) {
//                    return true;
//                } else if (setWay(maze, i, j - 1)) {
//                    return true;
//                } else {
//                    //如果上下左右都不能走，那就说明是死路
//                    maze[i][j] = 3;
//                    return false;
//                }
            } else {
                //如果 maze[i][j] != 0，那就可能是1，2，3
                return false;
            }
        }
    }
}
