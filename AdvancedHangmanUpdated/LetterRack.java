package AdvancedHangmanUpdated;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class LetterRack extends JPanel
{

    private final int RACK_COLS;
    private final int RACK_ROWS;
    private final GridLayout LETTER_RACK_LAYOUT;
    private final int CAPACITY;
    
    //IMAGE source folder
    private final String IMAGE_DIRECTORY;
    
    //image type
    private final String IMAGE_TYPE;
    private final String password;
    //alphabet
    private final ArrayList<LetterTile> rack;
    

    public LetterRack()
    {
        this("password", "images/", ".png");
    }
    
    /**
     * Creates a new LetterRack given the password to be guessed, letter image
     * directory, and letter image type
     * @param inPassword The password to be guessed.
     * @param imageDirectory The directory of the letter images.
     * @param imageType The type of the letter images.
     */
    public LetterRack(String inPassword, String imageDirectory, 
            String imageType)
    {
        RACK_COLS = 8;
        RACK_ROWS = 3;
        LETTER_RACK_LAYOUT = new GridLayout(RACK_ROWS, RACK_COLS);
        LETTER_RACK_LAYOUT.setVgap(10);
        CAPACITY = RACK_ROWS * RACK_COLS;
        
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;
        
        rack = new ArrayList<>();
        password = inPassword;
        
        // add a little padding to make sure the letter rack is centered
        setBorder(BorderFactory.createEmptyBorder(10, 17, 10, 10));
        setLayout(LETTER_RACK_LAYOUT);
        loadRack();
    }
    
    /**
     * Builds and loads the letter rack with letter tiles.
     */
    private void loadRack()
    {
        buildRack();
        for (LetterTile tile : rack)
            add(tile);
    }
    
    /**
     * Builds a letter rack from a blend of the password and random letters.
     * will work if screen size needs to be smaller
     * set to ensure the letters in the password are included even if program
     * cannot contain the full alphabet (adjust rows/columns as needed)
     * width and height of the panel as well
     */
    private void buildRack()
    {
        StringBuilder passwordBuilder = 
                new StringBuilder(password.toLowerCase());
        ArrayList<Character> tiles = new ArrayList<>(); // cannot use char
        Random rand = new Random();
        int i = 0, j = 0;
        
        // add the password letters to the rack
        //useful for if not enough space is available to display the entire alphabet
        while (passwordBuilder.length() > 0)
        {
            // want to make sure that no letters are repeated in tile rack
            if (!tiles.contains(passwordBuilder.charAt(0)))
            {
                tiles.add(passwordBuilder.charAt(0));
                i++;
            }
            passwordBuilder.deleteCharAt(0);
        }
        
        // add random values to fill the remainder of the rack
        for (; i < CAPACITY; i++)
        {
            Character c = 'a'; // 'a' is just a default value
            do
            {
                c = (char) (rand.nextInt(26) + 'a');
            } while (tiles.contains(c));
            tiles.add(c);
        }
        
        // grab random tiles from the ArrayList to display randomly on the
        //    GameBoard
        for (i = 0; i < CAPACITY; i++)
        {
            j = rand.nextInt(tiles.size());
            rack.add(new LetterTile(tiles.get(j), 
                    IMAGE_DIRECTORY, 
                    IMAGE_TYPE));
            tiles.remove(j);
        }
    }
    
    //tile listener for letter images
    public void attachListeners(MouseListener l)
    {
        for (LetterTile tile : rack)
            tile.addTileListener(l);
    }

    public void removeListeners()
    {
        for (LetterTile tile : rack)
            tile.removeTileListener();
    }
}