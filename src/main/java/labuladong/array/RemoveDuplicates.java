package labuladong.array;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/7 10:41 AM
 * @Version 1.0
 */
public class RemoveDuplicates {

	int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				slow++;
				// 维护 nums[0..slow] 无重复
				nums[slow] = nums[fast];
			}
			fast++;
		}
		// 数组长度为索引 + 1
		return slow + 1;
	}

	ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast != null) {
			if (fast.val != slow.val) {
				// nums[slow] = nums[fast];
				slow.next = fast;
				// slow++;
				slow = slow.next;
			}
			// fast++
			fast = fast.next;
		}
		// 断开与后面重复元素的连接
		slow.next = null;
		return head;
	}

}
