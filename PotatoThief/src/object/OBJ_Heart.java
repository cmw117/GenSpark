package object;


import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OBJ_Heart extends Entity {
        GamePanel gp;
    public OBJ_Heart(GamePanel gp) throws IOException {
        this.gp = gp;
        name = "Heart";
        image = ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_full.png"));
        image2 = ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_half.png"));
        image3= ImageIO.read(new File("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_blank.png"));

    }
}
