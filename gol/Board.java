package gol;

// Interface defining GameOfLife contract
interface Board {
    void run(int turns);
    void step();
    int countNeighbors(int x, int y);
    int get(int x, int y);
    int[][] get();
}
