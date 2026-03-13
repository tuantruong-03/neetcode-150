package com.neetcode.graphs;

import java.util.Arrays;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] cloneGrid = new int[grid.length][];

        for (int i = 0; i < grid.length; ++i) {
            cloneGrid[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        for (int row = 0; row < cloneGrid.length; ++row) {
            for (int col = 0; col < cloneGrid[row].length; ++col) {
                if (cloneGrid[row][col] != 1) continue;
                max = Math.max(max, area(row, col, grid));
            }
        }
        return max;
    }

    private int area(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        area += area(row, col - 1, grid);
        area += area(row - 1, col, grid);
        area += area(row, col + 1, grid);
        area += area(row + 1, col, grid);
        return area;
    }
}
