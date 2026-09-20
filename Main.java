import ChessGame.ChessGame;

import ChessGameFactory.ChessGameFactory;
import ChessGameFactory.BulletGameFactory;
import ChessGameFactory.BlitzGameFactory;
import ChessGameFactory.RapidGameFactory;
import ChessGameFactory.ClassicalGameFactory;

import AbstractFactory.Board.Board;
import AbstractFactory.Pieces.Pieces;
import AbstractFactory.FactoryIn.ChessSetFactory;
import AbstractFactory.FactoryIn.ClassicChessFactory;
import AbstractFactory.FactoryIn.TournamentChessFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Фактори метод

        System.out.println("Выберите параметр игры: ");
        System.out.println("1 - Пуля");
        System.out.println("2 - Блиц");
        System.out.println("3 - Рапид");
        System.out.println("4 - Классика");

        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число.");
            scanner.close();
            return;
        }

        int input = scanner.nextInt();

        ChessGameFactory factory;

        if (input == 1) {
            factory = new BulletGameFactory();
        } else if (input == 2) {
            factory = new BlitzGameFactory();
        } else if (input == 3) {
            factory = new RapidGameFactory();
        } else if (input == 4) {
            factory = new ClassicalGameFactory();
        } else {
            System.out.println("Неверный выбор");
            return;
        }

        ChessGame game = factory.createGame();
        game.startGame();


        //Абстракт фактори

        System.out.println();
        System.out.println("Выберите шахматный набор:");
        System.out.println("1 - Classic");
        System.out.println("2 - Tournament");

        if (!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число.");
            scanner.close();
            return;
        }

        int setInput = scanner.nextInt();
        ChessSetFactory setFactory;

        if (setInput == 1) {
            setFactory = new ClassicChessFactory();
        } else if (setInput == 2) {
            setFactory = new TournamentChessFactory();
        } else {
            System.out.println("Неверный выбор");
            return;
        }

        Board board = setFactory.createBoard();
        Pieces pieces = setFactory.createPieces();

        board.showBoard();
        pieces.showPieces();

        scanner.close();
    }
}