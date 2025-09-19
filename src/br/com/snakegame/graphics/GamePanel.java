package br.com.snakegame.graphics;

import br.com.snakegame.core.GameState;
import br.com.snakegame.core.SnakeGame;
import br.com.snakegame.snake.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private SnakeGame game;

    public GamePanel() {
        this.game = new SnakeGame(this);
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (game.getState() == GameState.PLAYING) {
            drawPlayingState(g);
        } else if (game.getState() == GameState.MENU) {
            drawMenuState(g);
        } else if (game.getState() == GameState.GAME_OVER) {
            drawGameOverState(g);
        }
    }

    private void drawPlayingState(Graphics g) {
        // Desenha o placar
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + game.getScore(), (600 - metrics.stringWidth("Score: " + game.getScore())) / 2, g.getFont().getSize());

        // Desenha a comida
        g.setColor(Color.RED);
        g.fillOval(game.getFood().getPosition().x, game.getFood().getPosition().y, 20, 20);

        // Desenha a cobrinha
        for (int i = 0; i < game.getSnake().getBody().size(); i++) {
            if (i == 0) {
                g.setColor(Color.GREEN); // Cabeça
            } else {
                g.setColor(new Color(45, 180, 0)); // Corpo
            }
            g.fillRect(game.getSnake().getBody().get(i).x, game.getSnake().getBody().get(i).y, 20, 20);
        }
    }

    private void drawMenuState(Graphics g) {
        String title = "Java Snake Game";
        String instructions = "Pressione ENTER para jogar";

        g.setColor(Color.YELLOW);
        g.setFont(new Font("Monospaced", Font.BOLD, 40));
        FontMetrics metricsTitle = getFontMetrics(g.getFont());
        g.drawString(title, (600 - metricsTitle.stringWidth(title)) / 2, 200);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 20));
        FontMetrics metricsInstructions = getFontMetrics(g.getFont());
        g.drawString(instructions, (600 - metricsInstructions.stringWidth(instructions)) / 2, 300);
    }

    private void drawGameOverState(Graphics g) {
        String gameOver = "GAME OVER";
        String scoreText = "Placar: " + game.getScore();
        String instructions = "Pressione ENTER para jogar novamente";

        g.setColor(Color.RED);
        g.setFont(new Font("Monospaced", Font.BOLD, 50));
        FontMetrics metricsGameOver = getFontMetrics(g.getFont());
        g.drawString(gameOver, (600 - metricsGameOver.stringWidth(gameOver)) / 2, 200);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.PLAIN, 25));
        FontMetrics metricsScore = getFontMetrics(g.getFont());
        g.drawString(scoreText, (600 - metricsScore.stringWidth(scoreText)) / 2, 250);

        g.setFont(new Font("Monospaced", Font.PLAIN, 15));
        FontMetrics metricsInstructions = getFontMetrics(g.getFont());
        g.drawString(instructions, (600 - metricsInstructions.stringWidth(instructions)) / 2, 350);
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (game.getState() == GameState.PLAYING) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        game.getSnake().setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.getSnake().setDirection(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_UP:
                        game.getSnake().setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.getSnake().setDirection(Direction.DOWN);
                        break;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                game.startGame();
                repaint();
            }
        }
    }
}