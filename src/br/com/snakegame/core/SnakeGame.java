package br.com.snakegame.core;

import br.com.snakegame.snake.Food;
import br.com.snakegame.snake.Snake;
import br.com.snakegame.graphics.GamePanel;

import java.awt.Point;
import javax.swing.Timer;

public class SnakeGame {
    private Snake snake;
    private Food food;
    private GameState state;
    private int score;
    private Timer gameTimer;
    private static final int BOARD_WIDTH = 600;
    private static final int BOARD_HEIGHT = 600;
    private static final int UNIT_SIZE = 20;
    private static final int DELAY = 100;

    private final GamePanel gamePanel;

    public SnakeGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.state = GameState.MENU;
    }

    public void startGame() {
        this.snake = new Snake();
        this.food = new Food();
        this.score = 0;
        this.state = GameState.PLAYING;

        food.generateNewPosition(BOARD_WIDTH, BOARD_HEIGHT, UNIT_SIZE, snake.getBody());

        if (gameTimer != null) {
            gameTimer.stop();
        }

        gameTimer = new Timer(DELAY, e -> {
            if (state == GameState.PLAYING) {
                updateGame();
                gamePanel.repaint();
            }
        });
        gameTimer.start();
    }

    private void updateGame() {
        snake.move();

        if (snake.getBody().getFirst().equals(food.getPosition())) {
            snake.grow();
            score += 10;
            food.generateNewPosition(BOARD_WIDTH, BOARD_HEIGHT, UNIT_SIZE, snake.getBody());
        }

        if (checkCollisions()) {
            endGame();
        }
    }

    private boolean checkCollisions() {
        Point head = snake.getBody().getFirst();

        if (head.x < 0 || head.x >= BOARD_WIDTH || head.y < 0 || head.y >= BOARD_HEIGHT) {
            return true;
        }

        for (int i = 1; i < snake.getBody().size(); i++) {
            if (head.equals(snake.getBody().get(i))) {
                return true;
            }
        }

        return false;
    }

    public void endGame() {
        this.state = GameState.GAME_OVER;
        gameTimer.stop();
    }

    public Snake getSnake() { return snake; }
    public Food getFood() { return food; }
    public GameState getState() { return state; }
    public int getScore() { return score; }
}