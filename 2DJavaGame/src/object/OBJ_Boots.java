package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Boots extends Entity {

    public OBJ_Boots(GamePanel gp) {
        super(gp);
        name = "Boots";
        down1 = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\boots.png", gp.tileSize, gp.tileSize);

    }
}
