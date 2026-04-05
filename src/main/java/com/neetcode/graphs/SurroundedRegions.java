package com.neetcode.graphs;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;

        // Marks cells that should NOT be flipped to 'X'
        // These are 'O' cells connected to the border
        boolean[][] unableToFormRegionCells = new boolean[rowCount][colCount];

        // Explore all cells on the left and right borders
        for (int row = 0; row < rowCount; ++row) {
            exploreUnableToFormRegionCells(row, 0, unableToFormRegionCells, board);
            exploreUnableToFormRegionCells(row, colCount - 1, unableToFormRegionCells, board);
        }

        // Explore all cells on the top and bottom borders
        for (int col = 0; col < colCount; ++col) {
            exploreUnableToFormRegionCells(0, col, unableToFormRegionCells, board);
            exploreUnableToFormRegionCells(rowCount - 1, col, unableToFormRegionCells, board);
        }

        // Any 'O' not connected to the border is surrounded
        // and should be flipped to 'X'
        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                if (board[row][col] == 'O' && !unableToFormRegionCells[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void exploreUnableToFormRegionCells(
            int row,
            int col,
            boolean[][] unableToFormRegionCells,
            char[][] board
    ) {
        int rowCount = board.length;
        int colCount = board[0].length;

        // Stop if out of bounds
        if (row == -1 || col == -1 || row == rowCount || col == colCount) return;

        // Stop if current cell is not part of a region
        if (board[row][col] == 'X') return;

        // Stop if this cell was already visited
        if (unableToFormRegionCells[row][col]) return;

        // Mark current border-connected 'O' as safe
        unableToFormRegionCells[row][col] = true;

        // DFS in 4 directions
        exploreUnableToFormRegionCells(row, col - 1, unableToFormRegionCells, board);
        exploreUnableToFormRegionCells(row - 1, col, unableToFormRegionCells, board);
        exploreUnableToFormRegionCells(row, col + 1, unableToFormRegionCells, board);
        exploreUnableToFormRegionCells(row + 1, col, unableToFormRegionCells, board);
    }
}
