package cn.wllsrx.zoe.leetcode.java;

/**
 * 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 提示：
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * @author zoe
 **/
public class LinkSolution {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        //使用arr作为参数,创建链表,当前得listNode为链表头节点
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("arr can not be empty");
            }
            //将数组第一个元素作为头节点
            this.val = arr[0];
            //当前节点
            ListNode cur = this;
            //循环遍历从第二个元素开始放到节点的下一节点
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                //将加入的节点赋值给当前节点,遍历添加这一节点的下一节点
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            ListNode cur = this;
            while (cur != null){
                stringBuilder.append(cur.val).append("->");
                cur = cur.next;
            }
            stringBuilder.append("null");
            return stringBuilder.toString();
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        //处理头节点,所有头节点的下一节点也与val相等时循环处理
        while (head != null && head.val == val) {
            //若头节点与val相等,删除头节点
            ListNode delNode = head;
            //头节点改为将要删除的头节点的下一节点
            head = head.next;
            //删除节点的下一节点设为null
            delNode.next = null;
            //上面过程可直接写为head = head.next;
            //head = head.next;
        }
        if (head == null) {
            return null;
        }
        //待删除的前一个节点.prev是头节点,一定不是待删除的节点,
        //前面已经对头节点做过处理,走到这一步说明头节点的val一定与val不相等
        ListNode prev = head;
        //循环头节点的下一个节点之后所有节点,判断是否删除,逻辑与头节点的删除逻辑相同
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                //上面三行可直接写为
                //prev.next = prev.next.next;
            } else {
                //不需要删除直接将prev直接后挪一个节点
                prev = prev.next;
            }
        }
        return head;
    }


    public static ListNode removeElements1(ListNode head, int val) {
        //创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        //虚拟头节点得下一节点指向真实头节点
        dummyHead.next = head;
        //从第一个元素之前得节点开始,不需要处理头节点
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println("不使用虚拟头节点: " + LinkSolution.removeElements(head,6));
        System.out.println("使用虚拟头节点: " + LinkSolution.removeElements1(head,6));
    }

}
