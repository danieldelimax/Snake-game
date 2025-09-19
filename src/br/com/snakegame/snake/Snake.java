package br.com.snakegame.snake;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private boolean isGrowing;
    private static final int UNIT_SIZE = 20;

    public Snake() {
        this.body = new LinkedList<>();
        this.body.add(new Point(0, 0)); // Posição inicial
        this.direction = Direction.RIGHT;
        this.isGrowing = false;
    }

    public void move() {
        Point head = new Point(body.getFirst());

        switch (direction) {
            case UP:
                head.y -= UNIT_SIZE;
                break;
            case DOWN:
                head.y += UNIT_SIZE;
                break;
            case LEFT:
                head.x -= UNIT_SIZE;
                break;
            case RIGHT:
                head.x += UNIT_SIZE;
                break;
        }

        body.addFirst(head);

        if (!isGrowing) {
            body.removeLast();
        } else {
            isGrowing = false;
        }
    }

    public void grow() {
        isGrowing = true;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public void setDirection(Direction direction) {
        // Evitar que a cobrinha vire 180 graus instantaneamente
        if (this.direction == Direction.UP && direction == Direction.DOWN ||
                this.direction == Direction.DOWN && direction == Direction.UP ||
                this.direction == Direction.LEFT && direction == Direction.RIGHT ||
                this.direction == Direction.RIGHT && direction == Direction.LEFT) {
            return;
        }
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}