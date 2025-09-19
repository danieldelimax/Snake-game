package br.com.snakegame.snake;

import java.awt.Point;
import java.util.Random;

public class Food {
    private Point position;

    public Point getPosition() {
        return position;
    }

    public void generateNewPosition(int boardWidth, int boardHeight, int unitSize, java.util.List<Point> snakeBody) {
        Random random = new Random();
        boolean collision;
        do {
            collision = false;
            int x = random.nextInt((int) (boardWidth / unitSize)) * unitSize;
            int y = random.nextInt((int) (boardHeight / unitSize)) * unitSize;
            this.position = new Point(x, y);

            for (Point p : snakeBody) {
                if (p.equals(this.position)) {
                    collision = true;
                    break;
                }
            }
        } while (collision);
    }
}