package ChessGameFactory;

import ChessGame.ChessGame;
import ChessGame.BulletGame;

public class BulletGameFactory implements ChessGameFactory {

    @Override
    public ChessGame createGame(){
        return new BulletGame();
    }
}
