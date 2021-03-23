package cn.wllsrx.zoe.java;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author zoe
 **/
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    /**
     * 生成有序数组
     *
     * @param n 数组长度
     * @return 数组
     */
    public static Integer[] generatorOrderArray(Integer n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成无序不重复数组
     *
     * @param n     数组长度
     * @param bound 上限
     * @return 数组
     */
    public static Integer[] generatorRandomArray(Integer n, Integer bound) {
        Integer[] arr = new Integer[n];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return Arrays.stream(arr).distinct().toArray(Integer[]::new);
    }

    /**
     * 对比耗时
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] data = {10000, 100000};
//        linearSearch(data);
//        selectSort(data);
        insertionSort(data);
    }

    /**
     * 线性查找算法时间耗时对比
     *
     * @param data data
     */
    public static void linearSearch(int[] data) {
        for (int n : data) {
            Integer[] array = generatorOrderArray(n);
            //纳秒为单位
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(array, n);
            }
            long endTime = System.nanoTime();
            long result = endTime - startTime;
            System.out.println("线性查找 " + "n的值为 " + n + "  循环执行 100次 " + "  耗时 " + result / 1000000000.0 + "s");
        }
    }

    /**
     * 选择排序时间耗时
     *
     * @param data data
     */
    public static void selectSort(int[] data) {
        for (int n : data) {
            Integer[] randomArray = generatorRandomArray(n, n);
            long startTime = System.nanoTime();
            SelectSort.sort(randomArray);
            if (!SortingHelper.isSorted(randomArray)) {
                throw new RuntimeException("排序算法异常");
            }
            long endTime = System.nanoTime();
            long result = endTime - startTime;
            System.out.println("选择排序 " + "n的值为 " + n + "耗时 " + result / 1000000000.0 + "s");
        }
    }


    /**
     * 插入排序时间耗时
     *
     * @param data data
     */
    public static void insertionSort(int[] data) {
        for (int n : data) {
            Integer[] randomArray = generatorRandomArray(n, n);
            long startTime = System.nanoTime();
            //未优化
            InsertionSort.sort(randomArray);
            //常数级优化
            InsertionSort.sort4(randomArray);
            if (!SortingHelper.isSorted(randomArray)) {
                throw new RuntimeException("排序算法异常");
            }
            long endTime = System.nanoTime();
            long result = endTime - startTime;
            System.out.println("插入排序 " + "n的值为 " + n + "耗时 " + result / 1000000000.0 + "s");
        }
    }

}
