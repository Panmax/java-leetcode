package me.jiapan.leetcode._143._20241011;

import java.util.ArrayList;
import java.util.List;

class ListNode {
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
}

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> array = new ArrayList<>();
        while (head != null) {
            array.add(head);
            head = head.next;
        }
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            array.get(i).next = array.get(j);
            i++;
            if (i == j) {
                break;
            }
            array.get(j).next = array.get(i);
            j--;
        }
        array.get(i).next = null;
    }
}