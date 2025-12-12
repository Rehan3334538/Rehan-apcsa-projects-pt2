package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dead
    private int[][] board;

    public GameOfLife(int x, int y)
    {
        // Construct a 2d array of the given x and y size.
        board = new int[x][y];
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                board[x + r][y + c] = data[r][c];
            }
        }
    }

    // Run the simulation for a number of turns
    public void run(int turns) {
        // call step the number of times requested
        int count = 0;
        while (count < turns) {
            step();
            count++;
        }
    }

    // Step the simulation forward one turn.
    public void step()
    {
        print();
        int rows = board.length;
        int cols = board[0].length;

        int[][] newBoard = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                int alive = get(r, c);
                int n = countNeighbors(r, c);

                if (alive == 1) {
                    newBoard[r][c] = (n == 2 || n == 3) ? 1 : 0;
                } else {
                    newBoard[r][c] = (n == 3) ? 1 : 0;
                }
            }
        }

        board = newBoard;
        // Update the game board, store a 1 if the cell is alive and a 0 otherwise.
    }


    public int countNeighbors(int x, int y) {
        int count = 0;

        // count the number of neighbors the cell has
        // use the get(x,y) method to read any board state you need.
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                int nx = x + dx;
                int ny = y + dy;

                count += get(nx, ny);
            }
        }

        return count;
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int rows = board.length;
        int cols = board[0].length;

        int wrappedX = (x % rows + rows) % rows;
        int wrappedY = (y % cols + cols) % cols;

        return board[wrappedX][wrappedY];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print((y % 10) + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + (x % 10));
            for (int y = 0; y < board[x].length; y++)
            {
                System.out.print(board[x][y] == 1 ? "⬛" : "⬜");
            }
        }
        System.out.println();
    }
}
