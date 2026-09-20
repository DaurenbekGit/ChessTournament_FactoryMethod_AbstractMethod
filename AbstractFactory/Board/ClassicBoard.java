package AbstractFactory.Board;

public class ClassicBoard implements Board {

    @Override
    public void showBoard() {
        System.out.println("Classic chess board");
    }
}