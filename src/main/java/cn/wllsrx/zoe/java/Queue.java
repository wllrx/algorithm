package cn.wllsrx.zoe.java;

/**
 * @author zoe
 **/
public interface Queue<E> {

    /**
     * 入队操作
     *
     * 时间复杂度 O(1) 均摊 ArrayQueue 和 LoopQueue同
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 出队操作
     *
     * 时间复杂度 O(n)  ArrayQueue复杂度为O(n)  LoopQueue复杂度O(1) 均摊
     * 出队拿出数组中第一个元素后,剩下的元素都要前移
     * @return 元素
     */
    E dequeue();

    /**
     * 查看队列队首的元素
     *
     * 时间复杂度 O(1)  ArrayQueue 和 LoopQueue同
     * @return 元素
     */
    E getFront();

    /**
     * 获取队列的数量
     *
     * 时间复杂度 O(1) ArrayQueue 和 LoopQueue同
     * @return size
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * 时间复杂度 O(1) ArrayQueue 和 LoopQueue同
     * @return true为空, false反之
     */
    boolean isEmpty();
}
