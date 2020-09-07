package search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目 难！！！
 */
public class leet51N皇后 {
        private List<List<String>> solutions = new ArrayList<>();
        private char[][] nQueens;
        private boolean[] colUsed;
        private boolean[] diagonals45Used;
        private boolean[] diagonals135Used;
        private int n;
        public List<List<String>> solveNQueues(int n){
            nQueens = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(nQueens[i], '.');
            }
            colUsed = new boolean[n];
            diagonals45Used = new boolean[2 * n - 1];
            diagonals135Used = new boolean[2 * n - 1];
            this.n = n;
            backtracking(0);
            return solutions;
        }
        private void backtracking(int row) {
            if (row == n) {
                List<String> list = new ArrayList<>();
                for (char[] chars : nQueens) {
                    list.add(new String(chars));
                }
                solutions.add(list);
                return;
            }

            for (int col = 0; col < n; col++) {
                int diagonals45Idx = row + col;
                int diagonals135Idx = n - 1 - (row - col);
                if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
                    continue;
                }
                nQueens[row][col] = 'Q';
                colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
                backtracking(row + 1);
                colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
                nQueens[row][col] = '.';
            }
        }
}
