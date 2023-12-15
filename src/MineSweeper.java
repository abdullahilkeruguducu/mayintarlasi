import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rows;
    int cols;
    int[][] board;
    boolean[][] mines;
    boolean[][] isOpen;
    boolean gameWon;

    public MineSweeper(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
        this.mines = new boolean[rows][cols];
        this.isOpen = new boolean[rows][cols];
        this.gameWon = false;
    }

    public void placeMines() {
        int totalMines = rows * cols / 4;
        Random rand = new Random();

        for (int i = 0; i < totalMines; i++) {
            int row, col;
            do {
                row = rand.nextInt(rows);
                col = rand.nextInt(cols);
            } while (mines[row][col]);

            mines[row][col] = true;
        }
    }

    public void printBoard() {
        System.out.println("===================");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isOpen[i][j]) {
                    if (mines[i][j]) {
                        System.out.print("* ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    public void revealCell(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || isOpen[row][col]) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                System.out.println("Geçersiz bir hücre seçtiniz. Lütfen tekrar deneyin.");
            }
            return;
        }
        isOpen[row][col] = true;

        if (board[row][col] == 0 && !mines[row][col]) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        revealCell(i, j);
                    }
                }
            }
        }

        if (mines[row][col]) {
            printBoard();
            System.out.println("Game Over!!");
            gameWon = true;
            return;
        }

        if (checkWin()) {
            printBoard();
            System.out.println("Oyunu Kazandınız!");
            gameWon = true;
        }
    }

    public void calculateBoardValues() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!mines[i][j]) {
                    board[i][j] = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k >= 0 && k < rows && l >= 0 && l < cols && mines[k][l]) {
                                board[i][j]++;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!mines[i][j] && !isOpen[i][j]) {
                    return false;
                }
            }
        }
        gameWon = true;
        return true;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");

        System.out.print("Satır Sayısı Giriniz: ");
        rows = input.nextInt();

        System.out.print("Sütun Sayısı Giriniz: ");
        cols = input.nextInt();

        board = new int[rows][cols];
        mines = new boolean[rows][cols];
        isOpen = new boolean[rows][cols];

        placeMines();
        calculateBoardValues();

        while (!gameWon) {
            printBoard();

            System.out.print("Satır Giriniz: ");
            int row = input.nextInt() - 1;

            System.out.print("Sütun Giriniz: ");
            int col = input.nextInt() - 1;

            revealCell(row, col);
        }
    }
}