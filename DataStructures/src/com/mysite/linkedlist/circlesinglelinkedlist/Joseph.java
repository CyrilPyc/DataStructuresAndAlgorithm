package com.mysite.linkedlist.circlesinglelinkedlist;

/**
 * @author Cyril.P
 * @date 2020-10-10-9:54
 */
public class Joseph {

    public static void main(String[] args) {
        //测试构建环形链表和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addGirl(5);
        circleSingleLinkedList.showGirl();

        //测试约瑟夫问题，小孩出圈
        circleSingleLinkedList.countGirl(1,2,5);
    }

}
