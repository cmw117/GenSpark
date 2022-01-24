package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Potato extends Entity {

    GamePanel gp;
    public OBJ_Potato(GamePanel gp) throws IOException {
        //super(gp);
        this.gp = gp;
        name = "Key";
        down1 = ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\potato.png"));

    }
}


