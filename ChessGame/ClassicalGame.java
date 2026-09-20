package ChessGame;
import ChessGame.ChessGame;
public class ClassicalGame implements ChessGame {
    @Override
    public void startGame(){
        System.out.println("Началась игра в режиме классика!");
    }

    @Override
    public void gameInfo(){
        System.out.println("Режим: классика. Контроль времени: 90 минут каждому игроку без добавления.");
    }

    @Override
    public void resultGame(){
        System.out.println("Результат пока не определён.");
    }
}
