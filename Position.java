public class Position {
    protected char piece;
    final protected char UNPLAYABLE = '*';
    final protected char EMPTY = ' ';
    final protected char BLACK = 'B';
    final protected char WHITE = 'W';

    public Position() {
        piece = EMPTY;
    }
    public Position(char piece) {
        this.piece = piece;
    }

    public boolean canPlay(Position[][] board, int row, int col, char currentPiece) {
        return false;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
