package cn.wllsrx.zoe.leetcode.java;

import cn.wllsrx.zoe.java.stack.ArrayStack;

import java.util.*;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 *
 * @author zoe
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid2("()[]{}"));
        System.out.println(isValid3("()[]{}"));
        System.out.println(isValid3("([]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                //将左括号全部放入栈中
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //删除栈顶元素并返回栈顶元素
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        int n = s.length();
        //当括号成对时必然是偶数,若不为偶数可直接返回false
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //当元素是右括号时,删除栈顶元素使用返回的被删除的栈顶元素判断是否等于当前key元素的value值,不等直接返回false
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(ch))) {
                    return false;
                }
            } else {
                //当元素是左括号时存入栈中
                stack.push(ch);
            }
        }
        //循环完毕,判断栈中是否还有元素,若没有元素则为ture
        return stack.isEmpty();
    }

    public static boolean isValid3(String s){
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                //将左括号全部放入栈中
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //删除栈顶元素并返回栈顶元素
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
