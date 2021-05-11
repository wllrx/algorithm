package cn.wllsrx.zoe.test;

import cn.wllsrx.zoe.java.queue.ArrayQueue;
import cn.wllsrx.zoe.java.queue.LinkedListQueue;
import cn.wllsrx.zoe.java.queue.LoopQueue;
import cn.wllsrx.zoe.java.queue.Queue;

import java.security.SecureRandom;

/**
 * @author zoe
 **/
public class TestQueue {

    public static void main(String[] args) {
        int opCount = 100000;
        System.out.println("数组队列ArrayQueue耗时:  " + testQueue(new ArrayQueue<>(), opCount) + "s");
        System.out.println("循环队列LoopQueue耗时:  " + testQueue(new LoopQueue<>(), opCount) + "s");
        System.out.println("链表队列LinkedListQueue耗时:  " + testQueue(new LinkedListQueue<>(), opCount) + "s");
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < opCount; i++) {
            //入队操作
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            //出队操作
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
