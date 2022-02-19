package AdvancedHangmanUpdated;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class LetterTile extends JLabel
{

    private final char IMAGE_LETTER;
    private final String IMAGE_DIRECTORY;
    private final String IMAGE_TYPE;
    private final int PREFERRED_WIDTH;
    private final int PREFERRED_HEIGHT;
    

     // The current path of the current image.

    private String path;
    private BufferedImage image;
    private MouseListener tileListener;


    public LetterTile() { this('a', "images/", ".png"); }
    
    /**
     * Creates a new LetterTile given the letter to be displayed, the directory
     * of the letter image series, and the image type.
     * @param imageLetter The letter to be displayed on the tile.
     * @param imageDirectory The directory holding the letter images.
     * @param imageType The type of the letter images.
     */
    public LetterTile(char imageLetter, String imageDirectory, String imageType)
    {
        IMAGE_LETTER = imageLetter;
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;
        
        PREFERRED_WIDTH = PREFERRED_HEIGHT = 50;
        
        setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
        path = IMAGE_DIRECTORY + IMAGE_LETTER + IMAGE_TYPE;
        image = loadImage(path);
    }
    

    private BufferedImage loadImage(String imagePath)
    {
        BufferedImage img = null;

        try 
        {
            img = ImageIO.read(new File(imagePath));
        } 

        catch (IOException ex) 
        {
            System.err.println("loadImage(): Error: Image at "
                    + imagePath + " could not be found");
            System.exit(1);
        }

        return img;
    }
    
    /**
     * Changes the tile's appearance and removes the mouse listener to prevent
     * the tile from being clicked again.
     * @return The tile's letter.
     */
    public char guess() 
    { 
        loadNewImage("guessed");
        removeTileListener();
        return IMAGE_LETTER;
    }
    
    /**
     * Loads a new image in the hangman image series.
     * @param suffix The suffix of the image name.
     */
    private void loadNewImage(String suffix)
    {
        path = IMAGE_DIRECTORY + IMAGE_LETTER + "_" + suffix + IMAGE_TYPE;
        image = loadImage(path);
        repaint();  
    }
    
    /**
     * Add a TileListener to the tile.
     * @param l The MouseListener to attach as a TileListener
     */
    public void addTileListener(MouseListener l) 
    { 
        tileListener = l;
        addMouseListener(tileListener);
    }
    
    /**
     * Remove the tile's TileListener.
     */
    public void removeTileListener() { removeMouseListener(tileListener); }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image, 
                0, 
                0, 
                PREFERRED_WIDTH, 
                PREFERRED_HEIGHT, 
                null);
    }
}