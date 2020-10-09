package com.mysite.queue;

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 *
 * @author Cyril.P
 * @date 2020-08-20-7:53
 */
public class ArrayQueue {

    /**
     * 表示数组最大容量
     */
    private int maxsize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     * @param maxsize
     */
    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        //指向队列头部，分析出front是指向队列头的前一个位置。
        front = -1;
        //指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void add(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据。");
            return;
        }
//        rear++;
        arr[++rear] = n;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据。");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据。");
        }
        for (int i = front + 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取出数据
     * @return
     */
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据。");
        }
        return arr[front + 1];
    }

}
