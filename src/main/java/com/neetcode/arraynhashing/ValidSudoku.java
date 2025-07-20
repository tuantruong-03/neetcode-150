package com.neetcode.arraynhashing;


import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {

    }
    // Solution 1 (my self)
    record Coordinate(int x, int y) {}
//    public boolean isValidSudoku(char[][] board) {
//        Map<Character, List<Coordinate>> coordinateMap = new HashMap<>();
//        for (int row = 0; row < board.length; ++row) {
//            for (int col = 0; col < board[row].length; ++col) {
//                char c = board[row][col];
//                if (c == '.') continue;
//                Coordinate current = new Coordinate(row, col);
//                if (!coordinateMap.containsKey(c)) {
//                    List<Coordinate> coordinates = new ArrayList<>();
//                    coordinates.add(current);
//                    coordinateMap.put(c, coordinates);
//                    continue;
//                }
//                List<Coordinate> coordinates = coordinateMap.get(c);
//                for (Coordinate coordinate : coordinates) {
//                    if (!isValidDigit(current, coordinate)) return false;
//                }
//                coordinates.add(current);
//                coordinateMap.put(c, coordinates);
//            }
//        }
//        return true;
//    }

    // Two coordinate of the same number
    private boolean isValidDigit(Coordinate c1, Coordinate c2) {
        if (c1.x == c2.x) return  false;
        if (c1.y == c2.y) return  false;
        int distanceX = Math.abs(c1.x - c2.x);
        int distanceY = Math.abs(c1.y - c2.y);
        // Check if they are the same block
        if ((c1.x / 3 == c2.x / 3) && (c1.y / 3 == c2.y / 3) && distanceX <= 2 && distanceY <= 2) {
            return false;
        }
        return true;
    }

    // Solution 2

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[board.length];
        HashSet<Character>[] cols = new HashSet[board.length];
        HashSet<Character>[] boxes = new HashSet[board.length];

        for (int i = 0; i < board.length; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int boxIndex = 3*(r/3) + c/3;
                if (rows[r].contains(ch) || cols[c].contains(ch) || boxes[boxIndex].contains(ch)) {
                    return false;
                }

                rows[r].add(ch);
                cols[c].add(ch);
                boxes[boxIndex].add(ch);
            }
        }
        return true;
    }
}
