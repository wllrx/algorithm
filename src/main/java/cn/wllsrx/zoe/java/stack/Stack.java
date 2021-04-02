package cn.wllsrx.zoe.java.stack;

/**
 * @author zoe
 **/
public interface Stack<E> {
    /**
     * 获取栈中元素个数
     *
     * 时间复杂度 O(1)
     * @return int
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * 时间复杂度 O(1)
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 在栈中添加元素e(入栈)
     *
     * 时间复杂度 O(1)均摊
     * @param e 元素
     */
    void push(E e);

    /**
     * 从栈中取出元素(出栈)
     *
     * 时间复杂度 O(1)均摊
     * @return E
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * 时间复杂度 O(1)
     * @return E
     */
    E peek();

}
