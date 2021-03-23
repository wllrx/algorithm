package cn.wllsrx.zoe.java;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度O(n^2)(n的平方)
 * 对于有序数组时间复杂度为O(n)
 *
 * @author zoe
 **/
public class InsertionSort {
    public static void main(String[] args) {
        Integer[] nums = {5, 2, 4, 6, 1, 3};
        sort(nums);
        sort2(nums);
        sort3(nums);
        sort4(nums);
    }

    public static <E extends Comparable<E>> void sort(E[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int j = i;
            //将nums[i]插入到合适的位置
            while (j - 1 >= 0) {
                if (nums[j].compareTo(nums[j - 1]) < 0) {
                    E num = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = num;
                }
                j--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static <E extends Comparable<E>> void sort2(E[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //将nums[i]插入到合适的位置
            //第一种写法
            for (int j = i; j - 1 >= 0; j--) {
                if (nums[j].compareTo(nums[j - 1]) < 0) {
                    E num = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = num;
                }
            }
            //第二种写法
            for (int j = i; j - 1 >= 0 && nums[j].compareTo(nums[j - 1]) < 0; j--) {
                E num = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = num;
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }


    /**
     * 优化后的排序方法
     * <p>
     * 前面方法都是采用比较一次给相关元素赋值一次,优化后采用位置向后平滑设置值,最后赋值给正在寻找位置插入的值
     *
     * @param arr 数组
     * @param <E> E
     */
    public static <E extends Comparable<E>> void sort4(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
        System.out.println(Arrays.toString(arr));
    }


}
