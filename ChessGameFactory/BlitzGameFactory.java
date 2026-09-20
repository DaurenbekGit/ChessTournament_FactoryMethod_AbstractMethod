package ChessGameFactory;

import ChessGame.BlitzGame;
import ChessGame.ChessGame;

public class BlitzGameFactory implements ChessGameFactory {
    @Override
    public ChessGame createGame(){
        return new BlitzGame();
    }
}
