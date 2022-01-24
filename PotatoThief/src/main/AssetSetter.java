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

    }

}
