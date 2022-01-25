package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Booking extends JPanel {

    Thread appThread;
    private static JFrame frame;
    final int originalTileSize = 16;
    final int scale = 3;


    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public int bookingState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public UI ui;



    public Booking (){
        UI.initialize();
        UI.buttons();
        //UI.createJTextField();
        //createUI

    }

    public File generateBoardingPass() {

        return file;
    }

}
