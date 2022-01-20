package Main;

import Entity.Entity;
import Entity.Player;
import object.SuperObject;
import tile.Tile;
import tile.TileManager;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int orginalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = orginalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize *maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public Sound music = new Sound();
    public Sound se = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public UI ui = new UI(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public Entity monster[] = new Entity[20];

    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    public GamePanel() throws IOException {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() throws IOException {
        aSetter.setObject();
        aSetter.setNPC();
        playMusic(0);
        aSetter.setMonster();
        gameState = playState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {


        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {


            // update information such as character position
            update();
            // draw  - draw the screen with the updated information
            repaint();
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;

            if(remainingTime < 0 ) {
                remainingTime = 0;
            }
            try {
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        if( gameState == playState) {
            player.update();

            for (int i = 0; i <npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].update();
                }
            }
        }
        if( gameState == pauseState) {
            //
        }

       /* for( int i = 0; i < monster.length; i++) {
            if(monster[i] != null) {
                monster[i].update();
            }
        }*/

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //TILES
        tileM.draw(g2);
        //DRAW OBJECTS ON MAP
        for (int i = 0; i < obj.length; i ++) {
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }//DRAW NPCS
        for (int i =0; i < npc.length; i++) {
            if(npc[i] != null) {
                npc[i].draw(g2);
            }
        }
        //PLAYER
        player.draw(g2);
        ui.draw(g2);
        
        g2.dispose();

    } public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    } public void playSoundEffect(int i) {
        se.setFile(i);
        se.play();
    }
}
