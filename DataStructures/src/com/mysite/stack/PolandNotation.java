package com.mysite.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Cyril.P
 * @description
 * @date 2020-10-29-16:20
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成将一个中缀表达式转换成后缀表达式的功能
        //1、10+((2+3)*4)-5 => 10 2 3 + 4 * + 5 -
        //2、因为直接对 str 进行操作，对字符串遍历操作不方便，因此先将 "10+((2+3)*4)-5" => 中缀表达式对应的List
        String expression = "10+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List：" + infixExpressionList);
        //3、将得到的中缀表达式对应的List => 后缀表达式对应的List
        //即 ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList[1,2,3,+,4,*,+,5,-]
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List：" + suffixExpressionList);
        System.out.println(expression + "=" + calculate(suffixExpressionList));

//        //先定义一个逆波兰表达式 (3+4)*5-6 => 3 4 + 5 * 6 -
//        //为了方便，逆波兰表达式的数字和符号使用空格隔开；也可以自己过滤处理
//        String suffixExpression = "3 4 + 5 * 6 -";
//        //1、先将"3 4 + 5 * 6 -" => 放到 ArrayList 中
//        List<String> list = getListString(suffixExpression);
//
//        //2、将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈完成计算
//        System.out.println(calculate(list));

    }

    //方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个栈
        Stack<String> s1 = new Stack();
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出，因此比较麻烦，就直接使用ArrayList即可
//        Stack<String> s2 = new Stack();
        List<String> s2 = new ArrayList<>();
        //遍历list
        for (String item : list) {
            //如果是个数字，进入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (("(").equals(item)) {
                s1.push(item);
            } else if ((")").equals(item)) {
                //如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                //！！！将 "(" 弹出 s1 栈
                s1.pop();
            } else {
                //当item的优先级小于等于s1栈顶运算符的优先级，将栈顶的运算符弹出并进入s2中，再次与s1新栈顶运算符相比较
                //缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要j将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        //因为元素是放入了List中，顺序已经是对应起来了的
        return s2;
    }

    //方法：将中缀表达式转换成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        //接收遍历s得到的每一个字符
        char c = ' ';
        //对多位数的拼接
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            //如果c不是一个数字，就进入list  '0':48, '9':57
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
            } else {
                str += c;
                if (i == s.length() - 1) {
                    list.add("" + c);
                } else {
                    if ((c = s.charAt(i + 1)) < 48 || (c = s.charAt(i + 1)) > 57) {
                        list.add(str);
                        //将str清空
                        str = "";
                    }
                }
            }
        }
        return list;
    }


    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String str : split) {
            list.add(str);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     * <p>
     * 1、从左至右扫描。将3和4压入堆栈；
     * 2、遇到'+'运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3、将5入栈
     * 4、接下来是'×'运算符，因此弹出5和7，计算出7×5=35，将35入栈
     * 5、将6入栈
     * 6、最后是'-'运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> list) {
        //创建个栈
        Stack<String> stack = new Stack<>();
        //遍历 list
        for (String item : list) {
            //使用正则表达式取出数 "\\d+":匹配多位数
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类 Operation 可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
