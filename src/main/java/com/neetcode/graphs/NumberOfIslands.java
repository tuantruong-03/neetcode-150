package com.neetcode.graphs;

import java.util.*;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        char[][] cloneGrid = new char[grid.length][];

        for (int i = 0; i < grid.length; ++i) {
            cloneGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        for (int row = 0; row < cloneGrid.length; ++row) {
            for (int col = 0; col < cloneGrid[row].length; ++col) {
                if (cloneGrid[row][col] != '1') continue;
                count++;
                discoverNewIsland(row, col, cloneGrid);
            }
        }
        return count;
    }

    private void discoverNewIsland(int row, int col, char[][]grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        discoverNewIsland(row , col -1, grid);
        discoverNewIsland(row -1, col, grid);
        discoverNewIsland(row, col + 1, grid);
        discoverNewIsland(row + 1, col, grid);
    }
}


//public class NumberOfIslands {
//    public int numIslands(char[][] grid) {
//        int count = 0;
//
//        // Track visited land cells to avoid revisiting
//        Set<Coordinate> visited = new HashSet<>();
//
//        // Traverse every cell in the grid
//        for (int row = 0; row < grid.length; ++row) {
//            for (int col = 0; col < grid[row].length; ++col) {
//
//                // Skip water cells
//                if (grid[row][col] != '1') continue;
//
//                Coordinate coordinate = new Coordinate(row, col);
//
//                if (formNewIsland(coordinate, visited, grid)) ++count;
//            }
//        }
//
//        return count;
//    }
//
//    // Perform BFS to explore all connected land cells of one island
//    public boolean formNewIsland(Coordinate visit, Set<Coordinate> visited, char[][] grid) {
//        // If this cell was already visited, it belongs to an existing island
//        if (visited.contains(visit)) return false;
//
//        // BFS queue
//        Queue<Coordinate> queue = new LinkedList<>();
//
//        visited.add(visit);
//        queue.add(visit);
//        int rowCount = grid.length;
//        int colCount = grid[0].length;
//        while (!queue.isEmpty()) {
//            Coordinate coordinate = queue.poll();
//
//            int row = coordinate.row;
//            int col = coordinate.col;
//
//            // Explore four neighbors (Left, Up, Right, Down)
//
//            // Left
//            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
//                visitNeighbor(row, col -1, queue, visited);
//            }
//
//            // Up
//            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
//                visitNeighbor(row - 1, col, queue, visited);
//            }
//
//            // Right
//            if (col + 1 < colCount && grid[row][col + 1] == '1') {
//                visitNeighbor(row , col + 1, queue, visited);
//            }
//
//            // Down
//            if (row + 1 < rowCount && grid[row + 1][col] == '1') {
//                visitNeighbor(row + 1, col, queue, visited);
//            }
//        }
//        return true;
//    }
//
//
//    private void visitNeighbor(int row, int col, Queue<Coordinate> queue, Set<Coordinate> visited) {
//        Coordinate downNeighbor = new Coordinate(row , col);
//        if (!visited.contains(downNeighbor)) {
//            visited.add(downNeighbor);
//            queue.add(downNeighbor);
//        }
//    }
//
//
//    class Coordinate {
//        int row;
//        int col;
//
//        Coordinate(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof Coordinate)) return false;
//            Coordinate c = (Coordinate) o;
//            return row == c.row && col == c.col;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(row, col);
//        }
//    }
//}
//
