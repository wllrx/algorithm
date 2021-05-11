package cn.wllsrx.zoe.java.queue;

/**
 * @author zoe
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public void enqueue(E e) {
        //如果队尾为空,说明队首也为空
        if (tail == null) {
            //直接在队尾添加节点
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        this.checkSize();
        //出队是删除队首,也就是head
        Node ret = head;
        //把head指向之前head的下一个节点
        head = ret.next;
        //之前的head的下一个节点改为空
        ret.next = null;
        //修改head指向后队列可能为空
        if (head == null) {
            tail = null;
        }
        size--;
        return ret.e;
    }

    private void checkSize() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
    }

    @Override
    public E getFront() {
        this.checkSize();
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: front ");
        Node cur = head;
        while (cur!=null){
            builder.append(cur).append("->");
            cur = cur.next;
        }
        builder.append("Null tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            //向队列中添加元素
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
