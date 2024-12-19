package me.jiapan.leetcode._460._20241219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
}

class LFUCache {
    int minFreq, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, List<Node>> freqTable;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyTable = new HashMap<>();
        this.freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        Node node = keyTable.get(key);
        if (node == null) {
            return -1;
        }
        freqTable.get(node.freq).remove(node);
        if (freqTable.get(node.freq).isEmpty()) {
            freqTable.remove(node.freq);
            if (minFreq == node.freq) {
                minFreq++;
            }
        }
        node.freq += 1;
        freqTable.computeIfAbsent(node.freq, k -> new ArrayList<>()).add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = keyTable.get(key);
        if (node == null) {
            if (keyTable.size() >= capacity) {
                Node deadNode = freqTable.get(minFreq).get(0);
                keyTable.remove(deadNode.key);
                freqTable.get(minFreq).remove(deadNode);
                if (freqTable.get(minFreq).isEmpty()) {
                    freqTable.remove(minFreq);
                }
            }
            node = new Node(key, value, 1);
            keyTable.put(key, node);
            freqTable.computeIfAbsent(1, k -> new ArrayList<>()).add(node);
            minFreq = 1;
        } else {
            freqTable.get(node.freq).remove(node);
            if (freqTable.get(node.freq).isEmpty()) {
                freqTable.remove(node.freq);
                if (minFreq == node.freq) {
                    minFreq++;
                }
            }
            node.freq += 1;
            node.value = value;
            freqTable.computeIfAbsent(node.freq, k -> new ArrayList<>()).add(node);
        }
    }
}


class Node {
    int key;
    int value;
    int freq;

    public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}