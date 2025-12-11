package gol;

public class BoardImpl implements Board {

    private int[][] grid;
    private int[][] nextGrid;
    private final int width;
    private final int height;

    /**
     * Constructs a board with the given initial configuration.
     * 1 = alive, 0 = dead
     */
    public BoardImpl(int[][] initial) {
        this.height = initial.length;
        this.width = initial[0].length;

        this.grid = new int[height][width];
        this.nextGrid = new int[height][width];

        // Deep copy initial state
        for (int y = 0; y < height; y++) {
            System.arraycopy(initial[y], 0, grid[y], 0, width);
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
        // Compute next generation into nextGrid
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int neighbors = countNeighbors(x, y);
                int current = grid[y][x];

                if (current == 1) {
                    if (neighbors == 2 || neighbors == 3) {
                        nextGrid[y][x] = 1;  // survives
                    } else {
                        nextGrid[y][x] = 0;  // dies
                    }
                } else { // dead
                    if (neighbors == 3) {
                        nextGrid[y][x] = 1;  // birth
                    } else {
                        nextGrid[y][x] = 0;  // stays dead
                    }
                }
            }
        }

        // Swap grids
        int[][] temp = grid;
        grid = nextGrid;
        nextGrid = temp;
    }

    @Override
    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) continue; // skip self

                int nx = (x + dx + width) % width;   // toroidal wrap
                int ny = (y + dy + height) % height;

                count += grid[ny][nx];
            }
        }
        return count;
    }

    @Override
    public int get(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Coordinates out of bounds");
        }
        return grid[y][x];
    }

    /**
     * Returns a COPY of the current grid (for testing/display).
     * This prevents external code from mutating our internal state.
     */
    @Override
    public int[][] get() {
        int[][] copy = new int[height][width];
        for (int y = 0; y < height; y++) {
            System.arraycopy(grid[y], 0, copy[y], 0, width);
        }
        return copy;
    }

    // Optional convenience methods
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}