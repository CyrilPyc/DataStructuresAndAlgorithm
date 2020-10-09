package com.mysite.linkedlist;

/**
 * @author Cyril.P
 * @date 2020-10-09-17:02
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        //创建节点
        Wife2 wife1 = new Wife2(1, "迪丽热巴", 27);
        Wife2 wife2 = new Wife2(2, "古力娜扎", 27);
        Wife2 wife3 = new Wife2(3, "赵露思", 22);
        Wife2 wife4 = new Wife2(4, "宋祖儿", 20);

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

//        doubleLinkedList.add(wife1);
//        doubleLinkedList.add(wife2);
//        doubleLinkedList.add(wife3);
//        doubleLinkedList.add(wife4);

        //添加按照编号的老婆
        doubleLinkedList.addByOrder(wife1);
        doubleLinkedList.addByOrder(wife1);
        doubleLinkedList.addByOrder(wife4);
        doubleLinkedList.addByOrder(wife3);
        doubleLinkedList.addByOrder(wife2);

        doubleLinkedList.list();
        System.out.println();

        //测试修改
        doubleLinkedList.update(new Wife2(4, "铃木爱理", 25));
        doubleLinkedList.update(new Wife2(5, "铃木爱理", 25));

        doubleLinkedList.list();
        System.out.println();

        //测试删除
//        doubleLinkedList.del(3);
//        doubleLinkedList.del(1);
//        doubleLinkedList.del(2);
        doubleLinkedList.del(4);
//        doubleLinkedList.del(5);

        doubleLinkedList.list();
        System.out.println();
    }

}
