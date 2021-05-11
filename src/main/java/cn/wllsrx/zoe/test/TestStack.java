package cn.wllsrx.zoe.test;

import cn.wllsrx.zoe.java.stack.ArrayStack;
import cn.wllsrx.zoe.java.stack.LinkedListStack;
import cn.wllsrx.zoe.java.stack.Stack;

import java.security.SecureRandom;

/**
 * @author zoe
 **/
public class TestStack {
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("ArrayStack, time: " + testStack(arrayStack, opCount) + "s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("LinkedListStack, time: " + testStack(linkedListStack, opCount) + "s");
    }

    public static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
