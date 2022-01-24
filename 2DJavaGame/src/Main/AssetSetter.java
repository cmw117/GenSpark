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


    }

    public void setMonster() throws IOException {
        gp.monster[0] = new Goblin(gp);
        gp.monster[0].worldX = gp.tileSize*5;
        gp.monster[0].worldY = gp.tileSize*5;

//        gp.monster[1] = new Goblin(gp);
//        gp.monster[1].worldX = gp.tileSize*5;
//        gp.monster[1].worldY = gp.tileSize*16;
//
//        gp.monster[2] = new Goblin(gp);
//        gp.monster[2].worldX = gp.tileSize*8;
//        gp.monster[2].worldY = gp.tileSize*12;
//
//        gp.monster[3] = new Goblin(gp);
//        gp.monster[3].worldX = gp.tileSize*14;
//        gp.monster[3].worldY = gp.tileSize*17;
//
//        gp.monster[4] = new Goblin(gp);
//        gp.monster[4].worldX = gp.tileSize*13;
//        gp.monster[4].worldY = gp.tileSize*15;
//
//
//        gp.monster[5] = new Goblin(gp);
//        gp.monster[5].worldX = gp.tileSize*10;
//        gp.monster[5].worldY = gp.tileSize*11;
//
//

    }
    public void setNPC() throws IOException {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*5;
        gp.npc[0].worldY = gp.tileSize*5;
    }
}
