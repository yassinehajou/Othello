import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Board {
    private String name;
    private Player first;
    private Player second;
    private Player current;
    private Player other;
    private PlayablePosition[][] boardPieces;

    public Board(Player p1, Player p2, int start) {
        first = p1;
        second = p2;
        current = first;
        other = second;
        boardPieces = new PlayablePosition[8][8];
        initializeBoard(start);
    }

    public void play() {

        Scanner in = new Scanner(System.in);
        boolean illegal = true;

        while (true) {
            System.out.println("--"+current.getName() + " (" + current.getPiece() + ") turn--");

            if (!canPlayerMove()) {
                System.out.println("You cannot make a move. Choose one of the following options:");
                System.out.println("1. Save Game");
                System.out.println("2. Concede");
                System.out.println("3. Forfeit Turn");
                System.out.print("Choice: ");
                String choice = in.nextLine();
                switch (choice) {
                    case "1":
                        System.out.print("Enter file name to save the game: ");
                        String saveFile = in.nextLine();
                        save(saveFile);
                        break;
                    case "2":
                        System.out.println(current.getName() + " has conceded. " + other.getName() + " wins!");
                        System.exit(0);
                    case "3":
                        takeTurn();
                        continue;
                    default:
                        System.out.println("Invalid choice, try again.");
                        continue;
                }
            }

            System.out.println("Choose one of the following options:");
            System.out.println("1. Save Game");
            System.out.println("2. Concede");
            System.out.println("3. Make a Move");
            System.out.print("Choice: ");
            String choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter file name to save the game: ");
                    String saveFile = in.nextLine();
                    save(saveFile);
                    continue;
                case "2":
                    System.out.println(current.getName() + " has conceded. " + other.getName() + " wins!");
                    System.exit(0);
                case "3":
                    break; // Proceed to make a move
                default:
                    System.out.println("Invalid choice, try again.");
                    continue;
            }

            do {
                System.out.print("Pick position (A1 notation): ");
                String position = in.nextLine().toUpperCase();
                if (position.length() != 2) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }

                char columnChar = position.charAt(0);
                char rowChar = position.charAt(1);
                int column = columnChar - 'A';
                int row = rowChar - '1';

                if (!isWithinBounds(row, column)) {
                    System.out.println("Out of bounds. Try again.");
                    continue;
                }

                if (boardPieces[row][column].canPlay(boardPieces, row, column, current.getPiece())) {
                    boardPieces[row][column].flipPieces(boardPieces, row, column, current.getPiece());
                    makeMove(boardPieces[row][column], current.getPiece());
                    illegal = false;
                } else {
                    System.out.println("Illegal move, try again.");
                    illegal = true;
                }
            } while (illegal);

            drawBoard();
            if(gameOver()) break;
            else takeTurn();;
        }
    }

    private boolean canPlayerMove() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPieces[i][j].canPlay(boardPieces,i,j,current.getPiece())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean gameOver() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPieces[i][j].canPlay(boardPieces,i,j,first.getPiece()) || boardPieces[i][j].canPlay(boardPieces,i,j,second.getPiece())) {
                    return false;
                }
            }
        }

        int firstCount = 0;
        int secondCount = 0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(boardPieces[i][j].getPiece() == 'B') firstCount++;
                else if (boardPieces[i][j].getPiece() == 'W') secondCount++;
            }
        }

        String winner;
        if (firstCount > secondCount) winner = first.getName();
        else if( secondCount > firstCount) winner = second.getName();
        else winner = "TIE";

        System.out.println("GAME OVER!");
        System.out.println(first.getName()+": "+ firstCount);
        System.out.println(second.getName()+": "+ secondCount);
        System.out.println("Winner: "+ winner);

        return true;
    }

    private void makeMove(Position position, char piece) {
        position.setPiece(piece);
    }

    private void takeTurn() {
        current = (current.equals(first)) ? second : first;
        other = (current.equals(first)) ? second : first;
    }

    private void initializeBoard(int start) {
        allEmpty();
        switch(start) {
            case(1):
                setupStandard();
                break;
            case(2):
                setupOffset1();
                break;
            case(3):
                setupOffset2();
                break;
            case(4):
                setupOffset3();
                break;
            case(5):
                setupOffset4();
                break;
        }
    }
    private void allEmpty() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardPieces[i][j] = new PlayablePosition();
            }
        }
        boardPieces[0][2].setPiece('*');
        boardPieces[0][3].setPiece('*');
        boardPieces[0][4].setPiece('*');
        boardPieces[0][5].setPiece('*');

    }
    private void setupStandard() {
        boardPieces[3][3].setPiece('W');
        boardPieces[3][4].setPiece('B');
        boardPieces[4][3].setPiece('B');
        boardPieces[4][4].setPiece('W');
    }
    private void setupOffset1() {
        boardPieces[2][2].setPiece('W');
        boardPieces[2][3].setPiece('B');
        boardPieces[3][2].setPiece('B');
        boardPieces[3][3].setPiece('W');
    }
    private void setupOffset2() {
        boardPieces[2][4].setPiece('W');
        boardPieces[3][4].setPiece('B');
        boardPieces[2][5].setPiece('B');
        boardPieces[3][5].setPiece('W');
    }
    private void setupOffset3() {
        boardPieces[4][2].setPiece('W');
        boardPieces[5][2].setPiece('B');
        boardPieces[4][3].setPiece('B');
        boardPieces[5][3].setPiece('W');
    }
    private void setupOffset4() {
        boardPieces[4][4].setPiece('W');
        boardPieces[4][5].setPiece('B');
        boardPieces[5][4].setPiece('B');
        boardPieces[5][5].setPiece('W');
    }

    public void drawBoard() {
        System.out.println(" |A|B|C|D|E|F|G|H|");
        for(int i=0;i<8;i++) {
            System.out.print((i+1)+"|");
            for(int j=0;j<8;j++) {
                System.out.print(boardPieces[i][j].getPiece()+"|");
            }
            System.out.println();
        }
    }

    private boolean isWithinBounds(int row, int col) {
        return (row >= 0 && row < 8 && col >= 0 && col < 8);
    }

    private void save(String saveFile) {
        try (FileWriter writer = new FileWriter(saveFile)) {

            writer.write(first.getName() + "\n");
            writer.write(second.getName() + "\n");
            writer.write(current.getName() + "\n");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    writer.write(boardPieces[i][j].getPiece());
                }
                writer.write("\n"); // Move to the next line after each row
            }
            System.out.println("Game saved successfully to " + saveFile);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static Board load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String firstPlayerName = reader.readLine();
            String secondPlayerName = reader.readLine();
            String currentPlayerName = reader.readLine();

            Player first = new Player(firstPlayerName, 'B');
            Player second = new Player(secondPlayerName, 'W');

            // Determine the current player
            Player current;
            if (currentPlayerName.equals(firstPlayerName)) {
                current = first;
            } else {
                current = second;
            }

            Board board = new Board(first, second, 1); // Use default start to initialize the board
            board.current = current;

            // Read the board state
            for (int i = 0; i < 8; i++) {
                String line = reader.readLine();
                for (int j = 0; j < 8; j++) {
                    char piece = line.charAt(j);
                    board.boardPieces[i][j].setPiece(piece);
                }
            }

            System.out.println("Game loaded successfully.");
            return board;

        } catch (IOException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }
    }
}
