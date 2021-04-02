package cn.wllsrx.zoe.java.algorithm;

/**
 * 线性查找法
 * <p>
 * 时间复杂度O(n)
 *
 * @author zoe
 **/
public class LinearSearch {

    private LinearSearch() {
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 4, 6, 1, 3};
        System.out.println(search(nums, 10));
        System.out.println(search(nums, 6));
        Student[] students = {new Student("Alice"), new Student("BObo"), new Student("Charles")};
        Student student = new Student("BObo");
        System.out.println(search(students, student));
    }

    /**
     * @param nums   数组
     * @param target 目标参数
     * @return 目标参数下标
     * <p>
     * 从下标0开始循环,若当前下标的值等于目标参数,返回当前下标,若循环结束,为找到目标参数,则返回-1
     */
    public static <E> Integer search(E[] nums, E target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
