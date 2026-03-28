package com.neetcode.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
//        public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        List<List<Integer>> result = new ArrayList<>();
//        int rowCount = heights.length;
//        int colCount = heights[0].length;
//        for (int r = 0; r < heights.length; ++r) {
//            for (int c = 0; c < heights[0].length; ++c) {
//                boolean [][] visited = new boolean[rowCount][colCount];
//                int h = heights[r][c];
//                if (!canReachPacific(h, r, c, heights, visited)) continue;
//                visited = new boolean[rowCount][colCount];
//                if (canReachAtlantic(h, r, c, heights, visited)) {
//                    result.add(List.of(r,c));
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean canReachPacific(int currentHeight, int row, int col, int[][] heights, boolean[][] visited) {
//        if (row == -1 || col == -1) return true;
//        int rowCount = heights.length;
//        int colCount = heights[0].length;
//        if (row == rowCount || col == colCount) return false;
//        if (visited[row][col]) return false;
//        int neighborHeight = heights[row][col];
//        if (neighborHeight > currentHeight) return false;
//        currentHeight = neighborHeight;
//        visited[row][col] = true;
//        return canReachPacific(currentHeight, row, col - 1, heights, visited)
//                || canReachPacific(currentHeight, row - 1, col, heights, visited)
//                ||  canReachPacific(currentHeight, row, col + 1, heights, visited)
//                || canReachPacific(currentHeight, row + 1, col, heights, visited);
//    }
//
//    private boolean canReachAtlantic(int currentHeight, int row, int col, int[][] heights, boolean[][] visited) {
//        int rowCount = heights.length;
//        int colCount = heights[0].length;
//        if (row == rowCount || col == colCount) return true;
//        if (row == -1 || col == -1) return false;
//        if (visited[row][col]) return false;
//        int neighborHeight = heights[row][col];
//        if (neighborHeight > currentHeight) return false;
//        currentHeight = neighborHeight;
//        visited[row][col] = true;
//        return canReachAtlantic(currentHeight, row, col - 1, heights, visited)
//                || canReachAtlantic(currentHeight, row - 1, col, heights, visited)
//                ||  canReachAtlantic(currentHeight, row, col + 1, heights, visited)
//                || canReachAtlantic(currentHeight, row + 1, col, heights, visited);
//    }
//    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rowCount = heights.length;
        int colCount = heights[0].length;
        boolean[][] canReachPacificCells = new boolean[rowCount][colCount];
        boolean[][] canReachAtlanticCells = new boolean[rowCount][colCount];
        for (int r = 0; r < rowCount; ++r) {
            int height = heights[r][0];
            exploreCanReachOceanCells(r, 0, height, heights, canReachPacificCells);

            height = heights[r][colCount -1];
            exploreCanReachOceanCells(r, colCount -1, height, heights, canReachAtlanticCells);

        }
        for (int c = 0; c < colCount; ++c) {
            int height = heights[0][c];
            exploreCanReachOceanCells(0, c, height, heights, canReachPacificCells);

            height = heights[rowCount -1][c];
            exploreCanReachOceanCells(rowCount - 1, c, height, heights, canReachAtlanticCells);
        }


        for (int r = 0; r < rowCount; ++r) {
            for (int c = 0; c < colCount; ++c) {
                if (canReachPacificCells[r][c] && canReachAtlanticCells[r][c]) {
                    result.add(List.of(r,c));
                }
            }
        }
        return result;
    }

    private void exploreCanReachOceanCells(int row, int col, int currentHeight, int [][]heights, boolean[][] canReachOceanCells) {
        int rowCount = heights.length;
        int colCount = heights[0].length;
        if (row == -1 || col == -1 || row == rowCount || col == colCount) return;
        if (canReachOceanCells[row][col]) return;
        int neighborHeight = heights[row][col];
        if (neighborHeight < currentHeight) {
            return;
        }
        currentHeight = neighborHeight;
        canReachOceanCells[row][col] = true;
        exploreCanReachOceanCells(row, col - 1, currentHeight, heights, canReachOceanCells);
        exploreCanReachOceanCells(row -1, col, currentHeight, heights, canReachOceanCells);
        exploreCanReachOceanCells(row, col + 1, currentHeight, heights, canReachOceanCells);
        exploreCanReachOceanCells(row + 1, col, currentHeight, heights, canReachOceanCells);
    }
}
