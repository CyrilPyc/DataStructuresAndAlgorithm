package com.mysite.linkedlist.singlelinkedlist;


import com.mysite.linkedlist.singlelinkedlist.Wife;
import org.junit.Test;

import java.util.Stack;

/**
 * 1、求单链表中有效节点的个数
 * 2、查找单链表中的倒数第 k 个节点【新浪面试题】
 * 3、单链表的反转【腾讯面试题】
 * 4、从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack栈】
 * 5、合并两个有序的单链表，合并之后的链表依然有序
 *
 * @author Cyril.P
 * @date 2020-09-30-15:47
 */
public class Exer {

    /**
     * 方法：获取到单链表的节点的个数（如果是带头节点的链表，不需要统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(Wife head) {
        if (head.getNext() == null) { //带头节点的空链表
            return 0;
        }
        int len = 0;
        //定义一个辅助指针变量,此处该辅助变量直接指向头节点之后的一个节点开始遍历，就说明没有统计头节点
        Wife current = head.getNext();
        while (current != null) {
            len++;
            current = current.getNext(); //遍历
        }
        return len;
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * 思路：
     * 1、编写一个方法，接收head节点，同时接收一个index
     * 2、index表示倒数第index个节点
     * 3、先把链表从头到尾遍历，得到链表的总的长度getLength
     * 4、得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到倒数第k个节点
     * 5、如果找到了，则返回该节点，否则返回null
     *
     * @param head
     * @param index
     * @return
     */
    public static Wife findLastIndexNode(Wife head, int index) {
        //判断如果链表为空，返回null
        if (head.getNext() == null) {
            return null;
        }
        //第一个遍历得到链表长度（节点个数）
        int size = getLength(head);
        //第二次遍历 size-index 位置，就是倒数的第k个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助指针变量 current，for 循环定位到倒数的index
        Wife current = head.getNext();
        for (int i = 0; i < size - index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * 单链表的反转【腾讯面试题】
     *
     * @param head
     */
    public static void reverseList(Wife head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        Wife current = head.getNext(); //定义一个辅助的指针变量，帮助遍历原来的链表
        Wife next = null; //指向当前节点[current]的下一个节点
        Wife reverseHead = new Wife(0, "", 0);
        //遍历原来的链表，并从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端
        //动脑筋！
        while (current != null) {
            next = current.getNext(); //先暂时保存当前节点的下一个节点，因为后面需要使用
            current.setNext(reverseHead.getNext()); //将 current 的下一个节点指向新的链表的最前端
            reverseHead.setNext(current); //将 current 连接到新的链表上
            current = next; //让 current 后移
        }
        //将 head.next 指向 reverseHead.next ，实现单链表的反转
        head.setNext(reverseHead.getNext());
    }

    /**
     * 从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack栈】
     */
    public static void reversePrint(Wife head) {
        if (head.getNext() == null) {
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<Wife> stack = new Stack<>();
        Wife current = head.getNext();
        //将链表的所有节点压入栈
        while (current != null) {
            stack.push(current);
            current = current.getNext(); //将 current 后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印，pop 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop()); //stack的特点 先进后出
        }
    }

    @Test
    public void stackTest() {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("aaa");
        stack.add("bbb");
        stack.add("ccc");
        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     *
     * @param head1
     * @param head2
     */
    public static void mergeSortedList(Wife head1, Wife head2) {
        if (head1.getNext() == null && head2.getNext() == null) {
            return;
        }
        Wife current1 = head1.getNext();
        Wife current2 = head2.getNext();
        Wife mergeHead = new Wife(0, "", 0);
        Wife temp = mergeHead;
        if (current1 != null && current2 != null) {
            while (current1 != null && current2 != null) {
                if (current1.getId() <= current2.getId()) {
                    temp.setNext(current1);
                    temp = temp.getNext();
                    current1 = current1.getNext();
                } else {
                    temp.setNext(current2);
                    temp = temp.getNext();
                    current2 = current2.getNext();
                }
            }
        }
        if (current1 == null) {
            while (current2 != null) {
                temp.setNext(current2);
                temp = temp.getNext();
                current2 = current2.getNext();
            }
        }
        if (current2 == null) {
            while (current1 != null) {
                temp.setNext(current1);
                temp = temp.getNext();
                current1 = current1.getNext();
            }
        }
        head1.setNext(mergeHead.getNext());
    }
}
