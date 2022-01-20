package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) throws IOException {
        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize - (gp.tileSize / 2));
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() throws IOException {

        up1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_up_1.png");
        up2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_up_2.png");
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_down_1.png");
        down2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_down_2.png");
        left1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_left_1.png");
        left2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_left_2.png");
        right1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_right_1.png");
        right2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_right_2.png");
    }

    public BufferedImage setup(String filePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage scaledImage = null;
        try {
            scaledImage = ImageIO.read(new File(filePath));
            scaledImage = uTool.scaleImage(scaledImage, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            System.out.println("image not found" );
        } return scaledImage;
    }

    public void update() {

        if (keyH.upPressed == true) {
            worldY -= speed;
            direction = "up";
        } else if (keyH.downPressed == true) {
            worldY += speed;
            direction = "down";
        } else if (keyH.leftPressed == true) {
            worldX -= speed;
            direction = "left";
        } else if (keyH.rightPressed == true) {
            worldX += speed;
            direction = "right";
        }

        //check tile collision for movement
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this, true);

        int i = 0;
        pickUpObject(objIndex);
        //if collision is false, player can move
        if (collisionOn == false) {
            switch(direction) {
                case "up":  worldY -= speed;
                    break;
                case "down": worldY += speed;
                    break;
                case "left": worldX -= speed;
                    break;
                case "right": worldX += speed;
                    break; }
        }

    }
        public void pickUpObject(int i) {

            if(i != 999) {
                String objectName = gp.obj[i].name;

                switch(objectName) {
                    case "Key":
                        gp.playSoundEffect(1);
                        hasKey++;
                        gp.obj[i] = null;
                        System.out.println("Key: " + hasKey);
                        gp.ui.showMessage("You got a key!");
                        break;
                    case "Door":
                        if (hasKey > 0) {
                            gp.playSoundEffect(3);
                            gp.obj[i] = null;
                            gp.ui.showMessage("You've unlocked the door!");
                            hasKey--;
                        } else {
                            gp.ui.showMessage("You need to find a key");
                        }
                        System.out.println("Key: " + hasKey);
                        break;
                    case "Boots":
                        gp.playSoundEffect(2);
                        speed += 2;
                        gp.obj[i] = null;
                        gp.ui.showMessage("SPEED BOOST!");
                        break;
                    case "Chest":
                        gp.ui.gameFinished = true;
                        gp.stopMusic();
                        gp.playSoundEffect(4);
                        break;
                }
            }
        }


        public void draw (Graphics2D g2) {


                //g2.setColor(Color.white);
                //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

                BufferedImage image = null;

                switch (direction) {
                    case "up":
                        image = up1;
                    case "down":
                        image = down1;
                        break;
                    case "left":
                        image = left1;
                        break;
                    case "right":
                        image = right1;
                        break;
                }
                g2.drawImage(image, screenX, screenY, null);
                //To test collision boundaries
                g2.setColor(Color.red);
                g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);

            }
        }


