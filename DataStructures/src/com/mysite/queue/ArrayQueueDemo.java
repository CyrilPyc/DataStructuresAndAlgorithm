package com.mysite.queue;

import java.util.Scanner;

/**
 * @author Cyril.P
 * @date 2020-08-20-7:52
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.print("输出你要进行的操作：");
            //接受一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.println("取出的数据是" + i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("取出的头数据是" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    return;
                default:
                    break;
            }
        }
    }

}
