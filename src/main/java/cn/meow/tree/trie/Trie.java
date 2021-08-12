package cn.meow.tree.trie;

import cn.meow.tree.been.TreeNode;

public class Trie {

    private class Node {
        //孩子结点, 26个字母
        Node[] childs = new Node[26];
        //是否串的结束
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {
        insert(word, root);
    }

    /**
     * 递归插入
     */
    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(word.substring(1), node.childs[index]);
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index]);
    }

    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }

    /**
     * 查找索引值
     * 即当前字母放在new Node[26]的什么位置
     */
    private int indexForChar(char c) {
        return c - 'a';
    }
}

