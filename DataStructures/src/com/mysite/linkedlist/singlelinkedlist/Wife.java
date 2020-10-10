package com.mysite.linkedlist.singlelinkedlist;

/**
 * @author Cyril.P
 * @date 2020-08-21-12:57
 */
public class Wife {

    private Integer id;
    private String name;
    private Integer age;
    private Wife next;

    public Wife(Integer id, String name, Integer age) {
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

    public Wife getNext() {
        return next;
    }

    public void setNext(Wife next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "我的老婆们{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
