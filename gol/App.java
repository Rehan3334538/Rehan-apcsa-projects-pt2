package gol;

import cards.GameOfLife;

public class App {
    public static void main(String[] args) {
        GameOfLife g = new GameOfLife(7, 7);

        int[][] data = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1}
        };

        g.set(1, 1, data);

        g.run(5);

        // Print final state
        int[][] board = g.get();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] == 1 ? "█ " : "· ");
            }
            System.out.println();
        }
    }
}
