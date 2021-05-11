package cn.wllsrx.zoe.java.linkedlist;

/**
 * 增删改查时间复杂度都为O(n)
 *
 * 增删查只对链表头进行操作时间复杂度为O(1)
 * @author zoe
 **/
public class LinkedList<E> {

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

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return 个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 为空true 反之false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表index位置添加元素  时间复杂度O(n)
     *
     * @param index 索引0开始
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. illegal index");
        }
        //dummyHead是索引0前面的一个元素
        Node prev = dummyHead;
        //遍历index前一个位置的元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 在链表的头添加新的元素e  时间复杂度O(n)
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加元素 时间复杂度O(1)
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取索引位置的元素 时间复杂度O(n)
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        //检查索引下标
        this.checkIndex(index);
        //获取索引所在位置的元素,dummyHead.next是链表的第一个元素
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表第一个元素
     *
     * @return E
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改索引index位置的元素为e   时间复杂度O(n)
     *
     * @param index 索引
     * @param e     元素
     */
    public void set(int index, E e) {
        this.checkIndex(index);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 删除索引位置的元素 时间复杂度O(n)
     *
     * @param index 索引
     * @return 被删除元素
     */
    public E remove(int index) {
        this.checkIndex(index);
        //索引位置的前一个元素
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //被删除索引位置的元素
        Node del = pre.next;
        pre.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    /**
     * 删除链表第一个元素 时间复杂度O(1)
     *
     * @return 被删除元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表最后一个元素 时间复杂度O(n)
     *
     * @return 被删除元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 检查索引是否合法
     *
     * @param index 索引
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed. illegal index");
        }
    }

    /**
     * 判断元素是否存在 时间复杂度O(n)
     *
     * @param e 元素
     * @return 是否存在
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            builder.append(cur).append("->");
        }
        builder.append("null");
        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 888);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
