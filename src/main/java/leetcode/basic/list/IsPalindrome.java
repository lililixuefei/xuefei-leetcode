package leetcode.basic.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 回文链表
 * @author: xuefei
 * @date: 2023/02/23 22:34
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(3 / 2);
        System.out.println(4 / 2);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}