package main;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_Potato;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class UI {

    GamePanel gp;
    Font tnr_40, tnr_80BOLD, tnr_15;
    //BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter;
    public boolean gameFinished = false;
    public String currentDialogue;
    public int commandNum = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) throws IOException {
        this.gp = gp;
        tnr_15 = new Font("Times New Roman", Font.PLAIN, 25);
        tnr_40 = new Font("Impact", Font.PLAIN, 40);
        tnr_80BOLD = new Font("Impact", Font.PLAIN, 70);
        //OBJ_Key key = new OBJ_Key(gp);
        //keyImage = key.image;

        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) throws IOException {
        this.g2 = g2;


        if (gameFinished == true) {

            g2.setFont(tnr_80BOLD);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You found the treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 -textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "Your Time: " + dFormat.format(playTime);
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 -textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*1);
            g2.drawString(text, x, y);

            g2.setFont(tnr_80BOLD);
            g2.setColor(Color.white);
            text = "Congratulations!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 -textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*3);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }  //TITLE SCREEN
        else if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        else if (gp.gameState == gp.playState) {
            // Do playState
            drawPlayerLife();

            g2.setFont(tnr_40);
            g2.setColor(Color.white);
            BufferedImage keyImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Objects/key.png")));
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("Keys = " + gp.player.hasKey, 80, 60);

            //TIME
            playTime += (double)1/60;
            g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 65);

            //MESSAGE
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                messageCounter++; }
            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;  }
        }

        else if( gp.gameState == gp.pauseState) {
            drawPauseScreen();
            drawPlayerLife();
        }
        else if(gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
            drawPlayerLife();
        }  else {
            //add more
        }
    }
    public void drawPlayerLife() {

        //gp.player.life = 5;
        int x = (gp.tileSize/2)-2;
        int y = (int) ((gp.tileSize/2) *21.5);
        int i = 0;

        //draw max life
        while (i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        //reset
        x = (gp.tileSize/2)-2;
        y = (int) ((gp.tileSize/2) *21.5);
        i = 0;
        //draw current life
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if ( i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x+= gp.tileSize; }
    }

    public void drawTitleScreen() throws IOException {

        BufferedImage potatoImage = ImageIO.read(new File("C:\\GenSpark_repo\\PotatoThief\\images\\artwork\\potato.png"));
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        //Title Name
        String text = " The Potato Thief";
        int x = getXforCenteredText(text) - (gp.tileSize*4);
        int y = gp.tileSize*2;
        //add a shadow
        g2.setColor(Color.white);
        g2.setFont(tnr_80BOLD);
        g2.drawString(text, x+3, y-5);

        g2.setColor(Color.RED);
        g2.drawString(text, x, y);

        //GOBLIN IMAGE
        x = gp.screenWidth/ 2 - gp.tileSize;
        y += gp.tileSize *2;
        g2.drawImage(potatoImage, x, y, gp.tileSize*2, gp.tileSize*2, null );
        //MENU
        g2.setFont(tnr_40);
        text = "New Game";
        x = getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Load Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "Quit Game";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }

    }
    public void drawDialogueScreen () {
        //window
        int x = gp.tileSize*4;
        int y = gp.tileSize*9;
        int width= gp.screenWidth - (gp.tileSize*4);
        int height = gp.screenHeight -(gp.tileSize*9);

        drawSubWindow(x, y, width, height);
        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.setFont(tnr_15);
        g2.drawString(currentDialogue, x, y);

        for(String line: currentDialogue.split("/n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0,0,0, 210 );
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.white);
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
    public void drawPauseScreen() {
        String text = "--GAME PAUSED--";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text) {
        int x;
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - length/2;
        return x;
    }

}

