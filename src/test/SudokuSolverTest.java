package test;

import sudoku.chan.SudokuSolver;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuSolverTest {
    private SudokuSolver sudokuSolver;

    private final int[][] testCells = {
            {0, 6, 7, 0, 0, 0, 0, 0, 1},
            {0, 8, 0, 9, 0, 0, 5, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 5, 0, 8, 0, 0, 6},
            {0, 1, 0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 4, 2, 0, 0},
            {6, 0, 0, 0, 9, 0, 8, 0, 0},
            {0, 0, 0, 3, 0, 7, 0, 6, 4},
            {4, 0, 3, 8, 0, 0, 0, 1, 0}};
    private final int[][] testResult = {
            {9, 6, 7, 2, 5, 3, 4, 8, 1},
            {1, 8, 2, 9, 4, 6, 5, 3, 7},
            {3, 4, 5, 7, 8, 1, 6, 2, 9},
            {7, 2, 9, 5, 3, 8, 1, 4, 6},
            {8, 1, 4, 6, 2, 9, 3, 7, 5},
            {5, 3, 6, 1, 7, 4, 2, 9, 8},
            {6, 7, 1, 4, 9, 2, 8, 5, 3},
            {2, 5, 8, 3, 1, 7, 9, 6, 4},
            {4, 9, 3, 8, 6, 5, 7, 1, 2}};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sudokuSolver = new SudokuSolver(this.testCells);
    }

    @org.junit.jupiter.api.Test
    void isSolveable() {
        assertTrue(sudokuSolver.isSolveable());
    }

    @org.junit.jupiter.api.Test
    void isUniqueSolution() {
        assertTrue(sudokuSolver.isUniqueSolution());
    }

    @org.junit.jupiter.api.Test
    void getSolutions() {
        int solution[][] = sudokuSolver.getSolution();
        assertTrue(Arrays.deepEquals(solution, testResult));
    }
}