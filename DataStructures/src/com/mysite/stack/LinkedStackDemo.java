package com.mysite.stack;

import java.util.Scanner;

/**
 * @author Cyril.P
 * @description
 * @date 2020-10-27-10:26
 */
public class LinkedStackDemo {

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show：显示我的老婆");
            System.out.println("exit：退出程序");
            System.out.println("push：添加个老婆（入栈）");
            System.out.println("pop：取出个老婆（出栈）");
            System.out.println("给我输入你要干嘛！");
            key = scanner.next();
            switch (key){
                case "show":
                    linkedStack.show();
                    break;
                case "push":
                    System.out.println("给我个老婆：");
                    System.out.println("老婆的编号呐");
                    int id = scanner.nextInt();
                    System.out.println("老婆叫什么啊");
                    String name = scanner.next();
                    System.out.println("老婆今年多大呐");
                    int age = scanner.nextInt();
                    linkedStack.push(new Wife(id,name,age));
                    break;
                case "pop":
                    try {
                        Wife res = linkedStack.pop();
                        System.out.println("老婆出来了！"+res);
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
