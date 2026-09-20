package ChessGame;
import ChessGame.ChessGame;

public class BulletGame implements ChessGame {
    @Override
    public void startGame(){
        System.out.println("Началась игра в режиме пуля!");
    }

    @Override
    public void gameInfo(){
        System.out.println("Режим: пуля. Контроль времени: 1 минута каждому игроку без добавления.");
    }

    @Override
    public void resultGame(){
        System.out.println("Результат пока не определён.");
    }
}
