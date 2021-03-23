package cn.wllsrx.zoe.java;

/**
 * @author zoe
 **/
public class Array {

    private Integer[] data;
    private Integer size;

    /**
     * 用户传入数组长度
     *
     * @param capacity 数组长度
     */
    public Array(Integer capacity) {
        this.data = new Integer[capacity];
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
    public Integer getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 容量
     */
    public Integer getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return 结果
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素后添加一个新元素
     *
     * @param e 新元素
     */
    public void addLast(Integer e) {
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
    public void addFirst(Integer e) {
        add(0, e);
    }

    /**
     * 在传入索引的位置插入新元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(Integer index, Integer e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed. array is full");
        }
        //判断要插入的索引位置是否大于0
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. array is full");
        }
        //从最后一个下标开始,将下标大于index的元素向后挪,直到index索引位置,将e插入
        for (int i = size - 1; i >= index; i--) {
            //给后一个位置的元素赋上前一个元素的值
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

}
