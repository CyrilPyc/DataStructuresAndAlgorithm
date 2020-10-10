package com.mysite.linkedlist.singlelinkedlist;

/**
 * @author Cyril.P
 * @date 2020-08-21-12:57
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        Wife wife1 = new Wife(1, "迪丽热巴", 27);
        Wife wife2 = new Wife(2, "古力娜扎", 27);
        Wife wife3 = new Wife(3, "赵露思", 22);
        Wife wife4 = new Wife(4, "宋祖儿", 20);

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //添加老婆
//        singleLinkedList.add(wife1);
//        singleLinkedList.add(wife2);
//        singleLinkedList.add(wife3);
//        singleLinkedList.add(wife4);

        //添加按照编号的老婆
        singleLinkedList.addByOrder(wife1);
        singleLinkedList.addByOrder(wife1);
        singleLinkedList.addByOrder(wife4);
        singleLinkedList.addByOrder(wife3);
        singleLinkedList.addByOrder(wife2);

        singleLinkedList.list();
        System.out.println();

        //测试修改
        singleLinkedList.update(new Wife(4, "铃木爱理", 25));
        singleLinkedList.update(new Wife(5, "铃木爱理", 25));

        singleLinkedList.list();
        System.out.println();

        //测试删除
        singleLinkedList.del(3);
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(4);
//        singleLinkedList.del(5);

        singleLinkedList.list();
        System.out.println();

        //测试 求单链表中有效节点的个数
        System.out.println(Exer.getLength(singleLinkedList.getHead()));
        System.out.println();

        //测试 查找单链表中的倒数第k个节点【新浪面试题】
        System.out.println(Exer.findLastIndexNode(singleLinkedList.getHead(), 2));
        System.out.println();

        //测试 单链表的反转【腾讯面试题】
//        Exer.reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
//        System.out.println();

        //测试 逆序打印单链表
        System.out.println("逆序打印");
        Exer.reversePrint(singleLinkedList.getHead());
        System.out.println("**********");

        //测试 合并两个有序的单链表，合并之后的链表依然有序
        //创建节点
        Wife wife11 = new Wife(1, "迪丽热巴", 27);
        Wife wife12 = new Wife(4, "古力娜扎", 27);
        Wife wife13 = new Wife(5, "赵露思", 22);
        Wife wife14 = new Wife(9, "宋祖儿", 20);
        Wife wife21 = new Wife(2, "迪丽热巴", 27);
        Wife wife22 = new Wife(3, "古力娜扎", 27);
        Wife wife23 = new Wife(6, "赵露思", 22);
        Wife wife24 = new Wife(8, "宋祖儿", 20);
//        Wife wife11 = new Wife(3, "迪丽热巴", 27);
//        Wife wife12 = new Wife(5, "古力娜扎", 27);
//        Wife wife13 = new Wife(2, "赵露思", 22);
//        Wife wife14 = new Wife(4, "宋祖儿", 20);
//        Wife wife21 = new Wife(4, "迪丽热巴", 27);
//        Wife wife22 = new Wife(1, "古力娜扎", 27);
//        Wife wife23 = new Wife(7, "赵露思", 22);
//        Wife wife24 = new Wife(6, "宋祖儿", 20);

        //创建链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        singleLinkedList1.addByOrder(wife11);
        singleLinkedList1.addByOrder(wife12);
        singleLinkedList1.addByOrder(wife13);
//        singleLinkedList1.addByOrder(wife14);
        singleLinkedList2.addByOrder(wife21);
        singleLinkedList2.addByOrder(wife22);
        singleLinkedList2.addByOrder(wife23);
        singleLinkedList2.addByOrder(wife24);

        Exer.mergeSortedList(singleLinkedList1.getHead(), singleLinkedList2.getHead());
        singleLinkedList1.list();
    }

}
