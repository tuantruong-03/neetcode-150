package com.neetcode.arraynhashing;


import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            String sorted = sort(str);
            List<String> group = anagramGroups.getOrDefault(sorted, new ArrayList<>());
            group.add(str);
            anagramGroups.put(sorted, group);
        }
        for (Map.Entry<String, List<String>> entry : anagramGroups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
