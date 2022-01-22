package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Key extends Entity {

    public OBJ_Key(GamePanel gp) {
        super(gp);
        name = "Key";
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\key.png", gp.tileSize, gp.tileSize);

    }
}
