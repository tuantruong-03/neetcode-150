package com.neetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    private final Map<Integer, LRUCacheNode> map;
    private final int capacity;
    private final LRUCacheNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new LRUCacheNode(0, 0);
        tail = new LRUCacheNode(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        LRUCacheNode node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToTail(node);
        } else {
            if (map.size() == capacity) {
                LRUCacheNode lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            LRUCacheNode newNode = new LRUCacheNode(key,value);
            addToTail(newNode);
            map.put(key, newNode);
        }
    }

    private void moveToTail(LRUCacheNode node) {
        remove(node);
        addToTail(node);
    }

    private void addToTail(LRUCacheNode node) {
        node.previous = tail.previous;
        node.next = tail;
        tail.previous.next = node;
        tail.previous = node;
    }

    private void remove(LRUCacheNode node) {
        if (node == head || node == tail) {
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}

class LRUCachePractice {
    private int capacity;
    private Map<Integer, LRUCacheNode> map;

    // Dummy/sentinel nodes:
    // - Do not store actual cache data
    // - Used to simplify insertion/removal logic
    // - Avoid null checking for head/tail operations
    // head.next     -> Least Recently Used (LRU)
    // tail.previous -> Most Recently Used (MRU)
    private LRUCacheNode head, tail;

    public LRUCachePractice(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LRUCacheNode(0,0);
        tail = new LRUCacheNode(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        LRUCacheNode node = map.get(key);

        if (node != null) {
            node.val = value;
            moveToTail(node);
            return;
        }

        node = new LRUCacheNode(key, value);

        // Cache is full:
        // Remove the least recently used node,
        // which is always right after head
        if (map.size() == capacity) {
            LRUCacheNode lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }

        addToTail(node);
        map.put(key, node);
    }

    private void moveToTail(LRUCacheNode node) {
        remove(node);
        addToTail(node);
    }

    private void addToTail(LRUCacheNode node) {
        node.next = tail;
        node.previous = tail.previous;

        LRUCacheNode previousTail = tail.previous;
        previousTail.next = node;
        tail.previous = node;
    }

    private void remove(LRUCacheNode node) {

        // Prevent removing dummy nodes
        if (node == head || node == tail) return;

        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

}

class LRUCacheNode {

    // Store key because when removing the LRU node,
    // we also need its key to remove it from the HashMap
    int key, val;

    LRUCacheNode next, previous;

    LRUCacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}