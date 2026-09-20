package AbstractFactory.FactoryIn;

import AbstractFactory.Board.Board;
import AbstractFactory.Pieces.Pieces;

public interface ChessSetFactory {

    Board createBoard();

    Pieces createPieces();
}