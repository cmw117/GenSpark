package tile;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import javax.imageio.ImageIO;
//import static jdk.xml.internal.getResourceAsStream;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[11];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void getTileImage() {
            //DEBUG :System.out.println("loading images started");
            setup(0, "grass01", false);
            setup(1, "wall-2", true);
            setup(2, "water01", true);
            setup(3, "sand", false);
            setup(4, "tree", true);
            //tile[8] = new Tile();
            //tile[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/road-1.png")));
            //DEBUG: System.out.println("loading images finished");
    }
    public void setup(int index, String imagePath, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/" + imagePath + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (IOException e) { e.printStackTrace(); }

    }

    public void loadMap(String filePath) {
    	try {
    		InputStream is = getClass().getResourceAsStream(filePath);
    		BufferedReader br = new BufferedReader(new InputStreamReader(is));
    		int worldCol = 0;
    		int worldRow = 0;
    		
    		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
    			
    			String line = br.readLine();
    			
    			while (worldCol < gp.maxWorldCol) {
    				String numbers[] = line.split("");
    				int num = Integer.parseInt(numbers[worldCol]);
    				
    				mapTileNum[worldCol][worldRow] = num;
    				worldCol++;
    			}
    			if (worldCol == gp.maxWorldCol) {
    				worldCol = 0;
    				worldRow++;
    			}
    		} br.close();
    	} catch (Exception e) {
    		
    	}
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow <gp.maxWorldRow) {
        	
        	int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;
           //x += gp.tileSize;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }
    }
}
