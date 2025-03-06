package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-05 21:09
 * @File : Solution28.java
 * @Description : 146. LRU 缓存
 总体思路1：双向链表+map
 总体思路2：LinkedHashMap（自带双向链表）
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution28 {
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToNode.put(key,node);
        pushFront(node); // 放在最上面
        if (keyToNode.size()>capacity){
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }
    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) return null;
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }
//    ---------------------------------------------------------
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); // 自带双向链表
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer value = cache.remove(key);
        if (value!=null){
            cache.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.remove(key)!=null){
            cache.put(key,value);
            return;
        }
        if (cache.size()==capacity){
            Integer olderKey = cache.keySet().iterator().next();
            cache.remove(olderKey);
        }
        cache.put(key,value);

    }


}
