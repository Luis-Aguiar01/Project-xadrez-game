package boardgame;

public class Board {
    private final int rows;
    private final int columns;
    private final Piece[][] pieces;

    public Board(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece getPiece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[row][column];
    }

    public Piece getPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column) {
        return ( row >= 0 && row < rows ) && ( column >= 0 && column < columns );
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return getPiece(position) != null;
    }
}