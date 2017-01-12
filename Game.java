import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int ROWS = 4;
    public static final int COLUMNS = 4;
    private int[][] gameBoard = new int[ROWS][COLUMNS];

    private class Pair<E> {

        private E first;
        private E second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        public E getFirst() {
            return first;
        }

        public E getSecond() {
            return second;
        }
    }

    public Game() {
        gameBoard[0][0] = 2;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public boolean addTwo() {
        List<Pair<Integer>> zeroIndices = new ArrayList<Pair<Integer>>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (gameBoard[i][j] == 0) {
                    zeroIndices.add(new Pair<>(i, j));
                }
            }
        }
        if (zeroIndices.isEmpty()) {
            return false;
        } else {
            int idx = (int) (Math.random() * zeroIndices.size());
            gameBoard[zeroIndices.get(idx).getFirst()][zeroIndices.get(idx).getSecond()] = 2;
            return true;
        }
    }

    public boolean left(){
        for (int i = 0; i < ROWS; i++){
            int avaiPos = 0;
            while(avaiPos < COLUMNS - 1){
                if (gameBoard[i][avaiPos] == 0){
                    int find = avaiPos + 1;
                    while(find < COLUMNS - 1 && gameBoard[i][find] == 0){
                        find ++;
                    }

                    //find is now the column index of the first non zero entry after avaiPos or COLUMNS - 1
                    gameBoard[i][avaiPos] = gameBoard[i][find];
                    gameBoard[i][find] = 0;
                }
                int value = gameBoard[i][avaiPos];
                int find = avaiPos + 1;
                while (find < COLUMNS && gameBoard[i][find] == 0){
                    find ++;
                }
                if (find < COLUMNS && gameBoard[i][find] == value){
                    gameBoard[i][avaiPos] *= 2;
                    gameBoard[i][find] = 0;
                }
                avaiPos++;
            }
        }
        return addTwo();
    }

    public boolean right(){
        for (int i = 0; i < ROWS; i++){
            int avaiPos = COLUMNS - 1;
            while(avaiPos > 0){
                if (gameBoard[i][avaiPos] == 0){
                    int find = avaiPos - 1;
                    while(find > 0 && gameBoard[i][find] == 0){
                        find --;
                    }

                    //find is now the column index of the first non zero entry before avaiPos or 0
                    gameBoard[i][avaiPos] = gameBoard[i][find];
                    gameBoard[i][find] = 0;
                }
                int value = gameBoard[i][avaiPos];
                int find = avaiPos - 1;
                while (find >= 0 && gameBoard[i][find] == 0){
                    find --;
                }
                if (find >= 0 && gameBoard[i][find] == value){
                    gameBoard[i][avaiPos] *= 2;
                    gameBoard[i][find] = 0;
                }
                avaiPos--;
            }
        }
        return addTwo();
    }

    public boolean up(){
        for (int i = 0; i < COLUMNS; i++){
            int avaiPos = 0;
            while(avaiPos < ROWS - 1){
                if (gameBoard[avaiPos][i] == 0){
                    int find = avaiPos + 1;
                    while(find < ROWS - 1 && gameBoard[find][i] == 0){
                        find ++;
                    }

                    //find is now the column index of the first non zero entry after avaiPos or COLUMNS - 1
                    gameBoard[avaiPos][i] = gameBoard[find][i];
                    gameBoard[find][i] = 0;
                }
                int value = gameBoard[avaiPos][i];
                int find = avaiPos + 1;
                while (find < ROWS && gameBoard[find][i] == 0){
                    find ++;
                }
                if (find < ROWS && gameBoard[find][i] == value){
                    gameBoard[avaiPos][i] *= 2;
                    gameBoard[find][i] = 0;
                }
                avaiPos++;
            }
        }
        return addTwo();
    }

    public boolean down(){
        for (int i = 0; i < COLUMNS; i++){
            int avaiPos = ROWS - 1;
            while(avaiPos > 0){
                if (gameBoard[avaiPos][i] == 0){
                    int find = avaiPos - 1;
                    while(find > 0 && gameBoard[find][i] == 0){
                        find --;
                    }

                    //find is now the column index of the first non zero entry before avaiPos or 0
                    gameBoard[avaiPos][i] = gameBoard[find][i];
                    gameBoard[find][i] = 0;
                }
                int value = gameBoard[avaiPos][i];
                int find = avaiPos - 1;
                while (find >= 0 && gameBoard[find][i] == 0){
                    find --;
                }
                if (find >= 0 && gameBoard[find][i] == value){
                    gameBoard[avaiPos][i] *= 2;
                    gameBoard[find][i] = 0;
                }
                avaiPos--;
            }
        }
        return addTwo();
    }

}
