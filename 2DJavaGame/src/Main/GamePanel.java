package Main;

import Entity.Entity;
import Entity.Player;
import tile.TileManager;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.awt.Color.white;

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
    public KeyHandler keyH = new KeyHandler(this);
    public Sound music = new Sound();
    public Sound se = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public AssetSetter aSetter = new AssetSetter(this);

    //objects and entities
    public Player player = new Player(this, keyH);
    public Entity monster[] = new Entity[20];

    public Entity obj[] = new Entity [10];
    public Entity npc[] = new Entity[10];
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;


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
        aSetter.setMonster();
        gameState = titleState;
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
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {
                    monster[i].update();
                }
            }
        }
        if( gameState == pauseState) {
            //
        }
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //TITLE SCREEN
       if(gameState == titleState) {
           try { ui.draw(g2); }
           catch (IOException e) {e.printStackTrace();   }
       }
        //OTHERS
        else {
            //TILES
            tileM.draw(g2);

            // add player to entity list
            entityList.add(player);
            //add npcs to entity list
            for ( int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }
            //add object to entity list
            for (int i = 0; i < obj.length; i++) {
                if(obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }
            // sort list
           Collections.sort(entityList, new Comparator<Entity>() {
               @Override
               public int compare(Entity e1, Entity e2) {
                   int result = Integer.compare(e1.worldY, e2.worldY);
                   return result;
               }
           });
            //DRAW ENTITIES
           for(int i = 0; i < entityList.size(); i++) {
               entityList.get(i).draw(g2);
           }
           entityList.clear();
           try { ui.draw(g2); } catch (IOException e) {   e.printStackTrace();  }
        }
//        if(keyH.checkDrawTime == true) {
//            long drawEnd = System.nanoTime();
//            long passed = drawEnd - drawStart;
//            g2.setColor(white);
//            g2.setFont(new Font("Impact", Font.PLAIN, 10));
//            g2.drawString("Draw Time:" + passed, 10, 400);
//            int x = 10;
//            int y = 400;
//            g2.drawString("WorldX" + player.worldX, x, y); y += tileSize/2;
//            g2.drawString("WorldY: "+ player.worldY, x, y); y += tileSize/2;
//            g2.drawString("Col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y += tileSize/2;
//            g2.drawString("Row: "+ (player.worldY + player.solidArea.y)/tileSize, x, y);
//        }
        g2.dispose();
    }
    public void playMusic(int i) {
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
