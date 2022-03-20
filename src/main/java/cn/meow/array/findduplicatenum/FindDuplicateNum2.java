package cn.meow.array.findduplicatenum;

public class FindDuplicateNum2 {

    /**
     * 双指针
     * 环形链表
     * 1.慢指针走一步, 快指针走两步
     * 2.第一次相遇时, 快指针到0的位置, 之后每次走一步
     * 3.第二次相遇时, 就是重复的数
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
