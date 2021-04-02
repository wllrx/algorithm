package cn.wllsrx.zoe.leetcode.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * <p>
 * 你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 * @author zoe
 **/
public class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //队列长度
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            //将队列的第一个元素删除并再次放入队列
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue.size() == 0) {
            throw new IllegalArgumentException("queue is empty");
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue.size() == 0) {
            throw new IllegalArgumentException("queue is empty");
        }
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}
