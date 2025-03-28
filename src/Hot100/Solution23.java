package Hot100;/*
 * @Author : Vagrant
 * @Time: 2025-03-03 14:44
 * @File : Solution23.java
 * @Description : 208. 实现 Trie (前缀树)
 总体思路：
 前缀数：以链表组成，树的深度和宽度最多为26个字母
 类：26个数组，最后一个节点的存在情况
 insert：遍历插入值，若字母不在树中，则创建，且最后一个元素标记为true
 search：遍历插入值，若字母都在树中，且最后一个元素标记为true，则返回true
 startWith：遍历插入值，若字母都在树中，则返回true
 */


public class Solution23 {

    public Solution23() {
        root = new Node();

    }

    static class Node {
        Node[] son = new Node[26];
        boolean end;

    }

    private Node root;

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 1;

    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                return 0;
            }
            cur = cur.son[c];
        }
        return cur.end ? 1 : 2;
    }
}
