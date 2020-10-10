package com.mysite.linkedlist.doublelinkedlist;

/**
 * @author Cyril.P
 * @date 2020-10-09-17:02
 */
public class Wife2 {

    private Integer id;
    private String name;
    private Integer age;
    private Wife2 next; //指向下一个节点，默认为null
    private Wife2 pre; //指向下一个节点，默认为null

    public Wife2(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Wife2 getNext() {
        return next;
    }

    public void setNext(Wife2 next) {
        this.next = next;
    }

    public Wife2 getPre() {
        return pre;
    }

    public void setPre(Wife2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "我的老婆们{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
