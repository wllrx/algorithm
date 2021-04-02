package cn.wllsrx.zoe.java.array;

/**
 * 实现动态数组的数据结构
 *
 * @author zoe
 * <p>
 * 时间复杂度
 * <p>
 * addLast(e) O(1)
 * addFirst(e) O(n)
 * add(index,e) O(n/2)=O(n)
 * 添加的操作时间复杂度总的复杂度为O(n)
 * <p>
 * removeLast(e) O(1)
 * removeFirst(e)  O(n)
 * remove(index,e)  O(n/2)=O(n)
 * 删除操作时间复杂度 O(n)  resize时间复杂度O(1)
 * <p>
 * set(index,e)   O(1)
 * 修改操作复杂度  已知索引O(1)  未知索引 O(n)
 * <p>
 * get(index)  O(1)
 * contains(e) O(n)
 * find(e) O(n)
 * 查询操作时间复杂度 已知索引O(1)  未知索引 O(n)
 **/
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 用户传入数组长度
     *
     * @param capacity 数组长度
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return 结果
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素后添加一个新元素
     *
     * @param e 新元素
     */
    public void addLast(E e) {
        /*if (size == data.length) {
            throw new IllegalArgumentException("addLast failed. array is full");
        }
        data[size] = e;
        size++;*/
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e 新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在传入索引的位置插入新元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        //判断要插入的索引位置是否大于0
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. array is full");
        }
        if (size == data.length) {
            //数组内存扩容两倍
            resize(2 * data.length);
        }

        //从最后一个下标开始,将下标大于index的元素向后挪,直到index索引位置,将e插入
        for (int i = size - 1; i >= index; i--) {
            //给后一个位置的元素赋上前一个元素的值
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引位置
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. index is illegal");
        }
        return data[index];
    }

    /**
     * 查询数组的最后一个元素
     *
     * @return E
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取数组第一个元素
     *
     * @return E
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引
     * @param e     新元素
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. index is illegal");
        }
        data[index] = e;
    }

    /**
     * 数组中是否存在元素e
     *
     * @param e 元素
     * @return 存在true
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询元素的索引
     *
     * @param e 元素
     * @return 存在返回索引, 不存在返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除当前索引位置的元素,返回删除元素
     *
     * @param index 索引
     * @return 删除元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //data[size] = null;
        //动态缩容数组长度 当实际数组长度是数组的四分之一时,将数组长度减半,防止复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中的第一个元素
     *
     * @return 被删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     *
     * @return 被删除得元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素e
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d,capacity = %d\n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }


    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 54);
        System.out.println(array);
    }
}
