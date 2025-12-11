package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    // Current and next generation boards
    private int[][] board;
    private int[][] nextBoard;

    // Constructor: creates an empty board of given dimensions
    public GameOfLife(int height, int width) {
        this.board = new int[height][width];
        this.nextBoard = new int[height][width];
        // All cells are dead (0) by default
    }

    // Set a pattern at position (x, y)
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (i + x < board.length && j + y < board[0].length) {
                    board[i + x][j + y] = data[i][j];
                }
            }
        }
    }

    @Override
    public void run(int turns) {
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    @Override
    public void step() {
        int height = board.length;
        int width = board[0].length;

        // Compute next generation
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int neighbors = countNeighbors(x, y);
                int cell = board[x][y];

                if (cell == 1) {
                    // Live cell
                    if (neighbors == 2 || neighbors == 3) {
                        nextBoard[x][y] = 1;  // survives
                    } else {
                        nextBoard[x][y] = 0;  // dies
                    }
                } else {
                    // Dead cell
                    if (neighbors == 3) {
                        nextBoard[x][y] = 1;  // birth
                    } else {
                        nextBoard[x][y] = 0;  // stays dead
                    }
                }
            }
        }

        // Swap boards (fast reference swap)
        int[][] temp = board;
        board = nextBoard;
        nextBoard = temp;

        // Optional: print every step (useful for demo)
        print();
    }

    @Override
    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // skip center cell

                int nx = x + dx;
                int ny = y + dy;

                // Use wrap-around via get()
                count += get(nx, ny);
            }
        }
        return count;
    }

    @Override
    public int get(int x, int y) {
        int height = board.length;
        int width = board[0].length;
        int wrappedX = (x + height) % height;
        int wrappedY = (y + width) % width;
        return board[wrappedX][wrappedY];
    }

    // Returns a reference to current board (for testing)
    @Override
    public int[][] get() {
        return board;
    }

    // Pretty-print the board with coordinates
    public void print() {
        int height = board.length;
        int width = board[0].length;

        // Top header
        System.out.print("\n  ");
        for (int y = 0; y < width; y++) {
            System.out.print(y % 10 + " ");
        }
        System.out.println();

        for (int x = 0; x < height; x++) {
            System.out.print(x % 10 + " ");
            for (int y = 0; y < width; y++) {
                System.out.print(board[x][y] == 1 ? "Black Square" : "White Square");
            }
            System.out.println();
        }
        System.out.println();
    }
}