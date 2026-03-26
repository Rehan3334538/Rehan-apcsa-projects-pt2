package tower;

public class Main {

 public static void main(String[] args) {
    int nDisks = 3;
    // TowerModel acts as the state manager (stacks for rods)
    TowerModel model = new TowerModel(nDisks); 
    TowerSolver solver = new TowerSolver();
    
    // Solves by moving n disks from rod A to C using B
    solver.solve(nDisks, 'A', 'C', 'B'); 
}

        // testing game but understanding project

        // Run test suite
        TestSuite test = new TestSuite();
        test.run();

    }
}
