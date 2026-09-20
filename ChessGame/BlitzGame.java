package ChessGame;

public class BlitzGame implements ChessGame {

    @Override
    public void startGame() {
        System.out.println("Началась игра в режиме блиц!");
    }

    @Override
    public void gameInfo() {
        System.out.println("Режим: блиц. Контроль времени: 5 минут каждому игроку без добавления.");
    }

    @Override
    public void resultGame() {
        System.out.println("Результат пока не определён.");
    }
}