package com.mysite.stack;

/**
 * @author Cyril.P
 * @description
 * @date 2020-10-22-16:49
 */

public class LinkedStack {

    private Wife head = new Wife(0, "", 0);

    private Wife getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void push(Wife wife) {
        Wife temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(wife);
    }

    public Wife pop() {
        if (isEmpty()){
            throw new RuntimeException("空空如也");
        }
        Wife temp = head.getNext();
        head.setNext(head.getNext().getNext());
        return temp;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("空空如也，展示个啥哦");
            return;
        }
        Wife temp = head.getNext();
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}
