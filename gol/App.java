package gol;

public class GameOfLife {
    private int[][] board;
    private int rows;
    private int cols;

    // Constructor: Initializes the board with the given rows and cols
    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
    }

    // Set a pattern at position (x, y) on the board
    public void set(int x, int y, int[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                if (x + i < rows && y + j < cols) {
                    board[x + i][y + j] = pattern[i][j];
                }
            }
        }
    }

    // Run the game for 'steps' generations
    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            step();
            print();
        }
    }

    // Step forward by one generation (updates the game board)
    public void step() {
        int[][] nextBoard = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(i, j);
                if (board[i][j] == 1) { // Alive
                    if (neighbors < 2 || neighbors > 3) {
                        nextBoard[i][j] = 0; // Dies
                    } else {
                        nextBoard[i][j] = 1; // Stays alive
                    }
                } else { // Dead
                    if (neighbors == 3) {
                        nextBoard[i][j] = 1; // Becomes alive
                    }
                }
            }
        }

        // Copy the next generation into the current board
        board = nextBoard;
    }

    // Count the live neighbors of a specific cell at (x, y)
    private int countNeighbors(int x, int y) {
        int count = 0;
        // Check all 8 possible neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the cell itself
                int nx = (x + i + rows) % rows; // Wrap around the edges
                int ny = (y + j + cols) % cols; // Wrap around the edges
                count += board[nx][ny];
            }
        }
        return count;
    }

    // Print the board to the console
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] == 1 ? "O" : "."); // O = alive, . = dead
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GameOfLife g = new GameOfLife(7, 7);

        int[][] data = {
            { 0, 1, 0},
            { 0, 0, 1},
            { 1, 1, 1 }
        };

        g.set(1, 1, data);
        g.run(5); // Run for 5 generations
    }
}
