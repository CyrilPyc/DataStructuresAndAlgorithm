package com.mysite.linkedlist.circlesinglelinkedlist;

/**
 * 创建一个环形的单向链表
 *
 * @author Cyril.P
 * @date 2020-10-10-9:57
 */
public class CircleSingleLinkedList {

    //创建一个first节点，当前没有编号
    private Girl first = new Girl(-1);

    //添加节点，构建成一个环形的链表
    public void addGirl(int nums) {
        //nums表示要增加的节点数，因此不能为负数，要对nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Girl curGirl = null; //辅助指针，帮助构建环形链表
        //使用for来创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建节点
            Girl girl = new Girl(i);
            //如果是第一个节点
            if (i == 1) {
                first = girl;
                first.setNext(first); //构成环
                curGirl = first; //让curWife指向第一个节点
            } else {
                curGirl.setNext(girl);
                girl.setNext(first);
                curGirl = curGirl.getNext();
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showGirl() {
        //判断链表是否为空
        if (first.getNext() == null) {
            System.out.println("没有女孩");
            return;
        }
        //因为first不能动，因此我们仍然需要一个辅助指针
        Girl curGirl = first;
        while (true) {
            System.out.println("女孩的编号" + curGirl.getId());
            if (curGirl.getNext() == first) { //说明遍历完毕
                break;
            }
            curGirl = curGirl.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出女孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countGirl(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Girl helper = first;
        //需要创建一个辅助指针 helper ，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { //说明 helper 指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 startNo - 1 次，移动到 startNo 位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时移动 countNum - 1 次，然后出圈
        //此处是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时移动 countNum - 1 次，然后出圈
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.println("小女孩" + first.getId() +"出圈");
            //这时将 first 指向的小女孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小女孩是" + helper.getId());
    }
}
