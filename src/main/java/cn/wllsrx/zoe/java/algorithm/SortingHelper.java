package cn.wllsrx.zoe.java.algorithm;

/**
 * @author zoe
 **/
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if ("SelectSort".equals(sortName)) {
            SelectSort.sort(arr);
        }else if ("InsertionSort".equals(sortName)){
            InsertionSort.sort(arr);
            InsertionSort.sort2(arr);
        }
        long endTime = System.nanoTime();
        long result = endTime - startTime;
        System.out.println("耗时 " + result / 1000000000.0 + "s");
    }

    public static void main(String[] args) {
        int[] data = {10000,100000};

    }
}

