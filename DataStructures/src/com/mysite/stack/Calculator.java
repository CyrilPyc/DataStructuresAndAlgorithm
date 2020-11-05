package com.mysite.stack;

import org.junit.Test;

/**
 * @author Cyril.P
 * @description
 * @date 2020-10-27-15:33
 */
public class Calculator {
    @Test
    public void test(){
        int add = '+';
        int min = '-';
        int mul = '*';
        int div = '/';
        System.out.println(add + " " + min + " " + mul + " " + div);
    }

    public static void main(String[] args) {
        String expression = "63/21-9/3+2*6-4*2/1+9/3-1";
        /**
         * 创建两个栈，一个数栈，一个符号栈
         */
        ArrayStack1 numStack = new ArrayStack1(10);
        ArrayStack1 operStack = new ArrayStack1(10);
        //定义index用于遍历
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //定义keepNum用于拼接多位数
        String keepNum = "";
        //将每次遍历得到的char保存到ch
        char ch = ' ';
        /**
         * while循环扫描遍历expression
         */
        while (true) {
            //依次得到expressiond的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应处理
            if (operStack.isOper(ch)) {
                //如果是运算符，判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，
                    //再从符号栈中pop出一个符号，进行运算再将得到的结果入数栈，然后将当前的操作符压入符号栈
                    for (int i = 0; i < operStack.size() + 1; i++) {
                        /**
                         * 此处for循环解决接连出现操作符的优先级小于或者等于符号栈中操作符的优先级，如，9-2*6-3，最后一个'-'做判断时先小于'*'，然后又小于第一个'-'
                         * 如果不作for循环，那在处理完第二个'-'小于'*'之后就入栈了，此时符号栈中就出现了两个同等级的'-'，按此逻辑再做后续操作的话就会出现，
                         * 2*6 的结果 12 先减去 3 等于 9 压入数栈，然后再 9-9 等于 0 作为最终结果。但根据原表达式 9-2*6-3 计算的话正确答案应该是 -6
                         *
                         * ！此处要注意for循环遍历的判断条件是一个可变值，在栈中有一个根据 此时top 值计算栈中元素个数的方法！
                         * 如果在把符号栈中符合条件的符号元素 pop 出的情况下，此时 top 是减减过的，那么在有可能的下一次for循环中，在调用 size 方法时就已经减减了，
                         * 而for循环中的i是加加过的，就会导致循环进不去，那么下一个该操作掉的操作符即使符合条件也是操作不了的，因此要对 i 也进行一次减减的操作，
                         * 但是对 i 减减的操作只需要加在操作符有 pop 出去的情况下就好了，即与 top 值同等减减
                         */
                        if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            res = operStack.cal(num1, num2, oper);
                            //把运算的结果压入数栈
                            numStack.push(res);
                            i--;
                            continue;
                            //把当前操作符压入符号栈
//                            operStack.push(ch);
                        } else {
                            //如果当前的操作符的优先级大于栈中的操作符，就直接压入符号栈
//                            operStack.push(ch);
                            break;
                        }
                    }
                    operStack.push(ch);
                } else {
                    //如果符号栈为空符号直接入栈
                    operStack.push(ch);
                }
            } else {
                /**
                 * 如果是数，则直接压入数栈。注意此时的ch是char，要对应ASCII码，'1' => 49，'2' => 50，相差48，要做相减才是数字;  ch - 48 = ch - '0'
                 * 1、当处理多位数时，不能发现是一个数就立即入栈
                 * 2、在处理数，需要向expression的表达式的 index 后再看一位，如果是数就继续扫描，如果是符号就入栈
                 * 3、定义一个字符串变量，用于拼接数字
                 */
                //处理多位数
                keepNum += ch;

                //如果 ch 已经是 expression 最后一位，就直接入参
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符s是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈。别忘了类型转换
                        numStack.push(Integer.parseInt(keepNum));
                        //！！！记住要把keepNum清空，以便以便下一个数字使用
                        keepNum = "";
                    }
                }
            }
            //index++，并判断是否扫描遍历到expression末尾
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描遍历完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运算。
        while (true) {
            //如果符号栈为空，数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("表达式 = " + expression + "，结果 = " + numStack.pop() + "，正确答案应该 = " + (63/21-9/3+2*6-4*2/1+9/3-1));

    }

}

/**
 * 先创建一个栈
 */
class ArrayStack1 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isTwoMore() {
        return top >= 1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("满出来了！");
            return;
        }
        stack[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空空如也！");
        }
        return stack[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("空空如也，没什么好看的");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    /**
     * 返回当前栈顶的值，但不是真正的 pop
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 返回当前栈大小
     */
    public int size() {
        int temp = top;
        return temp;
    }


    /**
     * 数字越大，则优先级越高。假定目前的表达式只有 + - * /
     * 返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0; //res用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
