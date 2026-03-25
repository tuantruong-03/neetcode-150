package com.neetcode.graphs;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        while (true) {
            boolean canRot = false;

            // Tracks oranges that became rotten in the current minute
            // so they do NOT spread immediately in the same minute
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            for (int row = 0; row < grid.length; ++row) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (visited[row][col]) continue;
                    if (grid[row][col] == 2) {
                        if (canRotAdjacentOranges(row, col, grid, visited)) canRot = true;
                        visited[row][col] = true;
                    }
                }
            }

            // If no fresh orange was rotted in this round, stop
            if (!canRot) break;
            minute++;
        }


        // After simulation, if any fresh orange remains, answer is impossible
        for (int[] ints : grid) {
            for (int col = 0; col < grid[0].length; col++) {
                if (ints[col] == 1) return -1;
            }
        }
        return minute;
    }

    private boolean canRotAdjacentOranges(int row, int col, int [][]grid, boolean[][] visited) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        boolean can = false;
        // Left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col-1] = 2;
            visited[row][col-1] = true; // prevent spreading again this minute
            can = true;
        }
        // Top
        if (row - 1 >= 0 && grid[row-1][col] == 1) {
            grid[row-1][col] = 2;
            visited[row-1][col] = true;
            can = true;
        }
        // Right
        if (col + 1 < colCount && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            visited[row][col+1] = true;
            can = true;
        }
        // Bottom
        if (row + 1 < rowCount && grid[row+1][col] == 1) {
            grid[row+1][col] = 2;
            visited[row+1][col] = true;
            can = true;
        }
        return can;
    }
}