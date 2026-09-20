package AbstractFactory.FactoryIn;

import AbstractFactory.Board.Board;
import AbstractFactory.Board.TournamentBoard;
import AbstractFactory.Pieces.Pieces;
import AbstractFactory.Pieces.TournamentPieces;

public class TournamentChessFactory implements ChessSetFactory {

    @Override
    public Board createBoard() {
        return new TournamentBoard();
    }

    @Override
    public Pieces createPieces() {
        return new TournamentPieces();
    }
}