package ChessGame;
import ChessGame.ChessGame;

public class RapidGame implements ChessGame {
    @Override
    public void startGame(){
        System.out.println("Началась игра в режиме рапид!");
    }

    @Override
    public void gameInfo(){
        System.out.println("Режим: рапид. Контроль времени: 15 минут каждому игроку без добавления.");
    }

    @Override
    public void resultGame(){
        System.out.println("Результат пока не определён.");
    }
}
