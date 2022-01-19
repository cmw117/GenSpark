package monster;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Goblin extends Entity {

    public Goblin(GamePanel gp) throws IOException {
        super(gp);

        name = "Goblin";
        speed = 3;
        maxLife = 6;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 24;
        solidArea.width = 42;
        solidArea.height =30;
        //solidAreaDefaultX = solidArea.x;
        //solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() throws IOException {
        up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
        right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/monster/goblin.png")));
    }

  /*  public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100)+1;

            if (i < 25) {

            }
        }
*/


    }

