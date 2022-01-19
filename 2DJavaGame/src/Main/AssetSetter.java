package Main;

import monster.Goblin;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

import java.io.IOException;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 23* gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Door(gp);
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;


        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 9 * gp.tileSize;

        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 12 * gp.tileSize;
        gp.obj[3].worldY = 22 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest(gp);
        gp.obj[4].worldX = 23 * gp.tileSize;
        gp.obj[4].worldY = 40 * gp.tileSize;



        gp.obj[6] = new OBJ_Boots(gp);
        gp.obj[6].worldX = 37 * gp.tileSize;
        gp.obj[6].worldY = 42 * gp.tileSize;
    }

    public void setMonster() throws IOException {
        gp.monster[0] = new Goblin(gp);
        gp.monster[0].worldX = gp.tileSize*23;
        gp.monster[0].worldY = gp.tileSize*26;

        gp.monster[1] = new Goblin(gp);
        gp.monster[1].worldX = gp.tileSize*23;
        gp.monster[1].worldY = gp.tileSize*26;

        gp.monster[2] = new Goblin(gp);
        gp.monster[2].worldX = gp.tileSize*37;
        gp.monster[2].worldY = gp.tileSize*26;


        gp.monster[3] = new Goblin(gp);
        gp.monster[3].worldX = gp.tileSize*43;
        gp.monster[3].worldY = gp.tileSize*26;


        gp.monster[4] = new Goblin(gp);
        gp.monster[4].worldX = gp.tileSize*23;
        gp.monster[4].worldY = gp.tileSize*36;
    }
}
