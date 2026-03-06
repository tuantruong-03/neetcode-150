package com.neetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {

}

class WordDictionary {
    PrefixTree prefixTree;

    public WordDictionary() {
        prefixTree = new PrefixTree();
    }

    public void addWord(String word) {
        prefixTree.insert(word);
    }

    public boolean search(String word) {
        return prefixTree.search(word);
    }
}

class PrefixTree { //  Trie
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char letter : word.toCharArray()) {
            if (!curr.children.containsKey(letter)) {
                curr.children.put(letter, new Node());
            }
            curr = curr.children.get(letter);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return backtrackSearch(word, root, 0);
    }

    private boolean backtrackSearch(String word, Node curr, int index) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }
        char letter = word.charAt(index);
        if (letter == '.') {
            for (Node child : curr.children.values()) {
                if (backtrackSearch(word, child, index +1)) {
                    return true;
                }
            }
            return false;
        }
        if (!curr.children.containsKey(letter)) {
            return false;
        }
        return backtrackSearch(word, curr.children.get(letter), index + 1);
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char letter : prefix.toCharArray()) {
            if (!curr.children.containsKey(letter)) {
                return false;
            }
            curr = curr.children.get(letter);
        }
        return true;
    }

    private static class Node {
        Map<Character, Node> children;
        boolean isEndOfWord;

        Node() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
}