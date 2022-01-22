package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Chest extends Entity {


    public OBJ_Chest(GamePanel gp) {
        super(gp);
        name = "Chest";
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\chest.png", gp.tileSize, gp.tileSize);
    }
}
