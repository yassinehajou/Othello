public class PlayablePosition extends Position {

    public PlayablePosition() {
        super();
    }

    @Override
    public boolean canPlay(Position[][] board, int row, int col, char currentPiece) {
        char opponentPiece = (currentPiece == BLACK) ? WHITE : BLACK;

        int[][] directions = {
                {-1, 0}, {1, 0}, {0, 1}, {0, -1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        boolean validMove = false;

        if(board[row][col].getPiece() != EMPTY) return false;

        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];

            boolean hasOpponentBetween = false;

            while (isWithinBounds(x, y) && board[x][y].getPiece() == opponentPiece) {
                hasOpponentBetween = true;
                x += direction[0];
                y += direction[1];
            }

            if (hasOpponentBetween && isWithinBounds(x, y) && board[x][y].getPiece() == currentPiece) {
                validMove = true;
            }
        }
        return validMove;
    }

    public void flipPieces(Position[][] board, int row, int col, char currentPiece) {
        char opponentPiece = (currentPiece == BLACK) ? WHITE : BLACK;

        int[][] directions = {
                {-1, 0}, {1, 0}, {0, 1}, {0, -1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        for (int[] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];

            boolean hasOpponentBetween = false;

            while (isWithinBounds(x, y) && board[x][y].getPiece() == opponentPiece) {
                hasOpponentBetween = true;
                x += direction[0];
                y += direction[1];
            }

            if (hasOpponentBetween && isWithinBounds(x, y) && board[x][y].getPiece() == currentPiece) {
                // Flip the pieces in this direction
                int flipX = row + direction[0];
                int flipY = col + direction[1];

                while (isWithinBounds(flipX, flipY) && (flipX != x || flipY != y)) {
                    board[flipX][flipY].setPiece(currentPiece);
                    flipX += direction[0];
                    flipY += direction[1];
                }
            }
        }
    }

    private boolean isWithinBounds(int row, int col) {
        return (row >= 0 && row < 8 && col >= 0 && col < 8);
    }
}
