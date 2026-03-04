package com.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    private final Map<Character, List<Character>> digitToLetters = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    // Stores all generated combinations
    private final List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        // Convert each digit into its corresponding letter list
        List<List<Character>> letterList = new ArrayList<>();
        for (Character digit : digits.toCharArray()) {
            letterList.add(digitToLetters.get(digit));
        }

        backtrack(0, new StringBuilder(), letterList);

        return result;
    }
    private void backtrack(int listIndex,
                           StringBuilder path,
                           List<List<Character>> letterList) {
        List<Character> letters = letterList.get(listIndex);

        for (int i = 0; i < letters.size(); ++i) {
            path.append(letters.get(i));
            // If this is the last digit, we completed one combination
            if (listIndex == letterList.size() - 1) {
                result.add(path.toString());
                path.deleteCharAt(path.length() - 1);
                continue;
            }

            // Explore next digit
            backtrack(listIndex + 1, path, letterList);
            path.deleteCharAt(path.length() - 1);
        }
    }
}