package me.jiapan.leetcode._61._20240830;


class ListNode {
    int val;
    me.jiapan.leetcode._61._20240830.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, me.jiapan.leetcode._61._20240830.ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            n++;
            iter = iter.next;
        }
        if (k % n == 0) {
            return head;
        }
        int add = n - k % n;
        iter.next = head;
        while (add > 0) {
            iter = iter.next;
            add--;
        }
        ListNode newHead = iter.next;
        iter.next = null;
        return newHead;
    }
}
