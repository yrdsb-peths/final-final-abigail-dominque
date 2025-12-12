import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DialogueWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DialogueWorld extends World
{
    
    /**
     * Constructor for objects of class DialogueWorld.
     * 
     */
    public DialogueWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 

        DialogueBox a = new DialogueBox ("I know my rent was gonna be late");
        addObject (a, 300, 550);
    }
}
