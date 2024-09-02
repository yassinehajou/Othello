import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("--Welcome to Othello!--");
        System.out.println("Please select one of three following options:");
        System.out.println("1. Load a Game");
        System.out.println("2. Quit");
        System.out.println("3. Start a New Game");
        System.out.print("Choice: ");
        String gameMenu;
        boolean unvalid = true;
        do {
            gameMenu = in.nextLine();
            if(gameMenu.equals("1") || gameMenu.equals("2") || gameMenu.equals("3")) {
                unvalid = false;
            }
            else {
                System.out.print("Enter 1, 2 or 3 please: ");
                unvalid = true;
            }
        } while(unvalid);

        Game game;
        switch(gameMenu) {
            case("1"):
                System.out.print("Enter filename of the saved game: ");
                String fileName = in.nextLine();
                game = new Game(fileName);
                game.getBoard().drawBoard();
                game.getBoard().play();
                break;

            case("2"):
                System.out.println("Goodbye! See you soon.");
                System.exit(0);
                break;
            case("3"):
                System.out.print("Enter name of player 1: ");
                String p1Name = in.nextLine();

                System.out.print("Enter name of player 2: ");
                String p2Name = in.nextLine();

                Player player1 = new Player(p1Name,'B');
                Player player2 = new Player(p2Name,'W');

                game = new Game(player1, player2);
                game.start();
                break;
            default:
                System.out.println("Error Occured");
        }
    }
}
