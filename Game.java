import java.util.Scanner;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;

    public Board getBoard() {
        return board;
    }

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Game(String fileName) {
        board = Board.load(fileName);
    }

    public void start() {
        positioning();
    }

    public void positioning() {
        Scanner in = new Scanner(System.in);

        // User chooses between standard or offset position
        System.out.println("Starting position of the board:");
        System.out.println("1. Standard Othello starting position.");
        System.out.println("2. Offset starting position.");
        System.out.print("Choice: ");
        String firstChoice = in.nextLine();
        String secondChoice;
        boolean unvalid = true;

        // Loop to make sure
        do{
            if(firstChoice.equals("1")) {
                board = new Board(this.p1, this.p2, 1);
                unvalid = false;
            }
            else if(firstChoice.equals("2")) {
                System.out.println("1. Top left: ");
                System.out.println("2. Top right: ");
                System.out.println("3. Bottom left: ");
                System.out.println("4. Bottom Right: ");
                System.out.print("Choice: ");
                secondChoice = in.nextLine();
                switch(secondChoice) {
                    case("1"):
                        board = new Board(this.p1, this.p2, 2);
                        unvalid = false;
                        break;
                    case("2"):
                        board = new Board(this.p1, this.p2, 3);
                        unvalid = false;
                        break;
                    case("3"):
                        board = new Board(this.p1, this.p2, 4);
                        unvalid = false;
                        break;
                    case("4"):
                        board = new Board(this.p1, this.p2, 5);
                        unvalid = false;
                        break;
                    default:
                        System.out.println("You have not entered 1,2,3 or 4.");
                        unvalid = true;
                }
            }
        } while(unvalid);

        board.drawBoard();
        board.play();
    }

}