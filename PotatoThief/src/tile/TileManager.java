package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNum;

    public TileManager(GamePanel gp) throws IOException {

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }
    public void loadMap() {
        try {
            InputStream is = new FileInputStream("C:\\GenSpark_repo\\PotatoThief\\images\\maps\\maps.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while ( col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while (col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTileImage() {

        try {

            // 0 is earth 1 is grass
            // 2 is thewall 3 is tree
            // 4 is water

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("\\PotatoThief\\images\\artwork\\tiles\\earth.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("\\PotatoThief\\images\\artwork\\tiles\\grass.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("\\PotatoThief\\images\\artwork\\tiles\\thewall.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("\\PotatoThief\\images\\artwork\\tiles\\tree.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("\\PotatoThief\\images\\artwork\\tiles\\water.png"));
            tile[4].collision = true;

        } catch (IOException e) {   e.printStackTrace(); }
    }

    public void draw(Graphics2D g2) {

       // g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if( col == gp.maxScreenCol) {
                col = 0;
                x= 0;
                row++;
                y += gp.tileSize;
            }
        }

    }
}
