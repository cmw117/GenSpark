package Main;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

public class TestGame extends TestGame2 {

    boolean isRunning;
    Thread thread;
    BufferedImage view, tiles, gameOver, enemy;
    KeyListener e;
    int N = 40, M = 25;
    int tileSize = 18;
    int WIDTH = tileSize * N;
    int HEIGHT = tileSize * M;
    boolean right, left, up, down;
    int x = 0, y = 0, dx = 0, dy= 0;
    double timer = 0.0, delay = 0.5;
    int[][] grid;

    public TestGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(e);
    }

    public static void main(String[] args) {
        JFrame w = new JFrame(("TEST GAME"));
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.add(new TestGame());
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }
    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            isRunning = true;
            thread.start();
        }
    }

    public void start() {
        try {
            view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            tiles = ImageIO.read(getClass().getResource(""));
            gameOver = ImageIO.read(getClass().getResource(""));
            grid = new int[M][N];
            for ( int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0 || j == 0 || i == M || j == N -1) {
                        grid[i][j] = 1;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (left) {
            dx = -1;
            dy = 0;
        }
        if (right) {
            dx = 1;
            dy = 0;
        }
        if (up) {
            dx = 0;
            dy = -1;
        }
        if (down) {
            dx = 0;
            dy = 1;
        }
        timer += 0.3;

        if (timer > delay) {
            x += dx;
            y += dy;

            if (x < 0) {
                x = 0;
            }
            if (x > N - 1) {
                x = N -1;
            }
            if ( y < 0) {
                y = 0;
            }
            if ( y> M -1) {
                y = M -1;
            }
            if (grid[y][x] == 2) {
                isRunning = false;
            }
            if (grid[y][x] == 0) {
                grid[y][x] =2 ;
            }

            timer = 0;
        }
    }
    public void draw() {

        Graphics2D g2 = (Graphics2D) view.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0,0, WIDTH, HEIGHT);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                BufferedImage tile = null;
                if (grid[i][j] == 0) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    tiles = tiles.getSubimage(0, 0, tileSize, tileSize);
                }
                if (grid[i][j] == 2) {
                    tile = tiles.getSubimage(54, 0, tileSize, tileSize);
                }
                if (tile != null) {
                    g2.drawImage(tile, j*tileSize, i*tileSize, tileSize, tileSize, null);
                }
            }
        }
        g2.drawImage(
                tiles.getSubimage( 36, 0, tileSize, tileSize),
                x *tileSize, y *tileSize, null);
        if (!isRunning) {
            g2.drawImage(gameOver,
                    100,
                    120,
                    gameOver.getWidth(),
                    gameOver.getHeight(), null
            );
        }
        Graphics g = getGraphics();
        g.drawImage(view, 0, 0, WIDTH, HEIGHT, null);

    }
    @Override
    public void run() {
        try {
            requestFocus();
            start();
            while (isRunning) {
                update();
                draw();
                Thread.sleep(1000/60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
    }

}
