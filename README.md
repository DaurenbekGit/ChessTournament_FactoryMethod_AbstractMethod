# Шахматное приложение — Factory Method и Abstract Factory

Учебный Java-проект для Assignment #2 по Software Design Patterns. Приложение демонстрирует выбор режима шахматной игры с помощью Factory Method и создание шахматного набора с помощью Abstract Factory.

Это консольная демонстрация паттернов. Шахматные ходы, отсчёт времени и определение победителя не реализованы.

## Структура проекта

```text
FactoryMethod_AbstractFactory/
├── pom.xml
└── src/main/java/
    ├── Main.java
    ├── ChessGame/
    │   ├── ChessGame.java
    │   ├── BulletGame.java
    │   ├── BlitzGame.java
    │   ├── RapidGame.java
    │   └── ClassicalGame.java
    ├── ChessGameFactory/
    │   ├── ChessGameFactory.java
    │   ├── BulletGameFactory.java
    │   ├── BlitzGameFactory.java
    │   ├── RapidGameFactory.java
    │   └── ClassicalGameFactory.java
    └── AbstractFactory/
        ├── Board/
        │   ├── Board.java
        │   ├── ClassicBoard.java
        │   └── TournamentBoard.java
        ├── Pieces/
        │   ├── Pieces.java
        │   ├── ClassicPieces.java
        │   └── TournamentPieces.java
        └── FactoryIn/
            ├── ChessSetFactory.java
            ├── ClassicChessFactory.java
            └── TournamentChessFactory.java
```

## Factory Method

Factory Method отделяет создание конкретного режима игры от его использования. Клиент обращается к интерфейсу фабрики, а конкретная фабрика определяет класс создаваемого объекта.

| Роль паттерна | Элемент проекта | Назначение |
|---|---|---|
| Product | `ChessGame` | Общий контракт игры: `startGame()`, `gameInfo()`, `resultGame()` |
| Concrete Products | `BulletGame`, `BlitzGame`, `RapidGame`, `ClassicalGame` | Реализации режимов игры |
| Creator | `ChessGameFactory` | Объявляет фабричный метод `createGame()` |
| Concrete Creators | Четыре класса фабрик режимов | Создают соответствующие игры |
| Client | `Main` | Получает игру через фабрику и вызывает её методы |

Общий интерфейс фабрики:

```java
public interface ChessGameFactory {
    ChessGame createGame();
}
```

Пример конкретной фабрики:

```java
public class BlitzGameFactory implements ChessGameFactory {

    @Override
    public ChessGame createGame() {
        return new BlitzGame();
    }
}
```

Использование в клиентском коде:

```java
ChessGame game = factory.createGame();
game.startGame();
```

Переменная `factory` содержит выбранную фабрику. Клиент использует интерфейс `ChessGame` и не создаёт конкретную игру напрямую.

## Abstract Factory

Abstract Factory создаёт семейство связанных продуктов: шахматную доску и набор фигур одного стиля.

В проекте представлены две семьи:

| Семья | Доска | Фигуры | Фабрика |
|---|---|---|---|
| Classic | `ClassicBoard` | `ClassicPieces` | `ClassicChessFactory` |
| Tournament | `TournamentBoard` | `TournamentPieces` | `TournamentChessFactory` |

Роли компонентов:

- `Board` и `Pieces` — интерфейсы абстрактных продуктов.
- Конкретные доски и фигуры — реализации продуктов каждой семьи.
- `ChessSetFactory` — интерфейс абстрактной фабрики.
- `ClassicChessFactory` и `TournamentChessFactory` — конкретные фабрики.

Общий интерфейс фабрики:

```java
public interface ChessSetFactory {
    Board createBoard();
    Pieces createPieces();
}
```

Например, `ClassicChessFactory` возвращает `ClassicBoard` из `createBoard()` и `ClassicPieces` из `createPieces()`.

Клиент получает оба продукта от одной фабрики:

```java
Board board = setFactory.createBoard();
Pieces pieces = setFactory.createPieces();

board.showBoard();
pieces.showPieces();
```

Это обеспечивает согласованность набора: при выборе Classic создаются классические доска и фигуры, при выборе Tournament — турнирные.

## Работа Main

`Main` отвечает за консольный ввод и настройку демонстрации:

1. Показывает четыре режима игры.
2. Проверяет, что введено целое число и выбран существующий пункт.
3. Создаёт соответствующую `ChessGameFactory`.
4. Получает игру через `createGame()` и вызывает `startGame()`.
5. Предлагает выбрать Classic или Tournament.
6. Создаёт соответствующую `ChessSetFactory`.
7. Получает и отображает доску и фигуры.

Конкретные фабрики выбираются в `Main` при настройке приложения. Дальнейшая работа с играми, досками и фигурами выполняется через интерфейсы.

При нечисловом вводе или выборе числа вне меню программа выводит сообщение и завершается.

## Различие паттернов в проекте

**Factory Method** использует отдельные реализации фабричного метода для создания конкретного продукта типа `ChessGame`.

**Abstract Factory** предоставляет несколько методов создания, чтобы получить согласованную семью продуктов: `Board` и `Pieces`.

## Применённые принципы Clean Code

### 1. Понятные имена

```java
ChessSetFactory setFactory;
Board board = setFactory.createBoard();
Pieces pieces = setFactory.createPieces();
```

Названия отражают назначение объектов и методов: фабрика создаёт доску и фигуры.

### 2. Небольшие методы с одной задачей

```java
@Override
public ChessGame createGame() {
    return new BlitzGame();
}
```

Метод выполняет одну операцию — создаёт конкретную игру. Он не обрабатывает пользовательский ввод и не выводит меню.

### 3. Разделение ответственности

```java
factory = new BulletGameFactory();
```

`Main` выбирает фабрику по вводу пользователя.

```java
return new BulletGame();
```

`BulletGameFactory` отвечает за создание продукта. Выбор пользователя и создание конкретной игры разделены между компонентами.

### 4. Устранение повторения

Вместо повторения создания и запуска игры внутри каждой ветки выбора используется общий блок:

```java
ChessGame game = factory.createGame();
game.startGame();
```

Ветви `if / else if` только выбирают фабрику. Общие действия с продуктом записаны один раз.

### 5. Проверка входных данных

```java
if (!scanner.hasNextInt()) {
    System.out.println("Нужно ввести целое число.");
    scanner.close();
    return;
}
```

Проверка выполняется до `nextInt()`, поэтому нечисловой ввод не приводит к необработанному исключению. Отдельные ветви `else` обрабатывают числа вне диапазона меню.

### 6. Работа через абстракции

```java
Board board = setFactory.createBoard();
Pieces pieces = setFactory.createPieces();
```

Код использования продуктов зависит от интерфейсов `Board` и `Pieces`. Конкретные реализации выбирает фабрика.

## Расширение проекта

Для добавления нового режима игры нужно:

1. Создать класс, реализующий `ChessGame`.
2. Создать соответствующую фабрику, реализующую `ChessGameFactory`.
3. Добавить пункт меню и выбор фабрики в `Main`.

Для добавления новой семьи шахматных наборов нужно:

1. Создать новые реализации `Board` и `Pieces`.
2. Создать фабрику, реализующую `ChessSetFactory`.
3. Добавить выбор новой фабрики в `Main`.

Существующие фабрики и продукты при этом не требуют изменений. Меню и код выбора фабрики необходимо дополнить.

## Запуск

Требования: JDK 21 и Maven либо IntelliJ IDEA с настроенным JDK 21.

В IntelliJ IDEA откройте проект через `pom.xml`, выберите JDK 21 и запустите метод `main()` в классе `Main`.

Для запуска из терминала в корне проекта:

```bash
mvn clean compile
java -cp target/classes Main
```
