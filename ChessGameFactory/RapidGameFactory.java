package ChessGameFactory;

import ChessGame.RapidGame;
import ChessGame.ChessGame;

public class RapidGameFactory implements ChessGameFactory{

    @Override
    public ChessGame createGame(){
        return new RapidGame();
    }
}
