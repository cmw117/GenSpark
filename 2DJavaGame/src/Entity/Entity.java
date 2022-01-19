package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public String name;
    public int maxLife;
    public int life;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;


    public Entity(GamePanel gp) {
        this.gp = gp;

    }
   /* public BufferedImage setup(String imageName) {
        UtilityTool uTool = new UtilityTool();
    } */
}
