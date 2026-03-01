package com.neetcode.backtracking;


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rowCount = board.length;
        int colCount = board[0].length;
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < colCount; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, word, 0, new boolean[rowCount][colCount], board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int wordIndex, boolean[][] visited, char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;
        if (wordIndex == word.length()) return true;
        if (board[row][col] != word.charAt(wordIndex)) return false;
        // Match word
        visited[row][col] = true;
        if (wordIndex == word.length() - 1) return true;
        // Left
        if (col - 1 >= 0 && !visited[row][col-1] &&
            backtrack(row, col - 1, word, wordIndex + 1, visited, board)) {
            return true;
        }
        // Up
        if (row - 1 >= 0 && !visited[row-1][col] &&
                backtrack(row - 1, col, word, wordIndex + 1, visited, board)) {
            return true;
        }
        // Right
        if (col + 1 < colCount && !visited[row][col+1] &&
                backtrack(row, col + 1, word, wordIndex + 1, visited, board)) {
            return true;
        }
        // Down
        if (row + 1 < rowCount && !visited[row+1][col] &&
                backtrack(row + 1, col, word, wordIndex + 1, visited, board)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }


    public static void main(String[] args) {

        char[][] board = {
                {'A','A'},
        };

        String word = "AA";

        // Assume you already implemented this class
        WordSearch solution = new WordSearch();

        boolean result = solution.exist(board, word);

        System.out.println("Result: " + result);
    }
}
