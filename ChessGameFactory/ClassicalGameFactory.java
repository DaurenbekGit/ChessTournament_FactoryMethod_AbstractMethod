package ChessGameFactory;

import ChessGame.ChessGame;
import ChessGame.ClassicalGame;

public class ClassicalGameFactory implements ChessGameFactory {

    @Override
    public ChessGame createGame(){
        return new ClassicalGame();
    }
}
