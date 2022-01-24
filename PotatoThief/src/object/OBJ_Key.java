package object;


import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Key extends Entity {
     GamePanel gp;
    public OBJ_Key(GamePanel gp) throws IOException {
        //super(gp);
        this.gp = gp;
        name = "Key";
        down1 = ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\key.png"));

    }
}
