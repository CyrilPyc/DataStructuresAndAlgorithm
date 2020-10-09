package com.mysite.queue;

/**
 * @author Cyril.P
 * @date 2020-08-20-13:10
 */
public class CircleArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头，front变量的含义做了调整，front指向第一个元素，即arr[front]就是队列的第一个元素
     * front的初始值=0
     */
    private int front;
    /**
     * 队列尾，rear变量的含义也做了调整，rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
     * rear的初始值=0
     */
    private int rear;
    /**
     * 该数组用于存放数据，模拟队列
     */
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据可取");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        return arr[(front++) % maxSize];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据可以显示");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素？
        //遍历有效个元素
        for (int i = front; i < front + getSize(); i++) {

        }
    }

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }

}
