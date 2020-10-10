package com.mysite.linkedlist.circlesinglelinkedlist;

/**
 * 创建一个Wife3类，表示一个节点
 * @author Cyril.P
 * @date 2020-10-10-9:55
 */
public class Girl {

    private int id; //编号
    private Girl next; //指向下一个节点，默认null

    public Girl(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Girl getNext() {
        return next;
    }

    public void setNext(Girl next) {
        this.next = next;
    }
}
