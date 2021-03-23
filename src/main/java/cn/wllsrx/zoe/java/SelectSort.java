package cn.wllsrx.zoe.java;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 时间复杂度O(n^2)(n的平方)
 *
 * @author zoe
 **/
public class SelectSort {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 6, 3, 5, 1};
        sort(nums);
        sort2(nums);
        Student[] students = new Student[]{new Student("a", 8),
                new Student("2", 5),
                new Student("3", 3)};
        sort(students);
        SortingHelper.sortTest("SelectSort", nums);
    }

    public static <E extends Comparable<E>> void sort(E[] nums) {
        int length = nums.length;
        //nums[0...i]有序  nums[i...n)无序
        for (int i = 0; i < length; i++) {
            //选择nums中最小值的索引
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (nums[j].compareTo(nums[minIndex]) < 0) {
                    minIndex = j;
                }
                E num = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = num;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static <E extends Comparable<E>> void sort2(E[] nums) {
        int length = nums.length - 1;
        //nums[0...i]无序  nums[i...n)有序
        for (int i = length; i >= 0; i--) {
            //当前最大索引
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (nums[j].compareTo(nums[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(nums, i, maxIndex);
        }
        System.out.println(Arrays.toString(nums));
    }

    private static <E> void swap(E[] nums, int i, int minIndex) {
        E num = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = num;
    }


}
