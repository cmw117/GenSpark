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

        screenX = gp.screenWidth/2 - (gp.tileSize - (gp.tileSize/2));
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 16, 32, 32);
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }

    public void setDefaultValues() {

        worldX = 1000;
        worldY = 1000;
        speed = 4;
        direction = "down";

        //PLAYER STATUS
        maxLife = 12;
        life = maxLife;
    }

    public void getPlayerImage() throws IOException {

        up1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_up_1.png", gp.tileSize, gp.tileSize);
        up2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_up_2.png", gp.tileSize, gp.tileSize);
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_down_1.png", gp.tileSize, gp.tileSize);
        down2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_down_2.png", gp.tileSize, gp.tileSize);
        left1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_left_1.png", gp.tileSize, gp.tileSize);
        left2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_left_2.png", gp.tileSize, gp.tileSize);
        right1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_right_1.png", gp.tileSize, gp.tileSize);
        right2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_right_2.png", gp.tileSize, gp.tileSize);
    }
    public void getPlayerAttackImage() {
        attackUp1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_up_1.png", gp.tileSize, gp.tileSize*2);
        attackUp2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_up_2.png", gp.tileSize, gp.tileSize*2);
        attackDown1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_down_1.png", gp.tileSize, gp.tileSize*2);
        attackDown2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_down_2.png", gp.tileSize, gp.tileSize*2);
        attackLeft1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_left_1.png", gp.tileSize*2, gp.tileSize);
        attackLeft2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_left_2.png", gp.tileSize*2, gp.tileSize);
        attackRight1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_right_1.png", gp.tileSize*2, gp.tileSize);
        attackRight2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Player\\boy_attack_right_2.png", gp.tileSize*2, gp.tileSize);
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

        if (attacking) {
            attacking();
        }
        else if ( keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.enterPressed)
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
        pickUpObject(objIndex);

        //CHECK NPC COLLISION
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //CHECK EVENT COLLISION
        gp.eHandler.checkEvent();


        //CHECK MONSTER COLLISION
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);

        int i = 0;

        //if collision is false, player can move
        if (collisionOn == false && !keyH.enterPressed) {
            switch(direction) {
                case "up":  worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break; }
        }
        gp.keyH.enterPressed = false;
        spriteCounter++;
//        if (spriteCounter > 12) {
//            if(spriteNum == 1) {
//                spriteNum = 2;
//            } else if (spriteNum == 2) {
//                spriteNum =1; }
//            spriteCounter = 0;
//        }
//        }
        if (invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
    public void attacking() {
        spriteCounter++;
        if ( spriteCounter <= 5) {
            spriteNum =1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum =2;
            //save to current worldx, worldy, solidarea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            switch(direction) {
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left":  worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
            }
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;


        }
        if(spriteCounter >25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
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
        public void interactNPC( int i) {
            if(gp.keyH.enterPressed) {
            if (i != 999) {
                    gp.gameState = gp.dialogueState;
                    gp.npc[i].speak();
                }
            } else {  attacking = true;  }
            }

        public void contactMonster(int i) {
            if(i != 999) {
                if (invincible = false) {
                    life -= 2;
                    invincible = true;
                }
            }
        }
        public void damageMonster(int i) {
            if (i != 999) {
                if (!gp.monster[i].invincible) {
                    gp.monster[i].life -= 4;
                    gp.monster[i].invincible = true;

                    if (gp.monster[i].life <= 0) {
                        gp.monster[i] = null;
                    }
                }
            }
        }

        public void draw (Graphics2D g2) {


                //g2.setColor(Color.white);
                //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

                BufferedImage image = null;
                int tempScreenX = screenX;
                int tempScreenY = screenY;

                switch (direction) {
                    case "up":
                        if(!attacking) {
                            if(spriteNum ==1) { image=up1; }
                            if(spriteNum ==2) { image = up2; }
                        }
                        if (attacking) {
                            tempScreenY = screenY - gp.tileSize;
                            if(spriteNum ==1) { image = attackUp1; }
                            if(spriteNum ==2) { image = attackUp2; }
                        }
                        break;
                    case "down":
                        if(!attacking) {
                            if(spriteNum ==1) { image = down2; }
                            if(spriteNum ==2) { image = down1; }
                        }
                        if (attacking) {
                            if(spriteNum ==1) { image = attackDown1; }
                            if(spriteNum ==2) { image = attackDown2; }
                        }
                        break;
                    case "left":
                        if(!attacking) {
                            if(spriteNum ==1) { image = left1; }
                            if(spriteNum ==2) { image = left2; }
                        }
                        if (attacking) {
                            tempScreenX = screenX - gp.tileSize;
                            if(spriteNum ==1) { image = attackLeft1; }
                            if(spriteNum ==2) { image = attackLeft2; }
                        }
                        break;
                    case "right":
                        if(!attacking) {
                            if(spriteNum ==1) { image = right1; }
                            if(spriteNum ==2) { image = right2; }
                        }
                        if (attacking) {
                            if(spriteNum ==1) { image = attackRight1; }
                            if(spriteNum ==2) { image = attackRight2; }
                        }
                        break;
                }
                if (invincible == true) {
                        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                }
                g2.drawImage(image, tempScreenX, tempScreenY, null);

                //reset alpha
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));


            }
        }


