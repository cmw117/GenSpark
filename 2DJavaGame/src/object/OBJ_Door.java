package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends Entity {

    public OBJ_Door(GamePanel gp) {
        super(gp);
        name = "Door";
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\door.png", gp.tileSize, gp.tileSize);
        collision = true;
    }
}
