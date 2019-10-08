package sudoku.chan;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static sudoku.chan.SudokuConstants.NO_EMPTY_CELL_FOUND;

public class SudokuSolver {

    private final List<Grid> solutions = new ArrayList<>();

    public SudokuSolver(int[][] numbers) {
        solve(Grid.create(numbers), solutions);
    }

    public SudokuSolver() {

    }

    // Recursive routine that implements the bifurcation algorithm
    private static void solve(Grid grid, List<Grid> solutions) {
        // Return if there is already a solution
        if (enoughSolutionsFound(solutions)) {
            return;
        }

        // Find first empty cell
        int cellIndex = grid.findEmptyCell();

        // If no empty cells are found, a solution is found
        if (noEmptyCellFound(cellIndex)) {
            solutions.add(grid.clone());
            return;
        }

        // Try each of the 9 digits in this empty cell
        for (int n = 1; n < 10; n++) {
            if (grid.set(cellIndex, n)) {
                // With this cell set, work on the next cell
                solve(grid, solutions);

                // Clear the cell so that it can be filled with another digit
                grid.clear(cellIndex);
            }
        }
    }

    private static boolean noEmptyCellFound(int cellIndex) {
        return cellIndex == NO_EMPTY_CELL_FOUND;
    }

    private static boolean enoughSolutionsFound(List<Grid> solutions) {
        return solutions.size() >= 2;
    }

    public static void main(String[] args) throws Exception {
        new SudokuSolver().go(args[0]);
    }

    public boolean isSolveable() {
        return !solutions.isEmpty();
    }

    private void go(String s) throws Exception {
        FileReader rd = new FileReader(s);
        Grid grid = Grid.create(rd);
        // Find a solution
        ArrayList<Grid> solutions = new ArrayList<>();
        solve(grid, solutions);

        //Print the grid with the givens
        System.out.println("original");
        System.out.println(grid);
        // Print the solution
        int size = solutions.size();
        switch (size) {
            case 0:
                System.out.println("Unsolveable");
                break;
            case 1:
                System.out.println("solved");
                break;
            default:
                System.out.println("At least two solutions");
                break;
        }
        rd.close();  //refactor Xavier

    }


    public boolean isUniqueSolution() {
        return solutions.size() == 1;
    }

    public int[][] getSolution() {
        int[] cells = solutions.get(0).getCells();
        int k = 0;
        //solutions.stream()
        int[][] numbers = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i][j] = cells[k];
                k++;
            }
        }
        return numbers;
    }

// --Commented out by Inspection START (7/10/19 9:21):
//    public List<Grid> getSolutions() {
//        return solutions;
//    }
// --Commented out by Inspection STOP (7/10/19 9:21)

}