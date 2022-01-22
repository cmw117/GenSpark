package object;

import Entity.Entity;
import Main.GamePanel;


public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        name = "Heart";
        image = setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_full.png", gp.tileSize, gp.tileSize);
        image2 =setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_half.png", gp.tileSize, gp.tileSize);
        image3=setup("C:\\GenSpark_repo\\2DJavaGame\\res\\Objects\\heart_blank.png", gp.tileSize, gp.tileSize);

    }
}
