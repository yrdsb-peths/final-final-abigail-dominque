import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        MushroomBigNPC mushroom = new MushroomBigNPC();
        addObject(mushroom, getHeight() / 2, getWidth() / 2);
    }
}
