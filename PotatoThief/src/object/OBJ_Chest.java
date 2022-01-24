package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Chest extends Entity {
        GamePanel gp;

    public OBJ_Chest(GamePanel gp) throws IOException {
        this.gp = gp;
        name = "Chest";
        down1 = ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\chest.png"));
    }
}
