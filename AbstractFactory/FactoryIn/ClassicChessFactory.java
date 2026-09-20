package AbstractFactory.FactoryIn;

import AbstractFactory.Board.Board;
import AbstractFactory.Board.ClassicBoard;
import AbstractFactory.Pieces.Pieces;
import AbstractFactory.Pieces.ClassicPieces;

public class ClassicChessFactory implements ChessSetFactory {

    @Override
    public Board createBoard() {
        return new ClassicBoard();
    }

    @Override
    public Pieces createPieces() {
        return new ClassicPieces();
    }
}