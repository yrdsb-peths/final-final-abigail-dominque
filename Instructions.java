import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        MushroomBigNPC mushroom = new MushroomBigNPC();
        addObject(mushroom, getHeight() / 2, getWidth() / 2);
        
        String [] text1 = {
            "Welcome to Fairyland!"
        };
        
        DialogueBox txt1 = new DialogueBox(text1);
        addObject(txt1, getWidth() / 2, 500);
    }
}
