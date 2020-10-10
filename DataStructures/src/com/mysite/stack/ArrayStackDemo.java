package com.mysite.stack;

import java.util.Scanner;

/**
 * @author Cyril.P
 * @date 2020-10-10-17:25
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试
        //先创建一个ArrayStack对象，表示一个栈
        ArrayStack arrayStack = new ArrayStack(4);
//        arrayStack.push(3);
//        arrayStack.push(5);
//        arrayStack.push(7);
//        arrayStack.push(26);
//        arrayStack.push(26);
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.list();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：添加数据到栈（入栈）");
            System.out.println("pop：从栈取出数据（出栈）");
            System.out.println("给我输入你要干嘛！");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("给我输个数：");
                    int val = scanner.nextInt();
                    arrayStack.push(val);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println("这是出栈的数据："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("我走了，886！");
    }

}
