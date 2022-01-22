package Main;

import Entity.NPC_OldMan;
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
        gp.obj[1].worldY = 23 * gp.tileSize;

        gp.obj[2] = new OBJ_Door(gp);
        gp.obj[2].worldX = 21 * gp.tileSize;
        gp.obj[2].worldY = 27 * gp.tileSize;


        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 12 * gp.tileSize;
        gp.obj[3].worldY = 22 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest(gp);
        gp.obj[4].worldX = 23 * gp.tileSize;
        gp.obj[4].worldY = 40 * gp.tileSize;

        gp.obj[5] = new OBJ_Boots(gp);
        gp.obj[5].worldX = 4 * gp.tileSize;
        gp.obj[5].worldY = 15 * gp.tileSize;

        gp.obj[6] = new OBJ_Key(gp);
        gp.obj[6].worldX = 18 * gp.tileSize;
        gp.obj[6].worldY = 18 * gp.tileSize;

        gp.obj[7] = new OBJ_Key(gp);
        gp.obj[7].worldX = 16 * gp.tileSize;
        gp.obj[7].worldY = 15 * gp.tileSize;
    }

    public void setMonster() throws IOException {
        gp.monster[0] = new Goblin(gp);
        gp.monster[0].worldX = gp.tileSize*5;
        gp.monster[0].worldY = gp.tileSize*5;

        gp.monster[1] = new Goblin(gp);
        gp.monster[1].worldX = gp.tileSize*5;
        gp.monster[1].worldY = gp.tileSize*16;

        gp.monster[2] = new Goblin(gp);
        gp.monster[2].worldX = gp.tileSize*8;
        gp.monster[2].worldY = gp.tileSize*20;

        gp.monster[3] = new Goblin(gp);
        gp.monster[3].worldX = gp.tileSize*21;
        gp.monster[3].worldY = gp.tileSize*17;

        gp.monster[4] = new Goblin(gp);
        gp.monster[4].worldX = gp.tileSize*13;
        gp.monster[4].worldY = gp.tileSize*15;

        gp.monster[5] = new Goblin(gp);
        gp.monster[5].worldX = gp.tileSize*7;
        gp.monster[5].worldY = gp.tileSize*12;

        gp.monster[6] = new Goblin(gp);
        gp.monster[6].worldX = gp.tileSize*4;
        gp.monster[6].worldY = gp.tileSize*20;

        gp.monster[7] = new Goblin(gp);
        gp.monster[7].worldX = gp.tileSize*18;
        gp.monster[7].worldY = gp.tileSize*21;

        gp.monster[8] = new Goblin(gp);
        gp.monster[8].worldX = gp.tileSize*12;
        gp.monster[8].worldY = gp.tileSize*8;

        gp.monster[9] = new Goblin(gp);
        gp.monster[9].worldX = gp.tileSize*9;
        gp.monster[9].worldY = gp.tileSize*20;

        gp.monster[10] = new Goblin(gp);
        gp.monster[10].worldX = gp.tileSize*7;
        gp.monster[10].worldY = gp.tileSize*20;


        gp.monster[11] = new Goblin(gp);
        gp.monster[11].worldX = gp.tileSize*5;
        gp.monster[11].worldY = gp.tileSize*21;


    }
    public void setNPC() throws IOException {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
    }
}
