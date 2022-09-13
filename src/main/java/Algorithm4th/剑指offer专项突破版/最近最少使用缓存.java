package Algorithm4th.剑指offer专项突破版;

import java.util.HashMap;
import java.util.Map;

public class 最近最少使用缓存 {
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
        ListNode(int k, int v) {
            key = k;
            value = v;
        }
    }
    class LRUCache{
        ListNode head;
        ListNode tail;
        Map<Integer, ListNode> map;
        int capacity;
        LRUCache(int cap) {
            map = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            capacity = cap;
        }

        //get方法
        int get(int key) {
            ListNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToTail(node, node.value);
            return node.value;
        }
        //put方法
        void put(int key, int value) {
            if (map.containsKey(key)) {
                moveToTail(map.get(key), value);
            } else {
                if (map.size()== capacity) {
                    ListNode toBeDeleted = head.next;
                    deleteNode(toBeDeleted);
                    map.remove(toBeDeleted.key);
                }
                ListNode node = new ListNode(key, value);
                insertToTail(node);
                map.put(key, node);
            }
        }


        private void moveToTail(ListNode node, int newValue) {
            deleteNode(node);
            node.value = newValue;
            insertToTail(node);
        }
        private void deleteNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void insertToTail(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }

    }
}
