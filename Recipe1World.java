import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Recipe1World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recipe1World extends World
{
    private DialogueBox dialogue;

    public Recipe1World()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        Exit exit = new Exit();
        addObject(exit, 950, 50);
        
        CookingPotTop pot = new CookingPotTop();
        addObject(pot, 500, 350);
        
        String[] text;
        text = new String[] {
            "Let's make sugar cookies!",
            "Drag the ingredients into the pot."
        };
        
        dialogue = new DialogueBox(text);
        addObject(dialogue, 500, 600);
    }
}
