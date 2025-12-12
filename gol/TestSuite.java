package gol;

public class TestSuite {
    public static void main(String[] args) {
        System.out.println("Running TestSuite...");
        boolean pass = true;

        GameOfLife board = new GameOfLife(5,5);

        int[][] data = {{1}};
        board.set(2,2,data);
        pass &= expect(board.countNeighbors(2,2), 0, "Single cell has 0 neighbors");

        board.set(1,2,data);
        pass &= expect(board.countNeighbors(2,2), 1, "Add top neighbor");

        board.set(3,2,data);
        pass &= expect(board.countNeighbors(2,2), 2, "Add bottom neighbor");

        board.step();
        board.print();
        pass &= expect(board.get(2,3), 1, "Line should rotate");

        board.step();
        board.print();
        pass &= expect(board.get(1,2), 1, "Line should rotate again");

        System.out.println(pass ? "--- ALL TESTS PASSED ---" : "--- SOME TESTS FAILED ---");
    }

    private static boolean expect(int input, int expected, String comment) {
        if(input != expected)
            System.out.println(comment + " → expected: "+expected+", got: "+input);
        return input == expected;
    }
}
