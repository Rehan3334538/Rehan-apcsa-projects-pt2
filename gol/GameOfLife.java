package gol;

class GameOfLife implements Board {

    private int[][] board;
    private int[][] nextBoard;

    // Constructor: create board of given size
    public GameOfLife(int height, int width) {
        this.board = new int[height][width];
        this.nextBoard = new int[height][width];
    }

    // Set a pattern starting at (x, y)
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

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int neighbors = countNeighbors(x, y);
                int cell = board[x][y];

                if (cell == 1) {
                    nextBoard[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    nextBoard[x][y] = (neighbors == 3) ? 1 : 0;
                }
            }
        }

        // Swap boards
        int[][] temp = board;
        board = nextBoard;
        nextBoard = temp;
    }

    @Override
    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                count += get(x + dx, y + dy);
            }
        }
        return count;
    }

    @Override
    public int get(int x, int y) {
        int height = board.length;
        int width = board[0].length;
        int wrappedX = ((x % height) + height) % height; // wrap around edges
        int wrappedY = ((y % width) + width) % width;
        return board[wrappedX][wrappedY];
    }

    @Override
    public int[][] get() {
        return board;
    }

    // Optional: print board for debugging
    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] == 1 ? "█ " : "· ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
