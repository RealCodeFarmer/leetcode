package cn.meow.tree.trie;

public class MapSumPairs {

    private class Node {
        //孩子结点, 26个字母
        Node[] childs = new Node[26];
        //是否串的结束
        int leafVal = -1;
        //放置累计值
        int val;
    }

    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs() {

    }

    public void insert(String key, int val) {
        //是否已經存在
        insert(key, root, search(key, root, val));
    }

    /**
     * 如果已经存在, 返回跟更新值之间的差值, 否则返回val原值
     */
    private int search(String word, Node node, int val) {
        if (node == null) {
            return val;
        }
        if (word.length() == 0) {
            return node.leafVal > 0 ? val - node.leafVal : val;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), node.childs[index], val);
    }

    /**
     * 递归插入
     */
    private void insert(String word, Node node, int val) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.leafVal = node.leafVal > 0 ? node.leafVal + val : val;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        node.childs[index].val += val;
        insert(word.substring(1), node.childs[index], val);
    }

    /**
     * 查找索引值
     * 即当前字母放在new Node[26]的什么位置
     */
    private int indexForChar(char c) {
        return c - 'a';
    }

    public int sum(String prefix) {
        return startWith(prefix, root);
    }

    private int startWith(String prefix, Node node) {
        if (node == null) {
            return 0;
        }
        if (prefix.length() == 0) {
            return node.val;
        }
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), node.childs[index]);
    }
}
