package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp) throws IOException {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
    }

    public void getImage() throws IOException {

        up1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_up_1.png");
        up2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_up_2.png");
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_down_1.png");
        down2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_down_2.png");
        left1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_left_1.png");
        left2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_left_2.png");
        right1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_right_1.png");
        right2 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\NPC\\oldman_right_2.png");
    }
    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if ( i <= 25) {
                direction = "up";
            } else if (i >25 && i <= 50) {
                direction = "down";
            } else if ( i >50 && i < 75) {
                direction = "left";
            } else {
                direction = "right";
            }
            actionLockCounter = 0;
        }




    }

}
