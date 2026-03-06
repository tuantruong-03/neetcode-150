package com.neetcode.trie;

import java.util.HashMap;
import java.util.Map;

// Use Map for unknown large charset
public class Trie {
    Node root;
    public Trie() {
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
        // Loop way
//        Node curr = root;
//        for (char letter : word.toCharArray()) {
//            if (!curr.children.containsKey(letter)) {
//                return false;
//            }
//            curr = curr.children.get(letter);
//        }
//        // In trie, containing "apple" word does not mean that it contains "app"
//        return curr.isEndOfWord;

        // Backtrack way
        return backtrackSearch(word, root, 0);
    }

    private boolean backtrackSearch(String word, Node curr, int index) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }
        char letter = word.charAt(index);
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

//public class Trie {
//    Node root;
//    public Trie() {
//        root = new Node();
//    }
//
//    public void insert(String word) {
//        Node curr = root;
//        for (char letter : word.toCharArray()) {
//            if (curr.children[letter - 'a'] == null) {
//                curr.children[letter - 'a'] = new Node();
//            }
//            curr = curr.children[letter - 'a'];
//        }
//        curr.isEndOfWord = true;
//    }
//
//    public boolean search(String word) {
//        Node curr = root;
//        for (char letter : word.toCharArray()) {
//            if (curr.children[letter - 'a'] == null) {
//                return false;
//            }
//            curr = curr.children[letter - 'a'];
//        }
//        // In trie, containing "apple" word does not mean that it contains "app"
//        return curr.isEndOfWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        Node curr = root;
//        for (char letter : prefix.toCharArray()) {
//            if (curr.children[letter - 'a'] == null) {
//                return false;
//            }
//            curr = curr.children[letter - 'a'];
//        }
//        return true;
//    }
//
//    private static class Node {
//        Node[] children;
//        boolean isEndOfWord;
//
//        Node() {
//            children = new Node[26]; // children[0] = 'a'
//            isEndOfWord = false;
//        }
//    }
//}

