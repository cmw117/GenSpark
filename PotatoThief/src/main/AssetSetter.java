package main;

import entity.Goblin;

import java.io.IOException;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() throws IOException {
        gp.obj[0] = new Goblin(gp);
        gp.obj[0].worldX = gp.tileSize*5;
        gp.obj[0].worldY = gp.tileSize*5;

        gp.obj[1] = new Goblin(gp);
        gp.obj[1].worldX = gp.tileSize*2;
        gp.obj[1].worldY = gp.tileSize*3;

        gp.obj[2] = new Goblin(gp);
        gp.obj[2].worldX = gp.tileSize*8;
        gp.obj[2].worldY = gp.tileSize*9;

        gp.obj[3] = new Goblin(gp);
        gp.obj[3].worldX = gp.tileSize*6;
        gp.obj[3].worldY = gp.tileSize*5;

        gp.obj[4] = new Goblin(gp);
        gp.obj[4].worldX = gp.tileSize*3;
        gp.obj[4].worldY = gp.tileSize*4;

    }

}
