package com.mysite.linkedlist;

/**
 * @author Cyril.P
 * @date 2020-10-09-17:01
 */
public class DoubleLinkedList {

    /**
     * 初始化一个头节点，头节点不要动
     */
    private Wife2 head = new Wife2(0, "", 0);

    public Wife2 getHead() {
        return head;
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
        Wife2 temp = head.getNext();
        while (true) {
            if (temp == null) {
                break; //判断是否到链表最后
            }
            //输出节点的信息
            System.out.println(temp);
            //将 tamp 后移，一定不能忘！
            temp = temp.getNext();
        }
    }

    /**
     * 添加一个节点到双向链表的最后
     * @param wife
     */
    public void add(Wife2 wife) {
        //因为 head 节点不能动，因此需要一个辅助变量 temp
        Wife2 temp = head;
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
        //形成一个双向链表
        temp.setNext(wife);
        wife.setPre(temp);
    }

    /**
     * 第二种添加方式在添加时，根据序号将人物插入到指定位置
     * （如果已经有这个序号了，则添加失败，并给出提示）
     *
     * @param wife
     */
    public void addByOrder(Wife2 wife) {
        //因为头节点不能动，因此我们仍然需要通过一个辅助变量指针来帮助找到添加的位置
        //因为是单链表，因此我们找的 temp 是位于添加位置的前一个节点，否则插入不了
        Wife2 temp = head;
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
            } else if (temp.getNext().getId().equals(wife.getId())) {
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
            wife.setPre(temp);
            temp.setNext(wife);
            if (temp.getNext()!=null) {
                temp.getNext().setPre(wife);
            }
        }
    }

    /**
     * 修改一个节点的内容
     * @param newWife
     */
    public void update(Wife2 newWife) {
        //判断链表是否为空
        if (head.getName() == null) {
            System.out.println("你没有老婆");
            return;
        }
        //找到需要修改的节点，根据 id 编号
        //定义一个辅助变量 temp
        Wife2 temp = head.getNext();
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.getId().equals(newWife.getId())) {
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

    /**
     * 从双向链表中删除一个节点
     * 说明：
     * 1.对于双向链表，我们可以直接找到要删除的这个节点
     * 2.找到后，自我删除即可
     * @param id
     */
    public void del(int id) {

        //判断当前链表是否为空
        if (head.getNext()==null){
            System.out.println("根本就没有老婆，咋删");
            return;
        }

        Wife2 temp = head.getNext(); //辅助指针变量，此处可以直接指向 head 的下一个节点，区别于单链表是因为删除
                                     //操作要找到前一个节点，因此要从 head 节点开始。而现在双向链表可以自我删除
                                     //，因此可以从 head 下一个节点开始
        boolean flag = false; //标志是否找到待删除节点的前一个节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getId() == id) { //此处与单链表相比也做改变，不需要temp的下一个节点相比了，直接temp进行比较
                flag = true;
                break;
            }
            temp = temp.getNext(); //temp遍历，别忘啊！
        }
        //判断flag
        if (flag) { //找到
            temp.getPre().setNext(temp.getNext());
            //如果是最后一个节点，不需要执行下面的操作，否则会出现空指针异常
            if (temp.getNext()!=null) {
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            System.out.println("找不到这个id的老婆" + id);
        }
    }
}
