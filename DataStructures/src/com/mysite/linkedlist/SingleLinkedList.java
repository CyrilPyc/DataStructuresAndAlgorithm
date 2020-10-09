package com.mysite.linkedlist;

import java.text.SimpleDateFormat;

/**
 * @author Cyril.P
 * @date 2020-08-21-13:19
 */
public class SingleLinkedList {

    /**
     * 初始化一个头节点，头节点不要动
     */
    private Wife head = new Wife(0, "", 0);

    public Wife getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时，
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next 指向 新的节点
     *
     * @param wife
     */
    public void add(Wife wife) {
        //因为 head 节点不能动，因此需要一个辅助变量 temp
        Wife temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.getNext() == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.getNext();
        }
        //当退出 while 循环时，temp 就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.setNext(wife);
    }

    /**
     * 第二种添加方式在添加时，根据序号将人物插入到指定位置
     * （如果已经有这个序号了，则添加失败，并给出提示）
     *
     * @param wife
     */
    public void addByOrder(Wife wife) {
        //因为头节点不能动，因此我们仍然需要通过一个辅助变量指针来帮助找到添加的位置
        //因为是单链表，因此我们找的 temp 是位于添加位置的前一个节点，否则插入不了
        Wife temp = head;
        //flag 标志添加添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            //说明 temp 已经到链表的最后
            if (temp.getNext() == null) {
                break;
            }
            //第一种情况，位置找到，就在 temp 的后面插入
            //第二种情况，说明希望添加的 wife 的 id 已经存在
            if (temp.getNext().getId() > wife.getId()) {
                break;
            } else if (temp.getNext().getId() == wife.getId()) {
                //说明编号存在
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.getNext();
        }
        //判断flag的值
        //flag的值为true时，不能添加，说明编号存在
        if (flag) {
            System.out.println("准备插入的老婆" + wife.getId() + " " + wife.getName() + " 已经有了，不能加入了");
        } else {
            //插入到链表中，temp的后面
            wife.setNext(temp.getNext());
            temp.setNext(wife);
        }
    }

    /**
     * 修改节点的信息，根据 id 编号l来修改，即 id 编号不变
     * 说明：
     * 1.根据 newWife 的 id 来修改即可
     */
    public void update(Wife newWife) {
        //判断链表是否为空
        if (head.getName() == null) {
            System.out.println("你没有老婆");
            return;
        }
        //找到需要修改的节点，根据 id 编号
        //定义一个辅助变量 temp
        Wife temp = head.getNext();
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.getId() == newWife.getId()) {
                //找到
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        //根据 flag 判断是否找到需要修改的节点
        if (flag == true) {
            temp.setName(newWife.getName());
            temp.setAge(newWife.getAge());
        } else {//没有找到
            System.out.println("没有在已有老婆编号中找到这个老婆" + newWife.getId() + "欸");
        }

    }

    //删除节点
    //思路
    //1.head 节点不能动，因此我们需要一个辅助指针变量temp找到待删除节点的前一个节点
    //2.说明我们在比较时，是 temp.getNext().getId 和 需要删除的节点的 id 比较
    public void del(int id) {
        Wife temp = head;
        boolean flag = false; //标志是否找到待删除节点的前一个节点
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getNext(); //temp遍历，别忘啊！
        }
        //判断flag
        if (flag) { //找到
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("找不到这个id的老婆" + id);
        }
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("你没有老婆");
            return;
        }
        //因为头节点不能动，因此需要辅助变量来遍历
        Wife temp = head.getNext();
        while (true) {
            if (temp == null) {
                break; //判断是否到链表最后
            }
            //输出节点的信息
            System.out.println(temp);
            //将 tamp 后移
            temp = temp.getNext();
        }
    }

}
