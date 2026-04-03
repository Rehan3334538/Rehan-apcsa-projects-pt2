package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solve(model.height(), 'A', 'C', 'B');
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    public void solve(int n, char from, char to, char aux)
    {
        if (n == 1) {
            model.move(getIndex(from), getIndex(to));
        } else {
            solve(n - 1, from, aux, to);
            model.move(getIndex(from), getIndex(to));
            solve(n - 1, aux, to, from);
        }
    }

    private int getIndex(char rod) {
        return rod - 'A';
    }

}