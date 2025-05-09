package me.jiapan.leetcode._146._20250509;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class LRUCache {
        class DLinkedNode {
            private int key;
            private int value;
            private DLinkedNode pre;
            private DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLinkedNode> cache;
        private int size;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = this.cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = this.cache.get(key);
            if (node == null) {
                node = new DLinkedNode(key, value);
                this.size++;
                if (this.size > this.capacity) {
                    DLinkedNode removedNode = deleteTail();
                    cache.remove(removedNode.key);
                    this.size--;
                }
                cache.put(key, node);
                insertHead(node);
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void insertHead(DLinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private DLinkedNode deleteTail() {
            DLinkedNode tailNode = tail.pre;
            deleteNode(tailNode);
            return tailNode;
        }

        private void moveToHead(DLinkedNode node) {
            deleteNode(node);
            insertHead(node);
        }

        private void deleteNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

}
